package br.incognitas.nac;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private ArrayList<Item> itens;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    public void add(Produto produto) {
        
        Item item = new Item(produto);
        
        boolean contem = false;
        int index = 0;
        for(int i = 0; i < itens.size(); i++)
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
    
    public int getQuantidadeProdutos() {
    
       return itens.size();

    }
    
    public int getQuantidadeItens(Produto produto)
    {
        Item item = new Item(produto);
        int x = 0;
         for(int i = 0; i < itens.size(); i++)
            if(itens.get(i).getProduto().getNome() == produto.getNome())
            {
                x = itens.get(i).getQtd();
            }

            return x;    
            
    }
    
     public void verificaProduto() throws CarrinhoVazioExpected {
        if (itens.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
     }
           
    public Double getTotal()
    {
        Double total = 0.0;
        for(int k = 0; k < itens.size(); k++)
        {
            total += (itens.get(k)).getProduto().getPreco() * itens.get(k).getQtd();
        }
        return total;       
    }
    
    public void remove(Produto produto)throws CarrinhoVazioExpected {
        
        Item item = new Item(produto);
        
          for(int i = 0; i < itens.size(); i++)
            
              if(itens.get(i).getProduto().getNome() == produto.getNome())
            {
                itens.remove(i);
                break;
            }
            else
                  throw new CarrinhoVazioExpected();
          
    }
 
    public boolean vazio()
    {
        return itens.isEmpty();
    }
    
    public ArrayList<Item> getItens()
    {
        return itens;
    }
 
}
