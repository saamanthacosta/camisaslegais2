package br.com.camisaslegais.filtro;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import br.com.camisaslegais.modelo.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.FilterConfig;

@WebFilter("/*")
public class FiltroConexao implements Filter {
    // implementação do init e destroy, se necessário

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        try {
          Connection connection = new ConnectionFactory().getConnection();

          // pendurando a connection na requisição            
          request.setAttribute("conexao", connection);

          chain.doFilter(request, response);

          connection.close();
          
      } catch (SQLException e) {
          throw new ServletException(e);
      }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}