package br.com.camisaslegais.modelo;

import br.com.camisaslegais.beans.FavoritosUsuario;
import br.com.camisaslegais.beans.Item;
import br.com.camisaslegais.beans.Produto;
import br.com.camisaslegais.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoritosUsuarioDAO implements DAO<FavoritosUsuario> {
  
  private Connection conn;
  private ConnectionFactory cf = new ConnectionFactory();
  private ResultSet resultSet;
  private PreparedStatement stmt;

  public FavoritosUsuarioDAO(Connection conn){
    this.conn = cf.getConnection();
  }
  
  public List<FavoritosUsuario> listarFavoritos(int idUsuario) {
      String sql = "SELECT * FROM favoritos_usuario WHERE id_usuario=?";
      List<FavoritosUsuario> favoritos = new ArrayList<>();
      try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, idUsuario);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        FavoritosUsuario favorito = new FavoritosUsuario();
        Produto produto = new Produto();
        favorito.setId(resultSet.getInt("id"));        
        produto.setId(resultSet.getInt("id_produto")); 
        favorito.setProduto(produto);
        favoritos.add(favorito);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return favoritos;
  }
  
  public void adicionarFavorito(int idUsuario, int idProduto) {
    String sql = "INSERT INTO favoritos_usuario id_produto=? WHERE id_usuario=?";
    try {
     		  stmt = conn.prepareStatement(sql);
      		stmt.setInt(1, idProduto);
     		  stmt.setInt(2, idUsuario);
      		stmt.executeUpdate();
      		stmt.close();
    } catch (SQLException e) {
          e.printStackTrace();
   	} 
  }

  public void removerFavorito(int idUsuario,int idProduto) {
	    String sql = "DELETE FROM favoritos_usuario id_produto=? WHERE id_usuario=?";
    	try {
      		  stmt = conn.prepareStatement(sql);
		        stmt.setInt(1, idProduto);
      		  stmt.setInt(2, idUsuario);
      		  stmt.executeUpdate();
    	} catch (SQLException e) {
      		e.printStackTrace();
    	}
   }

  @Override
  public FavoritosUsuario buscarPorId(int id) {
    String sql = "SELECT * FROM favoritos_usuario WHERE id=?";
    FavoritosUsuario favorito = new FavoritosUsuario();
    Usuario usuario = new Usuario();
    Produto produto = new Produto();
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      resultSet = stmt.executeQuery();
      if (resultSet.next()) {
        favorito.setId(resultSet.getInt("id"));        
        produto.setId(resultSet.getInt("id_produto"));  
        usuario.setId(resultSet.getInt("id_usuario"));
        favorito.setProduto(produto);
        favorito.setUsuario(usuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return favorito;
  }

  @Override
  public List<FavoritosUsuario> buscarTodos() {
      String sql = "SELECT * FROM favoritos_usuario";
      List<FavoritosUsuario> favoritos = new ArrayList<>();
      try {
      stmt = conn.prepareStatement(sql);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        FavoritosUsuario favorito = new FavoritosUsuario();
        Produto produto = new Produto();
        Usuario usuario = new Usuario();
        favorito.setId(resultSet.getInt("id"));        
        produto.setId(resultSet.getInt("id_produto")); 
        usuario.setId(resultSet.getInt("id_usuario"));
        favorito.setProduto(produto);
        favorito.setUsuario(usuario);
        favoritos.add(favorito);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return favoritos;
  }

  @Override
  public void inserir(FavoritosUsuario favorito) {
      String sql = "INSERT INTO favoritos_usuario(id_usuario, id_produto) VALUES (?,?)";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, favorito.getProduto().getId());
      stmt.setInt(2, favorito.getUsuario().getId());
      stmt.executeUpdate();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  @Override
  public void alterar(FavoritosUsuario favorito) {
      String sql = "UPDATE favoritos_usuario SET id_produto=?, id_usuario=? WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, favorito.getProduto().getId());
      stmt.setInt(2, favorito.getUsuario().getId());
      stmt.setInt(3, favorito.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remover(int id) {
      String sql = "DELETE FROM favoritos_usuario WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
