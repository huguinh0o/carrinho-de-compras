package br.incognitas.nac;

public class Item {
    
    private int qtd;
    private Produto produto;

    public Item(Produto produto) {
        this.qtd = 1;
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd() {
        this.qtd ++;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }    
    
}
