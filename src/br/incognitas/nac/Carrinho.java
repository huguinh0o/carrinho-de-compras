package br.incognitas.nac;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public Produto menorProduto() throws CarrinhoVazioExpected {
        if (produtos.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        Produto menor = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }
        }
        return menor;
    }
    
    public void remove(Produto produto)throws  CarrinhoVazioExpected{
        
        Item i = new Item();
        
       if(produtos.contains(i) &&  produtos.get(produtos.indexOf(i)).getQtd()==1)
          produtos.remove(i);
       else
           if(produtos.contains(i))
              produtos.get(produtos.indexOf(i)).removeQtd();
           else
               throw new CarrinhoVazioExpected();
        
    }

    public int getQuantidadeProdutos(Produto produto) throws CarrinhoVazioExpected{
        
         Item i = new Item(produto);
        
       if(produtos.contains(i))
           return produtos.get(produtos.indexOf(i)).getQtd();
       else
           throw new ProdutoInexistenteExpected();
        
    }
    
    
    
    
}
