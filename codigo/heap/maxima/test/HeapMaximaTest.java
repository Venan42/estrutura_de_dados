package heap.maxima.test;

import heap.maxima.src.ArvoreBinariaHeapMaxima;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeapMaximaTest {
    ArvoreBinariaHeapMaxima<Integer> num;

    @Before
    public void setup() {
        num = new ArvoreBinariaHeapMaxima<>(10);
    }

    @Test
    public void inserirTest() throws Exception {
        num.inserir(2);
        assertEquals(2, (int) num.obterRaiz());
    }

    @Test
    public void obterRaizTest() throws Exception {
        num.inserir(12);
        num.inserir(1);
        num.inserir(2);
        num.inserir(20);

        assertEquals(20, (int) num.obterRaiz());
    }

    @Test
    public void estaCheiaTest() throws Exception{
        for (int i = 0; i < 10; i++) {
            num.inserir(1);
        }
        assertTrue(num.estaCheia());
    }

    @Test
    public void estaVaziaTest() throws Exception{
        assertTrue(num.estaVazia());
    }

    @Test(expected = Exception.class)
    public void inserirCheiaExceptionTest() throws Exception {
        for (int i = 0; i < 10; i++) {
            num.inserir(1);
        }
        num.inserir(2);
    }

    @Test
    public void extrairTest() throws Exception{
        num.inserir(1);
        num.inserir(10);
        num.extrair();

        assertEquals(1, (int) num.obterRaiz());
    }

    @Test
    public void extrairMultiplasVezesTest() throws Exception {
        for (int i = 0; i < 10; i++) {
            num.inserir(i);
        }
        for (int i = 0; i < 5; i++) {
            num.extrair();
        }
        assertEquals(4, (int) num.obterRaiz());
    }
}
