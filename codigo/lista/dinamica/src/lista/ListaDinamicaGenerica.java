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
    public void atualizar(int index, T dado) throws NoSuchElementException{
        if(estaVazia())
            throw new UnderFlowException("Lista vazia");
        if(index <0 || index >= quantidade)
            throw new IndexOutOfBoundsException("Índice inválido!");

        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < index; i++) {
            ponteiroAux = ponteiroAux.getProximo();
        }
        ponteiroAux.setDado(dado);
    }

    @Override
    public void inserir(int index, T dado) throws OverFlowException{
        if(estaCheia())
            throw new OverFlowException("Lista cheia!");
        if(index < 0 || index > quantidade)
            throw new IndexOutOfBoundsException("Índice inválido!");
        NodoDuplo<T> novo = new NodoDuplo<>();
        novo.setDado(dado);
        NodoDuplo<T> ponteiroAnterior = null;
        NodoDuplo<T> ponteiroProximo = ponteiroInicio;
        
        for (int i = 0; i < index; i++) {
            ponteiroAnterior = ponteiroProximo;
            ponteiroProximo = ponteiroProximo.getProximo();
        }

		if (ponteiroAnterior != null) {
			ponteiroAnterior.setProximo(novo);
			// se o anterior é nulo é pq a insercao está sendo no inicio
		} else {
			ponteiroInicio = novo;
		}

		if (ponteiroProximo != null) {
			ponteiroProximo.setAnterior(novo);
			// se o proximo é nulo é pq a insercao está sendo no fim (append)
		} else {
			ponteiroFim = novo;
		}



        novo.setAnterior(ponteiroAnterior);
        novo.setProximo(ponteiroProximo);
        quantidade++;
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
        novo.setAnterior(ponteiroFim);
        ponteiroFim = novo;
        quantidade++;
    }

    @Override
    public T selecionar(int index) throws IndexOutOfBoundsException{
        if(estaVazia())
            throw new UnderFlowException("Lista vazia");
        if(index <0 || index >= quantidade)
            throw new IndexOutOfBoundsException("Índice inválido!");
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
        boolean aux = false;
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            if (ponteiroAux.getDado() == dado) {
                aux = true;
                break;
            }
            ponteiroAux = ponteiroAux.getProximo();
        }
        return aux;
    }

    @Override
    public int primeiroIndice(T dado) {
        int resp = -1;
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            resp++;
            if (ponteiroAux.getDado() == dado) {
                break;
            }
        }
        return resp;
    }

    @Override
    public T apagar(int index) throws UnderFlowException {
        if(estaVazia())
            throw new UnderFlowException("Lista vazia!");
        if(index < 0 || index >= quantidade)
            throw new IndexOutOfBoundsException("Índice inválido!");
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        
        for (int i = 0; i < index; i++) {
            ponteiroAux = ponteiroAux.getProximo();
        }
        NodoDuplo<T> ponteiroAnteiror = ponteiroAux.getAnterior();
        NodoDuplo<T> ponteiroProximo = ponteiroAux.getProximo();

        if (ponteiroAnteiror != null) {
            ponteiroAnteiror.setProximo(ponteiroProximo);
        } else {
            ponteiroInicio = ponteiroInicio.getProximo();
        }
        if (ponteiroProximo != null) {
            ponteiroProximo.setAnterior(ponteiroAnteiror);
        } else {
            ponteiroFim = ponteiroFim.getAnterior();
        }
        quantidade--;
        return ponteiroAux.getDado();

    }

    @Override
    public void limpar() {
        ponteiroFim = null;
        ponteiroInicio = null;
        quantidade = 0;
    }

    @Override
    public String imprimir() {
        String resp = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            resp += ponteiroAux.getDado();
            if (i != quantidade - 1)
                resp += ", ";

            ponteiroAux = ponteiroAux.getProximo();
        }
        return resp + "]";
    }
}
