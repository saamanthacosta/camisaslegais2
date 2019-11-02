//package br.com.camisaslegais.controlador.usuario;
//
//import br.com.camisaslegais.beans.Carrinho;
//import br.com.camisaslegais.modelo.ConnectionFactory;
//import br.com.camisaslegais.modelo.DAO;
//import br.com.camisaslegais.modelo.PedidoDAO;
//import java.io.IOException;
//import java.sql.Connection;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "PagamentoServlet", urlPatterns = {"/pagamento"})
//public class PagamentoServlet extends HttpServlet {
//
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//          throws ServletException, IOException {
//    request.getRequestDispatcher("pagamento.jsp").forward(request, response);        
//  }
//
//  @Override
//  protected void doPost(HttpServletRequest request, HttpServletResponse response)
//          throws ServletException, IOException {
//    
//        if (request.getParameter("action") == "confirmaCompra") {
//            Connection connection = new ConnectionFactory().getConnection();
//            //TODO: Carrinho carrinho ???
//            PedidoDAO pedido = new PedidoDAO(connection);
//            Carrinho carrinho = new Ca
//            pedido.removeEstoque(carrinho);
//            
////        }
//        request.getRequestDispatcher("pagamentoConfirmado.jsp").forward(request, response);
//  }
//}
