import java.util.NoSuchElementException;

/**
 * Implementação de uma lista dinâmica duplamente encadeada genérica.
 *
 * @param <T> o tipo de dado que a lista irá armazenar.
 * @author Vinícius Nunes de Andrade
 * @version 1
 * @since 26-05-2025
 */
public class ListaDinamicaGenerica<T> implements Listavel<T> {
    private int quantidade;
    private int tamanho;
    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;

    /**
     * Construtor padrão. Cria uma lista com capacidade para 10 elementos.
     */
    public ListaDinamicaGenerica() {
        this(10);
    }

    /**
     * Construtor que cria uma lista com uma capacidade máxima especificada.
     *
     * @param tamanho a capacidade máxima da lista.
     */
    public ListaDinamicaGenerica(int tamanho) {
        quantidade = 0;
        this.tamanho = tamanho;
        ponteiroInicio = null;
        ponteiroFim = null;
    }

    /**
     * Verifica se a lista atingiu sua capacidade máxima de elementos.
     *
     * @return {@code true} se a lista está cheia, {@code false} caso contrário.
     */
    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    /**
     * Verifica se a lista não contém elementos.
     *
     * @return {@code true} se a lista está vazia, {@code false} caso contrário.
     */
    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    /**
     * Atualiza o dado numa posição específica da lista.
     *
     * @param index o índice do elemento a ser atualizado.
     * @param dado o novo dado a ser colocado na posição.
     * @throws UnderFlowException se a lista estiver vazia.
     * @throws IndexOutOfBoundsException se o índice for inválido (menor que 0 ou maior ou igual à quantidade de elementos).
     */
    @Override
    public void atualizar(int index, T dado) throws UnderFlowException, IndexOutOfBoundsException { // Corrigido para UnderFlowException
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

    /**
     * Insere um dado numa posição específica da lista.
     * Os elementos existentes a partir dessa posição são deslocados.
     *
     * @param index o índice onde o dado será inserido.
     * @param dado o dado a ser inserido na lista.
     * @throws OverFlowException se a lista estiver cheia.
     * @throws IndexOutOfBoundsException se o índice for inválido (menor que 0 ou maior que a quantidade atual de elementos).
     */
    @Override
    public void inserir(int index, T dado) throws OverFlowException, IndexOutOfBoundsException {
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
        } else {
            ponteiroInicio = novo;
        }

        if (ponteiroProximo != null) {
            ponteiroProximo.setAnterior(novo);
        } else {
            ponteiroFim = novo; // Inserção no fim, atualiza ponteiroFim
        }

        novo.setAnterior(ponteiroAnterior);
        novo.setProximo(ponteiroProximo);
        quantidade++;
    }

    /**
     * Adiciona um dado ao final da lista.
     *
     * @param dado o dado a ser anexado à lista.
     * @throws OverFlowException se a lista estiver cheia.
     */
    @Override
    public void anexar(T dado) throws OverFlowException { // Corrigido para OverFlowException
        if(estaCheia())
            throw new OverFlowException("Fila cheia!"); // A mensagem "Fila cheia" pode ser um engano, deveria ser "Lista cheia"
        NodoDuplo<T> novo = new NodoDuplo<>(dado);
        //novo.setFilhoEsquerdo(ponteiroFim); // Esta linha parece redundante devido à lógica abaixo
        if (!estaVazia()) {
            ponteiroFim.setProximo(novo);
            novo.setAnterior(ponteiroFim); // anterior do novo é o antigo fim
        } else {
            ponteiroInicio = novo; // Se vazia, novo é o início e o fim
        }
        //novo.setFilhoEsquerdo(ponteiroFim); // Esta linha está incorreta aqui ou redundante com a de cima
        ponteiroFim = novo; // Novo nó é sempre o novo fim
        quantidade++;
    }

    /**
     * Retorna o dado armazenado numa posição específica da lista.
     *
     * @param index o índice do elemento a ser recuperado.
     * @return o dado na posição especificada.
     * @throws UnderFlowException se a lista estiver vazia.
     * @throws IndexOutOfBoundsException se o índice for inválido.
     */
    @Override
    public T selecionar(int index) throws UnderFlowException, IndexOutOfBoundsException { // Corrigido
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

    /**
     * Retorna todos os dados da lista como um array.
     *
     * @return um array contendo todos os elementos da lista na ordem em que foram inseridos.
     * @throws UnderFlowException se a lista estiver vazia.
     */
    @Override
    public T[] selecionarTodos() throws UnderFlowException { // Corrigido
        if(estaVazia())
            throw new UnderFlowException("Lista vazia");
        NodoDuplo<T> novo = ponteiroInicio;
        @SuppressWarnings("unchecked") // Necessário devido à criação de array genérico
        T[] aux = (T[]) new Object[quantidade];
        for (int i = 0; i < quantidade; i++) {
            aux[i] = novo.getDado();
            novo = novo.getProximo();
        }
        return aux;
    }

    /**
     * Verifica se a lista contém um determinado dado.
     * A comparação é feita usando o operador '=='.
     *
     * @param dado o dado a ser verificado.
     * @return {@code true} se o dado está presente na lista, {@code false} caso contrário.
     */
    @Override
    public boolean contem(T dado) {
        boolean aux = false;
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            if (ponteiroAux.getDado() == dado) { // Atenção: comparação por referência, não por equals()
                aux = true;
                break;
            }
            ponteiroAux = ponteiroAux.getProximo();
        }
        return aux;
    }

    /**
     * Retorna o índice da primeira ocorrência de um determinado dado na lista.
     * A comparação é feita usando o operador '=='.
     *
     * @param dado o dado a ser procurado.
     * @return o índice da primeira ocorrência do dado, ou -1 se o dado não for encontrado
     * ou se a lista estiver vazia (devido à inicialização de resp e incremento).
     * Se o primeiro elemento for o dado, retorna 0.
     */
    @Override
    public int primeiroIndice(T dado) {
        int resp = -1;
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            if (ponteiroAux.getDado() == dado) {
                resp = i;
            }
            ponteiroAux = ponteiroAux.getProximo();
        }
        return resp; // Retorna -1 se não encontrado
    }

    /**
     * Remove e retorna o dado de uma posição específica da lista.
     * Os elementos subsequentes são deslocados para preencher o espaço.
     *
     * @param index o índice do elemento a ser apagado.
     * @return o dado que foi removido da lista.
     * @throws UnderFlowException se a lista estiver vazia.
     * @throws IndexOutOfBoundsException se o índice for inválido.
     */
    @Override
    public T apagar(int index) throws UnderFlowException, IndexOutOfBoundsException {
        if(estaVazia())
            throw new UnderFlowException("Lista vazia!");
        if(index < 0 || index >= quantidade)
            throw new IndexOutOfBoundsException("Índice inválido!");

        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < index; i++) {
            ponteiroAux = ponteiroAux.getProximo();
        }

        NodoDuplo<T> ponteiroAnterior = ponteiroAux.getAnterior(); // Corrigido nome da variável
        NodoDuplo<T> ponteiroProximo = ponteiroAux.getProximo();

        if (ponteiroAnterior != null) {
            ponteiroAnterior.setProximo(ponteiroProximo);
        } else { // Removendo o primeiro elemento
            ponteiroInicio = ponteiroProximo; // ponteiroInicio agora aponta para o próximo do aux
        }

        if (ponteiroProximo != null) {
            ponteiroProximo.setAnterior(ponteiroAnterior);
        } else { // Removendo o último elemento
            ponteiroFim = ponteiroAnterior; // ponteiroFim agora aponta para o anterior do aux
        }

        // Caso especial: remoção do único elemento
        if (ponteiroInicio == null) {
            ponteiroFim = null;
        }
        // Caso especial: se após a remoção o ponteiroInicio não for nulo, mas seu anterior deveria ser nulo
        if (ponteiroInicio != null) {
            ponteiroInicio.setAnterior(null);
        }
        // Caso especial: se após a remoção o ponteiroFim não for nulo, mas seu próximo deveria ser nulo
        if (ponteiroFim != null) {
            ponteiroFim.setProximo(null);
        }

        quantidade--;
        return ponteiroAux.getDado();
    }

    /**
     * Remove todos os elementos da lista, deixando-a vazia.
     */
    @Override
    public void limpar() {
        ponteiroFim = null;
        ponteiroInicio = null;
        quantidade = 0;
    }

    /**
     * Retorna uma representação em ‘String’ da lista.
     * Os elementos são exibidos entre colchetes e separados por vírgula.
     *
     * @return uma ‘string’ representando o conteúdo da lista.
     */
    @Override
    public String imprimir() {
        String resp = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            resp += ponteiroAux.getDado();
            if (i < quantidade - 1) { // Corrigido para i < quantidade - 1 para evitar vírgula no final
                resp += ", ";
            }
            ponteiroAux = ponteiroAux.getProximo();
        }
        return resp + "]";
    }
}