package br.com.camisaslegais.modelo;

import br.com.camisaslegais.beans.Item;
import br.com.camisaslegais.beans.ItemPedido;
import br.com.camisaslegais.beans.Pedido;
import br.com.camisaslegais.beans.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAO implements DAO<ItemPedido> {
  
  private Connection conn;
  private ConnectionFactory cf = new ConnectionFactory();
  private ResultSet resultSet;
  private PreparedStatement stmt;

  public ItemPedidoDAO(Connection conn){
    this.conn = cf.getConnection();
  }

  @Override
  public ItemPedido buscarPorId(int id) {
    String sql = "SELECT * FROM item_pedido WHERE id=?";
    ItemPedido itemPedido = new ItemPedido();
    Pedido pedido = new Pedido();
    Item item = new Item();
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      resultSet = stmt.executeQuery();
      if (resultSet.next()) {
        itemPedido.setId(resultSet.getInt("id"));
        pedido.setId(resultSet.getInt("id_pedido"));
        itemPedido.setPedido(pedido);
        item.setId(resultSet.getInt("id_item"));
        itemPedido.setItem(item);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return itemPedido;
  }

  @Override
  public List<ItemPedido> buscarTodos() {
      String sql = "SELECT * FROM item_pedido";
      List<ItemPedido> itemPedidos = new ArrayList<>();
      try {
      stmt = conn.prepareStatement(sql);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        ItemPedido itemPedido = new ItemPedido();
        Pedido pedido = new Pedido();
        Item item = new Item();
        itemPedido.setId(resultSet.getInt("id"));
        pedido.setId(resultSet.getInt("id_pedido"));
        itemPedido.setPedido(pedido);
        item.setId(resultSet.getInt("id_item"));
        itemPedido.setItem(item);
        itemPedidos.add(itemPedido);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return itemPedidos;
  }

  @Override
  public void inserir(ItemPedido itemPedido) {
      String sql = "INSERT INTO item_pedido(id_pedido, id_item) VALUES (?,?)";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, itemPedido.getPedido().getId());
      stmt.setInt(2, itemPedido.getItem().getId());
      stmt.executeUpdate();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  @Override
  public void alterar(ItemPedido itemPedido) {
      String sql = "UPDATE item_pedido SET id_pedido=?, id_item=? WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, itemPedido.getPedido().getId());
      stmt.setInt(2, itemPedido.getItem().getId());
      stmt.setInt(3, itemPedido.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remover(int id) {
      String sql = "DELETE FROM item_pedido WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
