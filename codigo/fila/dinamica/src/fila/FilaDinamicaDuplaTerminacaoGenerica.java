/**
 * Código referente a uma Fila Genérica
 * que cresce de forma dinâmica.
 * 
 * @author Vinícius Nunes de Andrade
 * @version 1
 * @since 16-05-2025
 */
package fila;
import java.util.NoSuchElementException;
public class FilaDinamicaDuplaTerminacaoGenerica<T> implements DuplamenteEnfileiravel<T> {
    private NodoDuplo<T> ponteiroFim;
    private NodoDuplo<T> ponteiroInicio;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor vazio da Fila.
     */
    public FilaDinamicaDuplaTerminacaoGenerica(){
        this(10);
    }
    /**
     * Construtor que inicializa as variáveis de intância da Fila Dinâmica.
     * @param tamanho indica o tamanho máximo da Fila Dinâmica.
     */
    public FilaDinamicaDuplaTerminacaoGenerica(int tamanho) {
        this.tamanho = tamanho;
        quantidade = 0;
        ponteiroFim = null;
        ponteiroInicio = null;
    }
    
    /**
     * Enfileira um dado ao fim da Fila.
     * 
     * @param dado, dado a ser enfileirado
     * @throws NoSuchElementException se a fila estiver cheia.
     */
    @Override
    public void enfileirarFim(T dado) throws NoSuchElementException {
        if (estaCheia())
            throw new NoSuchElementException("Queue is Full!");
        NodoDuplo<T> novo = new NodoDuplo<>(dado);
        if (estaVazia()) {
            ponteiroFim = novo;
            ponteiroInicio = novo;
        }
        novo.setAnterior(ponteiroFim);
        ponteiroFim.setProximo(novo);
        ponteiroFim = novo;
        quantidade++;
    }
    
    /**
     * Enfileira um dado ao inicio da Fila.
     * 
     * @param dado, dado a ser enfileirado
     * @throws NoSuchElementException se a fila estiver cheia.
     */
    @Override
    public void enfileirarInicio(T dado) throws NoSuchElementException {
        if (estaCheia())
            throw new NoSuchElementException("Queue is Full!");
        NodoDuplo<T> novo = new NodoDuplo<>(dado);
        if (estaVazia()) {
            ponteiroFim = novo;
            ponteiroInicio = novo;
        }
        novo.setProximo(ponteiroInicio);
        ponteiroInicio.setAnterior(novo);
        ponteiroInicio = novo;
        quantidade++;
    }

    /**
     * Desenfileira o dado presente no inicio da fila.
     * 
     * @throws NoSuchElementException se a fila estiver vazia.
     */
    @Override
    public T desenfileirarInicio() {
        if (estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        T dadoInicio = ponteiroInicio.getDado();
        ponteiroInicio = ponteiroInicio.getProximo();
        quantidade--;
        if (!estaVazia())
            ponteiroInicio.setAnterior(null);
        else
            ponteiroFim = null;

        return dadoInicio;
    }

    /**
     * Desenfileira o dado presente no fim da fila.
     * 
     * @throws NoSuchElementException se a fila estiver vazia.
     */
    @Override
    public T desenfileirarFim() throws NoSuchElementException {
        if (estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        T dadoFim = ponteiroFim.getDado();
        ponteiroFim = ponteiroFim.getAnterior();
        quantidade--;
        if (!estaVazia())
            ponteiroFim.setProximo(null);
        else
            ponteiroFim = null;

        return dadoFim;
    }
    
    /**
     * Mostra o dado presente no inicio da fila.
     * 
     * @return dado no inicio da fila.
     */
    @Override
    public T frente() throws NoSuchElementException {
        if (estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        return ponteiroInicio.getDado();
    }

    /**
     * Mostra o dado presente no fim da fila.
     * 
     * @return dado no fim da fila.
     */
    @Override
    public T tras() throws NoSuchElementException{
        if (estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        return ponteiroFim.getDado();
    }


    /**
     * Atualiza o dado presente no início da fila.
     * 
     * @param dado que irá substituir o dado no início da fila.
     * @throws NoSuchElementException se a fila estiver vazia.
     */
    @Override
    public void atualizarInicio(T dado) throws NoSuchElementException {
        if (estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        ponteiroInicio.setDado(dado);
    }

    /**
     * Atualiza o dado presente no fim da fila.
     * 
     * @param dado que irá substituir o dado no fim da fila.
     * @throws NoSuchElementException se a fila estiver vazia.
     */
    @Override
    public void atualizarFim(T dado) throws NoSuchElementException {
        if (estaVazia())
            throw new NoSuchElementException("Queue is Empty!");
        ponteiroFim.setDado(dado);
    }

    /**
     * Checa se a fila está cheia, retornando true se estiver.
     * 
     * @return valor booleano que diz se a fila está cheia ou não.
     */
    @Override
    public boolean estaCheia() {
        return (quantidade == tamanho);
    }

    /**
     * Checa se a fila está vazia, retornando true se estiver.
     * 
     * @return valor booleano que diz se a fila está vazia ou não.
     */
    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    /**
     * Método que imprime os dados da fila, começando do primeiro
     * dado e terminando no ultimo.
     * 
     * @return retorno da String com os dados.     */
    @Override
    public String imprimirFrenteTras() {
        String aux = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            aux += ponteiroAux.getDado();
            if (i != quantidade - 1)
                aux += ", ";
            ponteiroAux = ponteiroAux.getProximo();
        }
        return aux + "]";
    }

    /**
     * Método que imprime os dados da fila, começando do último
     * dado e terminando no primeiro.
     * 
     * @return retorno da String com os dados.
     */
    @Override
    public String imprimirTrasFrente() {
        String aux = "[";
        NodoDuplo<T> ponteiroAux = ponteiroFim;
        for (int i = quantidade; i > 0; i--) {
            aux += ponteiroAux.getDado();
            if (i != 1)
                aux += ", ";
            ponteiroAux = ponteiroAux.getAnterior();
        }
        return aux + "]";
    }

    /**
     * Método que limpa a fila.
     */
    @Override
    public void limpar() {
        quantidade = 0;
        ponteiroFim = null;
        ponteiroInicio = null;
    }
}
