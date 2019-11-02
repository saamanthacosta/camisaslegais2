package br.com.camisaslegais.beans;

import java.util.List;

/**
 * Classe para o estado de um produto no estoque
 */
public class Estoque {
  private List<Produto> produtos;

  public Estoque() {
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }
}
