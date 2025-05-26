public class NodoDuplo<T> {
    private NodoDuplo<T> anterior;
    private T dado;
    private NodoDuplo<T> proximo;

    public NodoDuplo() {
        this(null);
    }

    public NodoDuplo(T dado) {
        this.anterior = null;
        this.dado = dado;
        this.proximo = null;
    }

    public NodoDuplo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }
    
    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NodoDuplo<T> getProximo() {
        return proximo;
    }

    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }



}
