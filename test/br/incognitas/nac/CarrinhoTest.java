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

    @Test(expected = CarrinhoVazioExpected.class)
    public void verificaCarrinho() throws CarrinhoVazioExpected {
        Produto verifica;
        verifica = carrinho.verificarMenorProduto();
        assertEquals(null, verifica);
    }

    @Test
    public void adicionarProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("O ultimo exorcismo", 50.00);
        carrinho.add(livro);
        assertEquals(livro, this);
    }

    @Test
    public void adicionarCarrinho() throws CarrinhoVazioExpected {
        Produto e1 = new Produto("Geladeira", 800.00);
        carrinho.add(e1);    
        Produto p1 = new Produto("Uomini", 150.00);        
        carrinho.add(p1);
        assertEquals(p1, this);
    }
    
    @Test
    public void adicionarMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        assertEquals(livro, this);
    }

    @Test
    public void ItensIguais() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
         assertEquals(original, copia);
    }
    
    @Test
    public void totalAPagar() throws CarrinhoVazioExpected
    {
        double t;
        Produto eletronica = new Produto("TV", 450.50);
        carrinho.add(eletronica);
        Produto livro = new Produto("Java: como programar", 150.00);
        carrinho.add(livro);
        
        t = carrinho.getTotal();
        assertEquals((600.0), t);
        
    }
    
    
     @Test
    public void removendoItemExistente() throws CarrinhoVazioExpected{
        Livro l1 = new Livro("Aprendendo a programar JAVA", 150.00);
        carrinho.add(l1);
        carrinho.add(l1);
        carrinho.add(l1);
        
        int qtdeAntiga = carrinho.getQuantidadeItens(l1);
        
        carrinho.remove(l1);
        
        int qtdeNova = carrinho.getQuantidadeItens(l1);
        
        assertEquals((qtdeAntiga - 1), qtdeNova);
    }
    
    
    
            
    
    
}
