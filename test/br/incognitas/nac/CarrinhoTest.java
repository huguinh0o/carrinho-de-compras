package br.incognitas.nac;

import br.incognitas.nac.Produto;
import br.incognitas.nac.Livro;
import br.incognitas.nac.Carrinho;
import br.incognitas.nac.CarrinhoVazioExpected;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produtos;

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
    public void adicionarProduto() {
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
        int qtdAntiga = carrinho.getQuantidadeProdutos();   
        carrinho.add(livro);
        int qtdNova = carrinho.getQuantidadeProdutos();
        assertEquals(qtdAntiga, qtdNova);
        
    }

    // CT04 - 
    @Test
    public void ItensIguais() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        assertEquals(original, copia);
        
    }
    
    // CT05 - Ao adicionar 2 produtos iguais a quantidade de itens deve ser incrementada
    
    @Test
       public void acrescentarProdutoExistente() {
        
        Livro livro = new Livro("Java: como programar", 50.00);
        carrinho.add(livro);
        int qtdAntiga = carrinho.getQuantidadeItens(livro);   
        carrinho.add(livro);
        int qtdNova = carrinho.getQuantidadeItens(livro);
        assertEquals(qtdAntiga+1, qtdNova);
        
    }
    
    @Test
    public void totalAPagar() throws CarrinhoVazioExpected {
        Double t = 0.0;
        Livro l1 = new Livro("Aprendendo a programar JAVA", 150.00);
        Perfumaria p1 = new Perfumaria("212",200);
        
        t= l1.getPreco()+p1.getPreco();
        
        carrinho.add(p1);
        carrinho.add(l1);

        assertEquals(t,carrinho.getTotal());
        
    }
    
   // remover um produto
     @Test
    public void removendoItemExistente()throws CarrinhoVazioExpected {
        Livro l1 = new Livro("Aprendendo a programar JAVA", 150.00);
        
        int qtdAntiga = carrinho.getQuantidadeProdutos();
        carrinho.add(l1);
        carrinho.remove(l1);
        int qtdeNova = carrinho.getQuantidadeProdutos();
        
        assertEquals(qtdAntiga, qtdeNova);
        
    }
   
    // Listar
    
    /*@Test
    public void listarProdutos(){
    
        Livro b1 = new Livro("Os Batutas", 100.00);
        Perfumaria p1 = new Perfumaria("Only the Brave", 150.00);
        
        carrinho.add(b1);
        carrinho.add(p1);

        ArrayList<Item>produtosAdicionar = new ArrayList<>(
                Arrays.asList(new Item(b1),new Item(p1)));
        
                
       boolean contem = false;
       int index = 0;
    
        for(int i = 0; i < produtosAdicionar.size(); i++)
            
            if(produtosAdicionar.indexOf(i) == carrinho.)
            {
                contem = true;
                index = i;
                break;
            }
         
        assertArrayEquals(produtosAdicionar.toArray(),carrinho.getItens().toArray());*/
 
    }
