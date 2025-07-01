package abp;

public interface Arborivel<T> {
    void inserir(T dado);
    NodoTriplo getRaiz();
    void apagar(T dado);
    boolean existe(T dado);
    void limpar();
}
