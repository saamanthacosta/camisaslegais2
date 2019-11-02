package br.com.camisaslegais.beans;

public class Item {
  private int id;
  private Produto produto;
  private double total;
  private int quantidade;

  public Item() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
  
  public void calculaTotal() {
    this.total = this.produto.getPreco() * this.quantidade;
  }  
}
