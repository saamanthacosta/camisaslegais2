package br.com.camisaslegais.controlador.usuario;

import br.com.camisaslegais.modelo.UsuarioDAO;
import br.com.camisaslegais.beans.Carrinho;
import br.com.camisaslegais.beans.Produto;
import br.com.camisaslegais.beans.Usuario;
import br.com.camisaslegais.modelo.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet para lidar com o login de usuários
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    Connection connection = new ConnectionFactory().getConnection();
    String email = request.getParameter("usuarioEmail");
    String senha = request.getParameter("usuarioSenha");
    UsuarioDAO dao = new UsuarioDAO(connection);
    Usuario usuario = dao.login(email, senha);
        
    HttpSession sessao = request.getSession();

    if (usuario.getId() != 0) { 
        sessao.setAttribute("usuario", usuario);
        sessao.setAttribute("usuario-nome", usuario.getNome());
        if (usuario.isAdmin()) {
            sessao.setAttribute("usuario-perfil", "admin");
            response.sendRedirect("dashboard.jsp");
        } else {
            sessao.setAttribute("usuario-perfil", "cliente");
            if (sessao.getAttribute("carrinho") == null) {
                sessao.setAttribute("carrinho", new ArrayList<Produto>());
                sessao.setAttribute("totalCarrinho", 0);
            }
            response.sendRedirect("index.jsp");
        }
    } else {
        sessao.invalidate();
        response.sendRedirect("usuarioInvalido.jsp");
    }
  }
}