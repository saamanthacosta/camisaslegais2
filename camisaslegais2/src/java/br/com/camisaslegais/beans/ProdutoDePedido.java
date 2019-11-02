package br.com.camisaslegais.beans;

public class ProdutoDePedido {
  private Produto produto;
  private int quantidade;
  private double precoTotal;

  public ProdutoDePedido() {
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

  public double getPrecoTotal() {
    return precoTotal;
  }

  public void setPrecoTotal(double precoTotal) {
    this.precoTotal = precoTotal;
  }
  
}