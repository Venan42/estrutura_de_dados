package unidade2.heap;

public interface Amontoavel<T> {
    void inserir(T dado) throws Exception;
    T extrair() throws Exception;
    T obterRaiz() throws Exception;

    String imprimir();
    boolean estaVazia();
    boolean estaCheia();

}
