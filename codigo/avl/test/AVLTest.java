package avl.test;

import avl.src.AVL;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTest {
    AVL<Integer> avl;
    @Before
    public void setUp() {
        avl = new AVL<>();
    }

    @Test
    public void testInserir() {
        avl.inserir(6);
        avl.inserir(10);
        avl.inserir(7);
        // Verifica se a árvore está balanceada após inserções
        assertTrue(avl.estaBalanceada());
    }

    @Test
    public void testApagar() throws Exception {
        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30);
        avl.apagar(20);
        // Verifica se a árvore está balanceada após remoção
        assertTrue(avl.estaBalanceada());
    }

    @Test
    public void testBuscar() {
        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30);
        assertNotNull(avl.buscar(20));
        assertNull(avl.buscar(40)); // Valor não inserido
    }

    @Test
    public void testEstaVazia() {
        assertTrue(avl.estaVazia());
        avl.inserir(10);
        assertFalse(avl.estaVazia());
    }

    @Test
    public void testImprimirEmOrdem() {
        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30);
        String expected = "10 20 30"; // Formato esperado da impressão
        assertEquals(expected, avl.imprimirEmOrdem());
    }

    @Test
    public void testImprimirPreOrdem() {
        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30);
        String expected = "10 20 30"; // Formato esperado da impressão
        assertEquals(expected, avl.imprimirPreOrdem());
    }

    @Test
    public void testImprimirPosOrdem() {
        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30);
        String expected = "30 20 10"; // Formato esperado da impressão
        assertEquals(expected, avl.imprimirPosOrdem());
    }

    @Test
    public void testImprimirVazia() {
        String expected = ""; // Formato esperado da impressão para árvore vazia
        assertEquals(expected, avl.imprimirEmOrdem());
    }

    @Test
    public void testLimpar() {
        avl.inserir(10);
        avl.inserir(20);
        avl.limpar();
        assertTrue(avl.estaVazia());
    }

    @Test
    public void testExisteRec() {
        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30);
        assertTrue(avl.existeRec(avl.getRaiz(), 20));
        assertFalse(avl.existeRec(avl.getRaiz(), 40)); // Valor não inserido
    }

    @Test
    public void testApagarNoFolha() throws Exception {
        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30);
        avl.apagar(30); // Apagando um nó folha
        assertNull(avl.buscar(30));
        assertTrue(avl.estaBalanceada());
    }
}
