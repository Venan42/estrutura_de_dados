package lista;

import java.util.NoSuchElementException;

public class ListaDinamicaGenerica<T> implements Listavel<T> {
	private int quantidade;
	private int tamanho;
	private NodoDuplo<T> ponteiroInicio;
	private NodoDuplo<T> ponteiroFim;

	public ListaDinamicaGenerica() {
		this(10);
	}

    public ListaDinamicaGenerica(int tamanho) {
        quantidade = 0;
        this.tamanho = tamanho;
        ponteiroInicio = null;
        ponteiroFim = null;
    }

    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public void atualizar(T dado, int index) throws NoSuchElementException{
        if(estaVazia())
            throw new UnderFlowException("Lista vazia");
        if(index <0 || index >= quantidade)
            throw new NoSuchElementException("Índice inválido");
        if (index == quantidade - 1) {
            ponteiroFim.setDado(dado);
            return;
        }
        if (index == 1) {
            ponteiroInicio.setDado(dado);
            return;
        }
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < index; i++) {
            ponteiroAux = ponteiroAux.getProximo();
        }
        ponteiroAux.setDado(dado);
    }

    @Override
    public void inserir(T dado, int index) {
        
    }

    @Override
    public void anexar(T dado) {
        if(estaCheia())
            throw new OverFlowException("Fila cheia!");
        NodoDuplo<T> novo = new NodoDuplo<>(dado);
        novo.setAnterior(ponteiroFim);
        if (!estaVazia())
            ponteiroFim.setProximo(novo);
        else
            ponteiroInicio = novo;
        quantidade++;
    }

    @Override
    public T selecionar(int index) throws NoSuchElementException{
        if(estaVazia())
            throw new UnderFlowException("Lista vazia");
        if(index <0 || index >= quantidade)
            throw new NoSuchElementException("Índice inválido");
        NodoDuplo<T> novo = ponteiroInicio;
        for (int i = 0; i < index; i++) {
            novo = novo.getProximo();
        }
        return novo.getDado();
    }   

    @Override
    public T[] selecionarTodos() throws NoSuchElementException{
        if(estaVazia())
            throw new UnderFlowException("Lista vazia");
        NodoDuplo<T> novo = ponteiroInicio;
        T[] aux = (T[]) new Object[quantidade];
        for (int i = 0; i < quantidade; i++) {
            aux[i] = novo.getDado();
            novo = novo.getProximo();
        }
        return aux;
    }

    @Override
    public boolean contem(T dado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int primeiroIndice(T dado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T apagar(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String imprimir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
