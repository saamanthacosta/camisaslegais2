package br.com.camisaslegais.controlador.usuario;

import br.com.camisaslegais.beans.AvaliacaoUsuario;
import br.com.camisaslegais.beans.Carrinho;
import br.com.camisaslegais.beans.Item;
import br.com.camisaslegais.beans.Produto;
import br.com.camisaslegais.beans.Usuario;
import br.com.camisaslegais.modelo.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loja", urlPatterns = {"/loja"})
public class LojaServlet extends HttpServlet {
    RequestDispatcher rd;
    List<Produto> produtos = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        
        Connection connection = new ConnectionFactory().getConnection();
        ProdutoDAO produtoDAO = new ProdutoDAO(connection);
        AvaliacaoUsuarioDAO avaliacaoDAO = new AvaliacaoUsuarioDAO(connection);
        
        String action = request.getParameter("action");
        
        HttpSession sessao = request.getSession();
        if (action == null) action = "loja";
    
        switch(action){
        case "visualizar":
            request.setAttribute("produto",produtoDAO.buscarPorId(Integer.parseInt(request.getParameter("id")))); 
//            request.setAttribute("avaliacao",avaliacaoDAO.listarFavoritosProduto(Integer.parseInt(request.getParameter("id"),sessao.))); 
            rd = request.getRequestDispatcher("produto.jsp");
            break;  
        default:
            request.setAttribute("listarProdutos",produtoDAO.buscarTodos()); 
            rd = request.getRequestDispatcher("produtos.jsp"); 
            break;
        }  
        
        try {
            connection.close();
         } 
        catch (SQLException ex) {
            Logger.getLogger(LojaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      
    Connection conn = new ConnectionFactory().getConnection();
    String action = request.getParameter("action");
    AvaliacaoUsuarioDAO avaliacaoDAO = new AvaliacaoUsuarioDAO(conn);
    HttpSession sessao = request.getSession();
    Carrinho carrinhoLocal;

    
    AvaliacaoUsuario avaliacao = new AvaliacaoUsuario();
    Usuario usuario = new Usuario();
    Produto produto = new Produto();
     
//    produto.setId(Integer.parseInt(request.getParameter("produto")));
//    String verifica = (String) request.getSession().getAttribute("usuario.id");
//    if (verifica==null){
//        response.sendRedirect("login.jsp");
//    }
//    else{
//        usuario.setId(Integer.parseInt(verifica));
//    }
//    avaliacao.setUsuario(usuario);
//    avaliacao.setProduto(produto);

    ProdutoDAO dao = new ProdutoDAO(conn);
    produto = dao.buscarPorId(Integer.parseInt(request.getParameter("produto")));
    int quantidade = Integer.parseInt(request.getParameter("quantidade"));
    Item itemCarrinho = new Item();
    
    switch(action){
        case "avaliacao":
            avaliacaoDAO.inserir(avaliacao);
            break;
        case "adicionarProduto":
            if (request.getSession().getAttribute("carrinho") == null) {
                carrinhoLocal = new Carrinho();
            } else {
                carrinhoLocal = (Carrinho) request.getSession().getAttribute("carrinho");
                List<Item> itens  = new ArrayList(carrinhoLocal.getItens());
                for (Item item: itens){
                    if (item.getProduto().getId() == produto.getId()){
                        itemCarrinho = item;
                        quantidade += item.getQuantidade();
                    }
                }
            }
            
            itemCarrinho.setProduto(produto);
            itemCarrinho.setQuantidade(quantidade);
            itemCarrinho.calculaTotal();
            
            carrinhoLocal.addItens(itemCarrinho);
            carrinhoLocal.calculaTotal();
            request.getSession().setAttribute("carrinho", carrinhoLocal);
            break;
    }
    
    try {
        conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(AvaliacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    response.sendRedirect("loja");
  }
    
   private void adicionaProduto(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Connection connection = (Connection) request.getAttribute("conexao");
    Item item = new Item();
    ProdutoDAO produtoDAO = new ProdutoDAO(connection);
    Carrinho carrinhoLocal;

    if (request.getSession().getAttribute("carrinho") == null) {
      carrinhoLocal = new Carrinho();
    } else {
      carrinhoLocal = (Carrinho) request.getSession().getAttribute("carrinho");
    }
    
    Produto produto = (Produto) produtoDAO.buscarPorId(Integer.valueOf(request.getParameter("idProduto")));
    item.setProduto(produto);
    item.setQuantidade((int) request.getSession().getAttribute("quantidade"));
    item.calculaTotal();
    carrinhoLocal.addItens(item);
    carrinhoLocal.calculaTotal();
    request.getSession().setAttribute("carrinho", carrinhoLocal);
    response.sendRedirect("carrinho");

  }
}