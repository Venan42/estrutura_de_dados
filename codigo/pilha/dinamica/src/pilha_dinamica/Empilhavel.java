package pilha_dinamica;
public interface Empilhavel<T> {
    public void empilhar(T dado);
    public T desempilhar();
    public void atualizar(T dado);
    public String imprimir();

    public T espiar();
    public boolean estaCheia();
    public boolean estaVazia();

}