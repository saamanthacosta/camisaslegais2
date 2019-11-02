package br.com.camisaslegais.controlador.usuario;

import br.com.camisaslegais.beans.Endereco;
import br.com.camisaslegais.beans.Usuario;
import br.com.camisaslegais.modelo.ConnectionFactory;
import br.com.camisaslegais.modelo.UsuarioDAO;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cadastro", urlPatterns = {"/cadastro"})
public class CadastroServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    request.getRequestDispatcher("cadastro.jsp").forward(request, response);
  }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        Endereco endereco = new Endereco();
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        endereco.setLogradouro(request.getParameter("logradouro"));
        endereco.setComplemento(request.getParameter("complemento"));
        endereco.setCep(request.getParameter("cep"));
        endereco.setBairro(request.getParameter("bairro"));
        endereco.setCidade(request.getParameter("cidade"));
        endereco.setUf(request.getParameter("uf"));
        usuario.setEndereco(endereco);

        Connection connection = new ConnectionFactory().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        usuarioDAO.inserir(usuario);
        response.sendRedirect("/camisaslegais");
        
    }
  
}
