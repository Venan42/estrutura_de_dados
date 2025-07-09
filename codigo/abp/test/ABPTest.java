package abp.test;

import abp.src.ABP;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ABPTest {
    private ABP<Integer> abp;

    @Before
    public void setUp() {
        abp = new ABP<>();
    }

    @Test
    public void testInserirERaiz() {
        abp.inserir(10);
        assertNotNull(abp.getRaiz());
        assertEquals(10, (int) abp.getRaiz().getDado());
    }

    @Test
    public void testInserirNulo() {
        assertThrows(IllegalArgumentException.class, () -> abp.inserir(null));
    }

    @Test
    public void testExiste() {
        abp.inserir(5);
        abp.inserir(3);
        abp.inserir(7);
        assertTrue(abp.existe(5));
        assertTrue(abp.existe(3));
        assertTrue(abp.existe(7));
        assertFalse(abp.existe(8));
        assertFalse(abp.existe(null));
    }

    @Test
    public void testExisteRec() {
        abp.inserir(5);
        abp.inserir(3);
        abp.inserir(7);
        assertTrue(abp.existeRec(abp.getRaiz(), 5));
        assertTrue(abp.existeRec(abp.getRaiz(), 3));
        assertTrue(abp.existeRec(abp.getRaiz(), 7));
        assertFalse(abp.existeRec(abp.getRaiz(), 8));
    }

    @Test
    public void testApagarNoFolha() throws Exception {
        abp.inserir(10);
        abp.inserir(5);
        abp.inserir(15);
        abp.apagar(5);
        assertFalse(abp.existe(5));
    }

    @Test
    public void testApagarComUmFilho() throws Exception {
        abp.inserir(10);
        abp.inserir(5);
        abp.inserir(3);
        abp.apagar(5);
        assertFalse(abp.existe(5));
        assertTrue(abp.existe(3));
    }

    @Test
    public void testApagarComDoisFilhos() throws Exception {
        abp.inserir(10);
        abp.inserir(5);
        abp.inserir(15);
        abp.inserir(12);
        abp.inserir(18);
        abp.apagar(15);
        assertFalse(abp.existe(15));
        assertTrue(abp.existe(12));
        assertTrue(abp.existe(18));
    }

    @Test
    public void testApagarNaoExistente() {
        abp.inserir(1);
        Exception e = assertThrows(Exception.class, () -> abp.apagar(2));
        assertEquals("Dado não existe!", e.getMessage());
    }

    @Test
    public void testLimpar() {
        abp.inserir(1);
        abp.inserir(2);
        abp.limpar();
        assertNull(abp.getRaiz());
    }

    @Test
    public void testNodosNaoFolhaComArvoreCompleta() {
        abp.inserir(10);
        abp.inserir(5);
        abp.inserir(15);
        abp.inserir(3);
        abp.inserir(7);
        // Árvore: 10 tem dois filhos, 5 tem dois filhos, 15 é folha, 3 e 7 são folhas
        // Nodos não folha: 10 e 5 (total 2)
        assertEquals(2, abp.nodosNaoFolha());
    }

    @Test
    public void testNodosNaoFolhaArvoreVazia() {
        // Árvore vazia deve retornar 0
        assertEquals(0, abp.nodosNaoFolha());
    }
}
