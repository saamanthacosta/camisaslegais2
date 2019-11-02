package br.com.camisaslegais.modelo;

import br.com.camisaslegais.beans.Carrinho;
import br.com.camisaslegais.beans.Item;
import br.com.camisaslegais.beans.Pedido;
import br.com.camisaslegais.beans.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements DAO<Pedido> {
  
  private Connection conn;
  private ConnectionFactory cf = new ConnectionFactory();
  private ResultSet resultSet;
  private PreparedStatement stmt;

  public PedidoDAO(Connection conn){
    this.conn = cf.getConnection();
  }
  
  public void removeEstoque(Carrinho carrinho) {
        String sql = "UPDATE produto SET qtd_disp=? WHERE id=?";
        for(Item i: carrinho.getItens()) {
            try { 
                stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1, i.getQuantidade());
                stmt.setInt(2, i.getProduto().getId());
                stmt.executeUpdate();
                stmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
      }
  }

  @Override
  public Pedido buscarPorId(int id) {
    String sql = "SELECT * FROM pedido WHERE id=?";
    Pedido pedido = new Pedido();
    Usuario usuario = new Usuario();
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      resultSet = stmt.executeQuery();
      if (resultSet.next()) {
        pedido.setId(resultSet.getInt("id"));        
        usuario.setId(resultSet.getInt("id_usuario"));
        pedido.setTotal(resultSet.getDouble("total"));
        pedido.setData(resultSet.getDate("data"));
        pedido.setUsuario(usuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pedido;
  }

  @Override
  public List<Pedido> buscarTodos() {
      String sql = "SELECT * FROM pedido";
      List<Pedido> pedidos = new ArrayList<>();
      try {
      stmt = conn.prepareStatement(sql);
      resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        Pedido pedido = new Pedido();
        Usuario usuario = new Usuario();
        pedido.setId(resultSet.getInt("id"));        
        usuario.setId(resultSet.getInt("id_usuario"));
        pedido.setTotal(resultSet.getDouble("total"));
        pedido.setData(resultSet.getDate("data"));
        pedidos.add(pedido);
      }
        stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pedidos;
  }

  @Override
  public void inserir(Pedido pedido) {
      String sql = "INSERT INTO pedido(id_usuario, valor_total, data) VALUES (?,?,?)";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, pedido.getUsuario().getId());
      stmt.setDouble(2, pedido.getTotal());
      stmt.setDate(3, (Date) pedido.getData());
      stmt.executeUpdate();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }

  @Override
  public void alterar(Pedido pedido) {
      String sql = "UPDATE pedido SET id_usuario=?, valor_total=?, data=? WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, pedido.getUsuario().getId());
      stmt.setDouble(2, pedido.getTotal());
      stmt.setDate(3, (Date) pedido.getData());
      stmt.setInt(4, pedido.getId());
      stmt.executeUpdate();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void remover(int id) {
      String sql = "DELETE FROM pedido WHERE id=?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      stmt.executeUpdate();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
