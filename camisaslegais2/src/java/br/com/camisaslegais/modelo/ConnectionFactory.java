package br.com.camisaslegais.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  
  Connection conn;
  final private String url;
  final private String usuario;
  final private String senha;
  
  public ConnectionFactory() {
    this.url = "jdbc:mysql://35.198.36.118:3306/loja";
    this.usuario = "db-loja";
    this.senha = "dev2019";
  }
  
  public Connection getConnection() throws RuntimeException {
    try {
      //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      return DriverManager.getConnection(url, usuario, senha);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }  
  
  public void closeConnection() throws RuntimeException {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
