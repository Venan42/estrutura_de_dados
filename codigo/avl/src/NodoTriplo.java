package avl.src;


public class NodoTriplo<T> {
    private NodoTriplo<T> filhoEsquerdo;
    private NodoTriplo<T> filhoDireito;
    private NodoTriplo<T> genitor;
    private T dado;
    private int altura;

    public NodoTriplo() {
        altura = 0;
    }

    public NodoTriplo(T dado) {
        this.dado = dado;
        altura = 0;
    }

    public NodoTriplo<T> getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(NodoTriplo<T> filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public NodoTriplo<T> getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(NodoTriplo<T> filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public NodoTriplo<T> getGenitor() {
        return genitor;
    }

    public void setGenitor(NodoTriplo<T> genitor) {
        this.genitor = genitor;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
