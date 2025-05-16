package test;
import org.junit.Test;
import static org.junit.Assert.*;

import fila.DuplamenteEnfileiravel;
import fila.FilaDinamicaDuplaTerminacaoGenerica;
import java.util.NoSuchElementException;

public class FilaDinamicaDuplaTerminacaoTest {
	
	@Test
	public void testFilaComDiferentesTipos() {
		DuplamenteEnfileiravel<String> fila1 = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila1.enfileirarFim("A");
		assertEquals(fila1.frente(), "A");

		DuplamenteEnfileiravel<Integer> fila2 = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila2.enfileirarFim(1);
		assertEquals(fila2.frente().toString(), "1");
	}

	@Test
	public void testConstrutorPadrao() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarFim("A");
		assertEquals(fila.frente(), "A");
	}


	@Test
	public void testConstrutorComTamanhoPersonalizado() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>(1);
		fila.enfileirarFim("A");
		assertTrue(fila.estaCheia());
	}
  
  
	
	@Test
	public void testEnfileirar() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarInicio("A");
		fila.enfileirarFim("B");
		assertTrue(fila.frente() == "A");
	}
	
	@Test
	public void testEstaVazia() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		assertTrue(fila.estaVazia());
	}
	
	@Test
	public void testEstaCheia() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>(15);
		for (int i = 0; i < 15; i++) {
			fila.enfileirarFim("A");
		}
		assertTrue(fila.estaCheia());
	}
	
	@Test
	public void testFrente() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarInicio("A");
		assertTrue(fila.frente() == "A");
	}
	
	@Test
	public void testTras() {
		DuplamenteEnfileiravel<Integer> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarInicio(1);
		assertTrue(fila.tras() == 1);
	}
	
	@Test
	public void testDesenfileirar() {
		DuplamenteEnfileiravel<Integer> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarInicio(1);
		fila.enfileirarInicio(2);
		fila.desenfileirarFim();
		assertTrue(fila.frente() == 2);
	}
	
	@Test
	public void testDesenfileirarMultiplosElementos() {
		DuplamenteEnfileiravel<Integer> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarInicio(1);
		fila.enfileirarInicio(2);
		fila.desenfileirarFim();
		fila.desenfileirarInicio();
		assertTrue(fila.estaVazia());
	}
  
	@Test
	public void testAtualizarInicio() {
		DuplamenteEnfileiravel<Integer> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarInicio(1);
		fila.atualizarInicio(3);
		assertTrue(fila.frente() == 3);
	}

	@Test
	public void testAtualizarInicioComMultiplosElementos() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarInicio("A");
		fila.enfileirarInicio("B");
		fila.enfileirarInicio("C");
		fila.enfileirarInicio("D");
		fila.atualizarInicio("E");
		fila.atualizarInicio("F");
		assertTrue(fila.frente() == "F");
	}
  
	
	@Test
	public void testAtualizarFim() {
		DuplamenteEnfileiravel<Integer> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarInicio(1);
		fila.atualizarFim(3);
		assertTrue(fila.tras() == 3);
	}
  
	
	@Test
	public void testImprimirDeFrentePraTras() {
		DuplamenteEnfileiravel<Integer> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarFim(1);
		fila.enfileirarFim(2);
		assertEquals(fila.imprimirFrenteTras(), "[1, 2]");
	}

	@Test
	public void testImprimirDeFrentePraTrasFormatacaoVazia() {
		DuplamenteEnfileiravel<Integer> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		assertEquals(fila.imprimirFrenteTras(), "[]");
	}

	@Test
	public void testImprimirDeTrasPraFrente() {
		DuplamenteEnfileiravel<Integer> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		fila.enfileirarFim(1);
		fila.enfileirarFim(2);
		assertEquals(fila.imprimirTrasFrente(), "[2, 1]");
	}

	@Test
	public void testFilaVaziaFrente() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		try {
			fila.atualizarInicio("A"); // erro proposital: "A" é String, fila é Integer
			fail("Esperava exceção ao mostrar o início de uma fila vazia.");
		} catch (NoSuchElementException e) {
			assertEquals("Queue is Empty!", e.getMessage());
		}
	}

	@Test
	public void testFilaVaziaAtualizarInicio() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		try {
			fila.atualizarInicio("A");
			fail("Esperava exceção ao atualizar o início de uma fila vazia.");
		} catch (NoSuchElementException e) {
			assertEquals("Queue is Empty!", e.getMessage());
		}
	}

	@Test
	public void testFilaVaziaAtualizarFim() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		try {
			fila.atualizarFim("A");
			fail("Esperava exceção ao atualizar o fim de uma fila vazia.");
		} catch (NoSuchElementException e) {
			assertEquals("Queue is Empty!", e.getMessage());
		}
	}
	
	@Test
	public void testLimpezaFila() {
		DuplamenteEnfileiravel<String> fila = new FilaDinamicaDuplaTerminacaoGenerica<>();
		for (int i = 0; i < 10; i++) {
			fila.enfileirarFim("A");
		}

		fila.limpar();
		assertTrue(fila.estaVazia());
	}
  
}
