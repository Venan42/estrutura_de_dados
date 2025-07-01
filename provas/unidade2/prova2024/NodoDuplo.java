package unidade2.prova2024;


class NodoDuplo<T>{
    private NodoDuplo<T> ponteiroAnterior;
    private T dado;
    private NodoDuplo<T> ponteiroProximo;

    public NodoDuplo(){
        this(null);
    }

    public NodoDuplo(T dado){
        this.dado = dado;
    }
    public NodoDuplo<T> getPonteiroAnterior() {
        return ponteiroAnterior;
    }

    public NodoDuplo<T> getPonteiroProximo() {
        return ponteiroProximo;
    }

    public void setPonteiroProximo(NodoDuplo<T> ponteiroProximo) {
        this.ponteiroProximo = ponteiroProximo;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public void setPonteiroAnterior(NodoDuplo<T> ponteiroAnterior) {
        this.ponteiroAnterior = ponteiroAnterior;
    }
}
