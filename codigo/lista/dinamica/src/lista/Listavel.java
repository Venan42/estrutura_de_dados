package lista;

public interface Listavel<T> {
    // C
    public void inserir(int index, T dado); // em inglês insert
    public void anexar(T dado); // em inglês append
    // R
    public T selecionar(int index); //em inglês get
    public T[] selecionarTodos(); //em inglês getAll
    public boolean contem(T dado); //em inglês contains
    public int primeiroIndice(T dado); //em inglês firstIndex
    // U
    public void atualizar(int index, T dado); //em inglês update
    // D
    public T apagar(int index); // em inglês remove
    public void limpar(); // em inglês clear 

    //Auxiliares
    public boolean estaCheia(); // ou boolean isCheia(); em inglês isFull
    public boolean estaVazia(); // ou boolean isVazia(); em inglês isEmpty
    public String imprimir(); // ou void mostrar(); em inglês show
}