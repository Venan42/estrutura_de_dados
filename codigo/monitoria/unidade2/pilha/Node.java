package monitoria.unidade2.pilha;

public class Node<T> {
    private Node<T> anterior;
    private Node<T> proximo;
    private T dado;

    public Node() {
        this(null);
    }

    public Node(T dado) {
        this.dado = dado;
        anterior = null;
        proximo = null;
    }

    public Node<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Node<T> anterior) {
        this.anterior = anterior;
    }

    public Node<T> getProximo() {
        return proximo;
    }

    public void setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }
}
