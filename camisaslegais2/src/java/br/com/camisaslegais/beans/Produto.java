package br.com.camisaslegais.beans;

public class Produto {
  private int id;
  private String nome;
  private String imagem;
  private double preco;
  private int quantidade;
  private int avaliacao;

  public Produto() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }
  
  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }
  
  public int getQuantidade() {
    return quantidade;
  }
  
  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public int getAvaliacao() {
    return avaliacao;
  }

  public void setAvaliacao(int avaliacao) {
    this.avaliacao = avaliacao;
  }

}
