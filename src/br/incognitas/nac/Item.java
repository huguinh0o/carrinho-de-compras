package br.incognitas.nac;

public class Item {
    
    private int qtd;
    private Produto produto;
    private Carrinho car;

    public Item(int qtd, Produto produto, Carrinho car) {
        this.qtd = qtd;
        this.produto = produto;
        this.car = car;
    }

    

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Carrinho getCar() {
        return car;
    }

    public void setCar(Carrinho car) {
        this.car = car;
    }
   
    
}
