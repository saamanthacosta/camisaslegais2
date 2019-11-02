package br.com.camisaslegais.modelo;

import br.com.camisaslegais.beans.AvaliacaoUsuario;
import br.com.camisaslegais.beans.Item;
import br.com.camisaslegais.beans.Produto;
import br.com.camisaslegais.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoUsuarioDAO implements DAO<AvaliacaoUsuario> {
  
  private Connection conn;
  private ConnectionFactory cf = new ConnectionFactory();
  private ResultSet resultSet;
  private PreparedStatement stmt;

  public AvaliacaoUsuarioDAO(Connection conn){
    this.conn = cf.getConnection();
  }
  
  public void adicionarAvaliacao(int idUsuario,int idProduto) {
	  String sql = "INSERT INTO avaliacao_usuario id_produto=? WHERE id_usuario=?";
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

  public void removerAvaliacao(int idUsuario,int idProduto) {
	  String sql = "DELETE FROM avaliacao_usuario id_produto=? WHERE id_usuario=?";
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
  public AvaliacaoUsuario buscarPorId(int id) {
    String sql = "SELECT * FROM avaliacao_usuario WHERE id=?";
    AvaliacaoUsuario avaliacao = new AvaliacaoUsuario();
    Usuario usuario = new Usuario();
    Produto produto = new Produto();
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      resultSet = stmt.executeQuery();
      if (resultSet.next()) {
        avaliacao.setId(resultSet.getInt("id"));        
        produto.setId(resultSet.getInt("id_produto"));  
        usuario.setId(resultSet.getInt("id_usuario"));
        avaliacao.setAvaliacao(resultSet.getInt("avaliacao"));
        avaliacao.setProduto(produto);
        avaliacao.setUsuario(usuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return avaliacao;
  }

  @Override
  public List<AvaliacaoUsuario> buscarTodos() {
      String sql = "SELECT * FROM avaliacao_usuario";
      List<AvaliacaoUsuario> avaliacoes = new ArrayList<>();
      try {
      stmt = conn.prepareStatement(sql);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        AvaliacaoUsuario avaliacao = new AvaliacaoUsuario();
        Produto produto = new Produto();
        Usuario usuario = new Usuario();
        avaliacao.setId(resultSet.getInt("id"));        
        produto.setId(resultSet.getInt("id_produto")); 
        usuario.setId(resultSet.getInt("id_usuario"));
        avaliacao.setProduto(produto);
        avaliacao.setUsuario(usuario);
        avaliacao.setAvaliacao(resultSet.getInt("avaliacao"));
        avaliacoes.add(avaliacao);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return avaliacoes;
  }

  @Override
  public void inserir(AvaliacaoUsuario avaliacao) {
      String sql = "INSERT INTO avaliacao_usuario(id_usuario, id_produto, avaliacao) VALUES (?,?,?)";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, avaliacao.getProduto().getId());
      stmt.setInt(2, avaliacao.getUsuario().getId());
      stmt.setInt(3, avaliacao.getAvaliacao());
      stmt.executeUpdate();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  @Override
  public void alterar(AvaliacaoUsuario avaliacao) {
      String sql = "UPDATE avaliacao_usuario SET id_produto=?, id_usuario=?, avaliacao=? WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, avaliacao.getProduto().getId());
      stmt.setInt(2, avaliacao.getUsuario().getId());
      stmt.setInt(3, avaliacao.getAvaliacao());
      stmt.setInt(4, avaliacao.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remover(int id) {
      String sql = "DELETE FROM avaliacao_usuario WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
