package br.com.camisaslegais.controlador.admin;

import br.com.camisaslegais.modelo.ProdutoDAO;
import br.com.camisaslegais.beans.Produto;
import br.com.camisaslegais.modelo.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "IndexAdminServlet", urlPatterns = {"/dashboard"})
public class IndexAdminServlet extends HttpServlet {
    
    private static String INSERIR = "inserirCamisa.jsp";
    private static String EDITAR = "editarCamisa.jsp";
    private static String DASHBOARD = "dashboard.jsp";
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
           
    RequestDispatcher rd;
    Connection conn = new ConnectionFactory().getConnection();
    String logica = request.getParameter("logica");
    ProdutoDAO dao = new ProdutoDAO(conn);
    
    if (logica == null) logica = "dashboard";
    
    switch(logica){
        case "inserir":
            rd = request.getRequestDispatcher(INSERIR);
            break;
        case "editar":
            request.setAttribute("produto", dao.buscarPorId(Integer.parseInt(request.getParameter("id"))));
            rd = request.getRequestDispatcher(EDITAR);
            break;
        case "remover":
            int id = Integer.parseInt(request.getParameter("id"));
            dao.remover(id);
            request.setAttribute("listaProdutos", dao.buscarTodos()); 
            rd = request.getRequestDispatcher(DASHBOARD);
            break;
        default:
            request.setAttribute("listaProdutos", dao.buscarTodos()); 
            rd = request.getRequestDispatcher(DASHBOARD);
            break;
    }
    try {
        conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(IndexAdminServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    rd.forward(request, response);

  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      
    Connection conn = new ConnectionFactory().getConnection();
    String logica = request.getParameter("logica");
    ProdutoDAO dao = new ProdutoDAO(conn);
    
    Produto produto = new Produto();
    produto.setNome(request.getParameter("nomeCamisaNV"));
    produto.setImagem(request.getParameter("fotoCamisaNV"));
    produto.setQuantidade(Integer.parseInt(request.getParameter("qtdCamisaNV")));
    produto.setPreco(Double.parseDouble(request.getParameter("precoCamisaNV")));
    
    switch(logica){
        case "inserir":
            dao.inserir(produto);
            break;
        case "editar":
            dao.alterar(produto);
            break;
    }
    
    logica = null;
    try {
        conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(IndexAdminServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    response.sendRedirect("dashboard");
  }

}