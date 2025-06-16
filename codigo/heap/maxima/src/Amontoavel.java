package heap.maxima.src;

public interface Amontoavel<T> {
    void inserir(T dado) throws Exception;
    T obterRaiz();
    T extrair() throws Exception;

    String imprimir();
    boolean estaVazia();
    boolean estaCheia();
}
