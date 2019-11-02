package br.com.camisaslegais.beans;

import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private List<ProdutoDePedido> produtosPedido;
    private Usuario usuario;
    private double total;
    private Date data;

    public Pedido() {
    }
  
    public void adicionaProduto(Produto produto, int quantidade){
      ProdutoDePedido pd = new ProdutoDePedido();
      pd.setProduto(produto);
      pd.setQuantidade(quantidade);
      this.produtosPedido.add(pd);
    }
    
    public void calculaValorTotal(){
        this.total = 0;
        for (ProdutoDePedido i : produtosPedido){
            this.total+= i.getPrecoTotal();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public List<ProdutoDePedido> getProdutosPedido() {
        return produtosPedido;
    }
    
    public void setProdutosPedido(List<ProdutoDePedido> produtosPedidos) {
        this.produtosPedido = produtosPedidos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }  
}
