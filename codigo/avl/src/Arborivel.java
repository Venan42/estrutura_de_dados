package avl.src;

public interface Arborivel<T> {
    void inserir(T dado);
    NodoTriplo<T> getRaiz();
    void apagar(T dado) throws Exception;
    boolean existe(T dado);
    void limpar();
    NodoTriplo<T> buscar(T dado);
}
