package monitoria.unidade2.pilha;

public class LinkedStack<T> {
    private Node<T> topo;
    private int quantidade;
    private int tamanho;

    public LinkedStack() {
        this(100000);
    }

    public LinkedStack(int tamanho) {
        this.tamanho = tamanho;
        this.quantidade = 0;
        this.topo = null;
    }

    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    public void empilhar(T dado) throws Exception {
        if(estaCheia()) {
            throw new Exception("A pilha esta cheia!");
        }

        Node<T> novoNodo = new Node<>(dado);
        novoNodo.setProximo(topo);
        if(topo != null) {
            topo.setAnterior(novoNodo);
        }
        topo = novoNodo;
        quantidade++;
    }

    public T topo() throws Exception {
        if(estaVazia()) {
            throw new Exception("A pilha esta vazia!");
        }

        return topo.getDado();
    }

    public T desempilhar() throws Exception {
        if(estaVazia()) {
            throw new Exception("A pilha esta vazia!");
        }

        T aux = topo.getDado();
        topo = topo.getProximo();
        quantidade--;
        return aux;
    }

    public void atualizar(T dado) throws Exception {
        if(estaVazia()) {
            throw new Exception("A pilha esta vazia!");
        }

        topo.setDado(dado);
    }

    public static void main(String[] args) throws Exception {
        LinkedStack<Integer> pilha = new LinkedStack<>(10000);
        pilha.empilhar(4);
        pilha.empilhar(5);
        pilha.empilhar(3);

        System.out.println("Topo: " + pilha.topo());

        pilha.desempilhar();

        System.out.println("Novo topo: " + pilha.topo());

    }
}
