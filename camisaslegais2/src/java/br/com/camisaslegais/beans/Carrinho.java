package br.com.camisaslegais.beans;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
  private Pedido pedido;
  private List<Item> itens = new ArrayList<>();
  private double total;
  
  public Carrinho() { }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public List<Item> getItens() {
    return itens;
  }

  public void addItens(Item item) {
    this.itens.add(item);
  }

  public double getTotal() {
    return total;
  }

  public void calculaTotal() {
    double total = 0;
    for (Item item : this.itens) {
      total += item.getTotal();
    }
    this.total = total;
  }  
}