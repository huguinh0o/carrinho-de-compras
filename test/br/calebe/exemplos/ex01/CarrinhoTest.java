package br.calebe.exemplos.ex01;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void verificaCarrinho() throws CarrinhoVazioExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        assertEquals(null, menor);
    }

    @Test
    public void adicionarItem() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        assertEquals(livro, menor);
    }

    @Test
    public void adicionarMaisItens() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        Produto menor;
        menor = carrinho.menorProduto();
        assertEquals(livro, menor);
    }

    @Test
    public void produtosIguais() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        assertEquals(original, copia);
    }
    
    
     @Test
    public void removendoUmProdutoExistente() throws CarrinhoVazioExpected{
        Livros l1 = new Livros("Aprendendo a programar JAVA", 150.00);
        carrinho.add(l1);
        carrinho.add(l1);
        carrinho.add(l1);
       
        int qtdeAntiga = carrinho.getQuantidadeProdutos(l1);
        
        carrinho.remove(l1);
        
        int qtdeNova = carrinho.getQuantidadeProdutos(l1);
        
        assertEquals((qtdeAntiga - 1), qtdeNova);
    }
            
    
    
    
    
    
}
