/**
 * Código referente a uma Pilha Dinâmica Genérica,
 * estrutura de dados que segue o princípio LIFO
 * @author Vinícius Nunes de Andrade
 * @version 1
 * @since 06/05/2025
 */
package pilha_dinamica;

import java.util.NoSuchElementException;

public class PilhaDinamicaGenerica<T> implements Empilhavel<T>{
    private NodoDuplo<T> ponteiroTopo;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor vazio da classe, inicializa o tamanho da pilha em 10.
     */
    public PilhaDinamicaGenerica() {
        this(10);
    }

    /**
     * Construtor da classe, inicializa as 3 variáveis de instância.
     * @param tamanho define o tamanho máximo da pilha
     */
    public PilhaDinamicaGenerica(int tamanho) {
        this.ponteiroTopo = null;
        this.quantidade = 0;
        this.tamanho = tamanho;
    }
    @Override
    public boolean estaVazia(){
        return quantidade == 0;
    }

    @Override
    public boolean estaCheia(){
        return quantidade == tamanho;
    }

    /**
     * Método que imprime os elementos presentes na pilha.
     * 
     * @return retorno de uma String com os elementos da pilha.
     */
    @Override
    public String imprimir() {
        String retorno = "[";
        NodoDuplo<T> ponteiroAux = ponteiroTopo;

        for (int i = 0; i < quantidade; i++) {
            retorno += ponteiroAux.getDado();
            if(i != quantidade-1)
                retorno += ", ";
            ponteiroAux = ponteiroAux.getAnterior();
        }
        return retorno + "]";
    }

    /**
     * Método que empilha um novo dado na Pilha.
     * @param dado a ser empilhado.
     * @throws UnsupportedOperationException se a pilha estiver cheia.
     */
    @Override
    public void empilhar(T dado) throws UnsupportedOperationException{
        if(estaCheia())
            throw new UnsupportedOperationException("Pilha cheia!");
        NodoDuplo<T> novoNodo = new NodoDuplo<>(dado);
        novoNodo.setAnterior(ponteiroTopo);
        if (!estaVazia()) {
			ponteiroTopo.setProximo(novoNodo);
		}
        ponteiroTopo = novoNodo;
        quantidade++;
    }

    /**
     * Método que desempilha o dado no topo da fila.
     * 
     * @throws NoSuckElementException se a pilha estiver vazia
     * @return retorna o dado desempilhado.
     */
    @Override
    public T desempilhar() throws NoSuchElementException {
        if(estaVazia())
            throw new NoSuchElementException("Pilha vazia!");
        T aux = ponteiroTopo.getDado();
        ponteiroTopo = ponteiroTopo.getAnterior();
        quantidade--;
        if(!estaVazia())
            ponteiroTopo.setProximo(null);
        return aux;
    }


    /**
     * Método que mostra o elemento presente no topo da pilha.
     * 
     * @throws NoSuchElementException se a pilha estiver vazia.
     * @return retorno do dado no topo.
     */
    @Override
    public T espiar() throws NoSuchElementException {
        if(estaVazia())
            throw new NoSuchElementException("Pilha vazia!");

        return ponteiroTopo.getDado();
    }

    /**
     * Método que atualiza o dado no topo da pilha.
     * 
     * @throws NoSuchElementException se a pilha estiver vazia.
     */
    @Override
    public void atualizar(T dado) throws NoSuchElementException {
        if(estaVazia())
            throw new NoSuchElementException("Pilha vazia!");
        ponteiroTopo.setDado(dado);
    }
    
}
