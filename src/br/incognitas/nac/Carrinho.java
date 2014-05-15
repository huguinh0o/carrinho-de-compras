package br.incognitas.nac;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos;
    private double total = 0.0;

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
    
    public Double getTotal()
    {
        for(int k = 0; k < produtos.size(); k++)
        {
            total += (produtos.get(k)).getPreco();
        }
        return total;       
    }
    
    public void remove(Produto produto)throws  CarrinhoVazioExpected{
        
        Item i = new Item(produto);
        
        if(produtos.contains(i) && produtos.get(produtos.indexOf(i)).getQtd() == 1)
            produtos.remove(i);
        else
             throw new CarrinhoVazioExpected();
           
        
        /*(if(produtos.contains(i) &&  produtos.get(produtos.indexOf(i)).getQtd()==1)
          produtos.remove(i);
       else
           if(produtos.contains(i))
              produtos.get(produtos.indexOf(i)).removeQtd();
           else
               throw new CarrinhoVazioExpected();
        */
    }

    public int getQuantidadeItens(Produto produto) throws CarrinhoVazioExpected{
        
       int qtde;
       Item i = new Item(produto);
       
       if(produtos.get(i) == false)
           qtde = produtos.size();
       else
           throw new CarrinhoVazioExpected();
       
       return qtde;
        
       /*if(produtos.contains(i))
           return produtos.get(produtos.indexOf(i)).getQtd();
       else
           throw new CarrinhoVazioExpected();
       */
    }

        
}
