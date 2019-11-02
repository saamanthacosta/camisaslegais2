package br.com.camisaslegais.modelo;

import br.com.camisaslegais.beans.Endereco;
import br.com.camisaslegais.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {
  private Connection conn;
  private ResultSet resultSet;
  private PreparedStatement stmt;
  
  public UsuarioDAO(Connection conn) {
    this.conn = conn;
  }

  public Usuario login(String email,String senha) {
    String sql = "SELECT * FROM usuario WHERE email=? AND senha=?"; 
    Usuario usuario = new Usuario();
    Endereco endereco = new Endereco ();
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, email);
      stmt.setString(2, senha);
      resultSet = stmt.executeQuery();      
      if (resultSet.next()) {
        usuario.setId(resultSet.getInt("id"));
        endereco.setLogradouro(resultSet.getString("logradouro"));
        endereco.setCep(resultSet.getString("cep"));
        endereco.setComplemento(resultSet.getString("complemento"));
        endereco.setBairro(resultSet.getString("bairro"));
        endereco.setCidade(resultSet.getString("cidade"));
        endereco.setUf(resultSet.getString("uf"));
        usuario.setEndereco(endereco);
        usuario.setNome(resultSet.getString("nome"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setSenha(resultSet.getString("senha"));
        usuario.setAdmin(resultSet.getBoolean("admin"));
      } else {
        usuario.setId(0);
        return usuario;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuario;
  }
  
  @Override
  public Usuario buscarPorId(int id) {
    String sql = "SELECT * FROM usuario WHERE id=?";
    Usuario usuario = new Usuario();
    Endereco endereco = new Endereco ();    
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      resultSet = stmt.executeQuery();      
      if (resultSet.next()) {
        usuario.setId(resultSet.getInt("id"));        
        usuario.setNome(resultSet.getString("nome"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setSenha(resultSet.getString("senha"));
        endereco.setLogradouro(resultSet.getString("logradouro"));
        endereco.setCep(resultSet.getString("cep"));
        endereco.setComplemento(resultSet.getString("complemento"));
        endereco.setBairro(resultSet.getString("bairro"));
        endereco.setCidade(resultSet.getString("cidade"));
        endereco.setUf(resultSet.getString("uf"));
        usuario.setEndereco(endereco);
      }      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuario;
  }

  @Override
  public List<Usuario> buscarTodos() {
      String sql = "SELECT * FROM usuario ORDER BY id DESC";
      List<Usuario> usuarios = new ArrayList<>();
      try {
      stmt = conn.prepareStatement(sql);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        Usuario usuario = new Usuario(); 
        Endereco endereco = new Endereco ();   
        usuario.setId(resultSet.getInt("id"));        
        usuario.setNome(resultSet.getString("nome"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setSenha(resultSet.getString("senha"));
        endereco.setLogradouro(resultSet.getString("logradouro"));
        endereco.setCep(resultSet.getString("cep"));
        endereco.setComplemento(resultSet.getString("complemento"));
        endereco.setBairro(resultSet.getString("bairro"));
        endereco.setCidade(resultSet.getString("cidade"));
        endereco.setUf(resultSet.getString("uf"));
        usuario.setEndereco(endereco);
        usuarios.add(usuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

  @Override
  public void inserir(Usuario usuario) {
    String sql = "INSERT INTO usuario(nome, email, senha, admin, logradouro, cep, complemento, bairro, cidade, uf) VALUES(?,?,?,?,?,?,?,?,?,?)";
    try {
      stmt = this.conn.prepareStatement(sql);
      stmt.setString(1, usuario.getNome());
      stmt.setString(2, usuario.getEmail());
      stmt.setString(3, usuario.getSenha());
      stmt.setBoolean(4, false);
      stmt.setString(5, usuario.getEndereco().getLogradouro());
      stmt.setString(6, usuario.getEndereco().getCep());
      stmt.setString(7, usuario.getEndereco().getComplemento());
      stmt.setString(8, usuario.getEndereco().getBairro());
      stmt.setString(9, usuario.getEndereco().getCidade());
      stmt.setString(10, usuario.getEndereco().getUf());
      stmt.executeUpdate();
      stmt.close();   
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void alterar(Usuario usuario) {
    String sql = "UPDATE usuario SET nome=?, email=?, senha=?, admin=?,logradouro=?, cep=?, complemento=?, bairro=?, cidade=?, uf=? WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, usuario.getNome());
      stmt.setString(2, usuario.getEmail());
      stmt.setString(3, usuario.getSenha());
      stmt.setBoolean(4, usuario.isAdmin());
      stmt.setString(5, usuario.getEndereco().getLogradouro());
      stmt.setString(6, usuario.getEndereco().getCep());
      stmt.setString(7, usuario.getEndereco().getComplemento());
      stmt.setString(8, usuario.getEndereco().getBairro());
      stmt.setString(9, usuario.getEndereco().getCidade());
      stmt.setString(10, usuario.getEndereco().getUf());
      stmt.setInt(11, usuario.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  @Override
  public void remover(int id) {
    String sql = "DELETE FROM usuario WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}