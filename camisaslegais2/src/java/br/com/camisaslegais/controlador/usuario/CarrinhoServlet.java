package br.com.camisaslegais.controlador.usuario;

import br.com.camisaslegais.beans.Carrinho;
import br.com.camisaslegais.beans.Item;
import br.com.camisaslegais.beans.Pedido;
import br.com.camisaslegais.beans.Produto;
import br.com.camisaslegais.modelo.ProdutoDAO;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarrinhoServlet", urlPatterns = { "/carrinho" })
public class CarrinhoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    String action = request.getParameter("action");
    if (action == null) action = "mostraCarrinho";

    switch (action) {
        case "mostraCarrinho":
          mostraCarrinho(request, response);
          break;
        default:
            mostraCarrinho(request, response);
          break;
        }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action = request.getParameter("action");
      if (action == null) action = "mostraCarrinho";
      switch (action) {
        case "mostraCarrinho":
          mostraCarrinho(request, response);
          break;
        case "alteraQuantidade":
          alteraQuantidade(request, response);
          break;
        case "removeProduto":
          removeProduto(request, response);
          break;
      }
  }

  private void mostraCarrinho(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    if (request.getSession().getAttribute("carrinho") == null) {
      Carrinho carrinhoLocal = new Carrinho();
      request.getSession().setAttribute("carrinho", carrinhoLocal);
    }
    request.getRequestDispatcher("carrinho.jsp").forward(request, response);
  }

  private void alteraQuantidade(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
    Connection connection = (Connection) request.getAttribute("conexao");
    ProdutoDAO produtoDAO = new ProdutoDAO(connection);
    
    if (request.getSession().getAttribute("carrinho") == null) {
      request.getRequestDispatcher("loja").forward(request, response);
    }
    if (request.getParameter("quantidade").equals("0")) {
      removeProduto(request, response);
    } else {
      Carrinho carrinhoLocal = (Carrinho) request.getSession().getAttribute("carrinho");
      int indexItem = Integer.valueOf(request.getParameter("posicao"));
      int quantidade = Integer.valueOf(request.getParameter("quantidade"));
      ((carrinhoLocal.getItens()).get(indexItem)).setQuantidade(quantidade);
      ((carrinhoLocal.getItens()).get(indexItem)).calculaTotal();
      carrinhoLocal.calculaTotal();
      request.getSession().setAttribute("carrinho", carrinhoLocal);
      mostraCarrinho(request, response);
    }
    
  }

  private void removeProduto(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getSession().getAttribute("carrinho") == null) {
      request.getRequestDispatcher("loja").forward(request, response);
    }
    Carrinho carrinhoLocal = (Carrinho) request.getSession().getAttribute("carrinho");
    int indexItem = Integer.valueOf(request.getParameter("posicao"));
    (carrinhoLocal.getItens()).remove(indexItem);
    carrinhoLocal.calculaTotal();
    request.getSession().setAttribute("carrinho", carrinhoLocal);
    mostraCarrinho(request, response);
  }
}