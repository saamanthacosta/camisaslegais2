package br.com.camisaslegais.beans;

public class ItemPedido {
  private int id;
  private Pedido pedido;
  private Item item;

  public ItemPedido() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
  
}