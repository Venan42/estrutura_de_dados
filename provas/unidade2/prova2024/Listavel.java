package unidade2.prova2024;

public interface Listavel<T>{
    void inserir(int index, T dado) throws Exception;
    void anexar(T dado) throws Exception;

    T selecionar(int index) throws Exception;

    T apagar(int index) throws Exception;
    boolean estaCheia();
    boolean estaVazia();
    String imprimirPosicao(int index) throws Exception;
}
