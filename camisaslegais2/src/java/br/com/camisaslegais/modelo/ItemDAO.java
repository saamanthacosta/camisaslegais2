package br.com.camisaslegais.modelo;

import br.com.camisaslegais.beans.Item;
import br.com.camisaslegais.beans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements DAO<Item> {
  
  private Connection conn;
  private ConnectionFactory cf = new ConnectionFactory();
  private ResultSet resultSet;
  private PreparedStatement stmt;

  public ItemDAO(Connection conn){
    this.conn = cf.getConnection();
  }

  @Override
  public Item buscarPorId(int id) {
    String sql = "SELECT * FROM item WHERE id=?";
    Item item = new Item();
    Produto produto = new Produto();
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      resultSet = stmt.executeQuery();
      if (resultSet.next()) {
        item.setId(resultSet.getInt("id"));        
        produto.setId(resultSet.getInt("id_produto"));
        item.setTotal(resultSet.getDouble("total"));
        item.setQuantidade(resultSet.getInt("quantidade"));
        item.setProduto(produto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return item;
  }

  @Override
  public List<Item> buscarTodos() {
      String sql = "SELECT * FROM item";
      List<Item> itens = new ArrayList<>();
      try {
      stmt = conn.prepareStatement(sql);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        Item item = new Item();
        Produto produto = new Produto();
        item.setId(resultSet.getInt("id"));        
        produto.setId(resultSet.getInt("id_produto"));
        item.setTotal(resultSet.getDouble("total"));
        item.setQuantidade(resultSet.getInt("quantidade"));
        item.setProduto(produto);
        itens.add(item);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return itens;
  }

  @Override
  public void inserir(Item item) {
      String sql = "INSERT INTO item(id_produto, quantidade, total) VALUES (?,?,?)";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, item.getProduto().getId());
      stmt.setInt(2, item.getQuantidade());
      stmt.setDouble(3, item.getTotal());
      stmt.executeUpdate();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  @Override
  public void alterar(Item item) {
      String sql = "UPDATE item SET id_produto=?, quantidade=?, total=? WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, item.getProduto().getId());
      stmt.setInt(2, item.getQuantidade());
      stmt.setDouble(3, item.getTotal());
      stmt.setInt(4, item.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remover(int id) {
      String sql = "DELETE FROM item WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
