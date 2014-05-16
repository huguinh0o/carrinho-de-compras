package br.incognitas.nac;

import br.incognitas.nac.Produto;
import br.incognitas.nac.Livro;
import br.incognitas.nac.Carrinho;
import br.incognitas.nac.CarrinhoVazioExpected;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    // CT01 - O carrinho deve estar vazio ao ser criado
    @Test
    public void verificaCarrinhoVazio() {
        boolean vazio = carrinho.vazio();
        assertEquals(vazio, true);
        
    }
    
    // CT02 - Adicionar produto no carrinho
    @Test
    public void adicionarProduto(){
        int qtdAntiga = carrinho.getQuantidadeProdutos();
        
        Livro livro = new Livro("O ultimo exorcismo", 50.00);
        carrinho.add(livro);
        
        int qtdNova = carrinho.getQuantidadeProdutos();
        
        assertEquals(qtdAntiga+1,qtdNova);
    }

    // CT03 - Ao add um produto igual, a quantidade de produtos no carrinho deve ser a mesma
    @Test
    public void adicionarProdutoExistente() {
        
        Livro livro = new Livro("Java: como programar", 50.00);
        carrinho.add(livro);
        int qtdAntiga=carrinho.getQuantidadeProdutos();   
        carrinho.add(livro);
        int qtdNova=carrinho.getQuantidadeProdutos();
        assertEquals(qtdAntiga, qtdNova);
    }

    @Test
    public void ItensIguais() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
         assertEquals(original, copia);
    }
    
    //CT05 - Ao adicionar 2 produtos iguais a quantidade de itens deve ser incrementada
    
    @Test
       public void acrescentarProdutoExistente() {
        
        Livro livro = new Livro("Java: como programar", 50.00);
        carrinho.add(livro);
        int qtdAntiga=carrinho.getQuantidadeItens(livro);   
        carrinho.add(livro);
        int qtdNova=carrinho.getQuantidadeItens(livro);
        
        assertEquals(qtdAntiga+1, qtdNova);
    }
    
    
    
    
    @Test
    public void totalAPagar() throws CarrinhoVazioExpected
    {
        double t;
        Livro l1 = new Livro("Aprendendo a programar JAVA", 150.00);
        Livro l2 = new Livro("Aprendendo a programar JAVA", 150.00);
        Perfumaria p1 = new Perfumaria("212",200);
        Perfumaria p2 = new Perfumaria("212",200);
        
    }
    
   // Ao remover um produto do carrinho, se só existir uma quantidade desse produto, o item deve ser removido.
     @Test
    public void removendoItemExistente()throws CarrinhoVazioExpected {
        Livro l1 = new Livro("Aprendendo a programar JAVA", 150.00);
        
        int qtdAntiga= carrinho.getQuantidadeProdutos();
        carrinho.add(l1);
        carrinho.remove(l1);
        int qtdeNova = carrinho.getQuantidadeProdutos();
        
        assertEquals(qtdAntiga, qtdeNova);
    }
    
    
    
            
    
    
}
