package br.incognitas.nac;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Item> itens;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    
    public void add(Produto produto) {
        
        Item item= new Item(produto);
        
        boolean contem = false;
        int index = 0;
        for(int i = 0; i < itens.size(); i++ )
            if(itens.get(i).getProduto().getNome() == produto.getNome())
            {
                contem = true;
                index = i;
                break;
            }
        
        
        
            if(contem)
            {
               itens.get(index).setQtd();
            }
            else
            {
                itens.add(item);
            }
    
    }
    
    public int getQuantidadeProdutos(){
    
       return itens.size();

    }
    
    public int getQuantidadeItens(Produto produto)
    {
        Item item = new Item(produto);
        int x=0;
         for(int i = 0; i < itens.size(); i++ )
            if(itens.get(i).getProduto().getNome() == produto.getNome())
            {
                x= itens.get(i).getQtd();
            }

            return x;    
            
    }
    
    
    
    
     public void verificaProduto() throws CarrinhoVazioExpected {
        if (itens.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        /*else
        {
            Produto menor = produtos.get(0);
            for (Produto produto : produtos) {
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }*/
        }
           
        public Produto verificarMaiorProduto() throws CarrinhoVazioExpected {
        if (itens.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        else
        {
            Produto maior = produtos.get(0);
            for (Produto produto : produtos) {
            if (produto.getPreco() > maior.getPreco()) {
                maior = produto;
            }
        }
        return maior;
        }        
    }

    
    public Produto verificarMenorProduto() throws CarrinhoVazioExpected {
        if (produtos.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        else
        {
            Produto menor = produtos.get(0);
            for (Produto produto : produtos) {
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }
        }
        return menor;
        }

        
    }
    
    public Double getTotal()
    {
        for(int k = 0; k < produtos.size(); k++)
        {
            total += (produtos.get(k)).getPreco();
        }
        return total;       
    }
    
    public void remove(Produto produto)throws CarrinhoVazioExpected{
        
        Item item = new Item(produto);
        
          for(int i = 0; i < itens.size(); i++ )
            
              if(itens.get(i).getProduto().getNome() == produto.getNome())
            {
                if(itens.get(i).getQtd()==1)
                itens.remove(i);
                break;
            }
            else
                  throw new CarrinhoVazioExpected();
          
    }

    
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    public boolean vazio()
    {
        return itens.isEmpty();
    }

        
}
