package br.com.camisaslegais.modelo;

import br.com.camisaslegais.beans.Produto;
import br.com.camisaslegais.modelo.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso ao BD para manipulação da entidade {@link Produto}
 */
public class ProdutoDAO implements DAO<Produto> {
  
  private Connection conn;
  private ResultSet resultSet;
  private PreparedStatement stmt;

  public ProdutoDAO(Connection conn){
    this.conn = conn;
  }

  /**
   * Busca um produto por seu id.
   * @param id OID do produto na base
   * @return {@code Optional} de um {@link Produto}
   */
  @Override
  public Produto buscarPorId(int id) {
    String sql = "SELECT * FROM produto WHERE id=?";
    Produto produto = new Produto();
    try {
      stmt = this.conn.prepareStatement(sql);
      stmt.setInt(1, id);
      resultSet = stmt.executeQuery();
      if (resultSet.next()) {
        produto.setId(resultSet.getInt("id"));
        produto.setNome(resultSet.getString("nome"));
        produto.setPreco(resultSet.getDouble("preco"));
        produto.setAvaliacao(resultSet.getInt("avaliacao"));
        produto.setQuantidade(resultSet.getInt("qtd_disp"));
        produto.setImagem(resultSet.getString("imagem"));
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return produto;
  }

  /**
   * Busca todos os produtos persistidos na base
   * @return {@code List} de {@code Produto}
   */
  @Override
  public List<Produto> buscarTodos() {
    String sql = "SELECT * FROM produto";
    List<Produto> produtos = new ArrayList<>();
    try {
      stmt = this.conn.prepareStatement(sql);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        Produto produto = new Produto();
        produto.setId(resultSet.getInt("id"));
        produto.setNome(resultSet.getString("nome"));
        produto.setPreco(resultSet.getDouble("preco"));
        produto.setAvaliacao(resultSet.getInt("avaliacao"));
        produto.setQuantidade(resultSet.getInt("qtd_disp"));
        produto.setImagem(resultSet.getString("imagem"));
        produtos.add(produto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return produtos;
  }

  @Override
  public void inserir(Produto produto) {
    String sql = "INSERT INTO produto(nome,qtd_disp,avaliacao,imagem,preco) VALUES (?,?,?,?,?)";
    try {
      stmt = this.conn.prepareStatement(sql);
      stmt.setString(1, produto.getNome());
      stmt.setInt(2, produto.getQuantidade());      
      stmt.setInt(3, produto.getAvaliacao());
      stmt.setString(4, produto.getImagem());
      stmt.setDouble(5, produto.getPreco());
      stmt.executeUpdate();
      stmt.close();  
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void alterar(Produto produto) {
    String sql = "UPDATE produto SET  nome=?, qtd_disp=?, avaliacao=?, imagem=?, preco=? WHERE id=?";
    try {
      stmt = this.conn.prepareStatement(sql);
      stmt.setString(1, produto.getNome());
      stmt.setInt(2, produto.getQuantidade());      
      stmt.setInt(3, produto.getAvaliacao());
      stmt.setString(4, produto.getImagem());
      stmt.setDouble(5, produto.getPreco());
      stmt.setInt(6, produto.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remover(int id) {
    String sql = "DELETE FROM produto WHERE id=?";
    try {
      stmt = this.conn.prepareStatement(sql);
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}