///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.camisaslegais.controlador.usuario;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.List;
//import br.com.camisaslegais.modelo.ConnectionFactory;
//import br.com.camisaslegais.modelo.FavoritosUsuarioDAO;
//import br.com.camisaslegais.beans.FavoritosUsuario;
//import java.sql.Connection;
//
//
//@WebServlet(name = "FavoritosServlet", urlPatterns = {"/favoritos"})
//public class FavoritosServlet extends HttpServlet {
//
// 
//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//          throws ServletException, IOException {
//    
//    Connection connection = new ConnectionFactory().getConnection();
//    FavoritosUsuarioDAO dao = new FavoritosUsuarioDAO(connection);
//    List<FavoritosUsuario> listaFavoritos = dao.listarFavoritos((Integer) request.getSession().getParameter("usuario.id"));
//    request.getSession().setAttribute("listaFavoritos", listaFavoritos);     
//    request.getRequestDispatcher("favoritos.jsp").forward(request, response);
//  }
//
//  
//  @Override
//  protected void doPost(HttpServletRequest request, HttpServletResponse response)
//          throws ServletException, IOException {
//      if (request.getParameter("action") == "removerFavorito") {
//        Connection connection = new ConnectionFactory().getConnection();
//        FavoritosUsuarioDAO dao = new FavoritosUsuarioDAO(connection);
//        dao.removerFavorito((Integer) request.getSession().getParameter("usuario.id"), (Integer) request.getParameter("id"));
//      }
//    request.getRequestDispatcher("favoritos.jsp").forward(request, response);
//  }
//
//}
