package lista.estatica;

public interface Listavel {
    // C
    public void inserir(Object dado, int index); // em inglês insert
    public void anexar(Object dado); // em inglês append
    // R
    public Object selecionar(int index); //em inglês get
    public Object[] selecionarTodos(); //em inglês getAll
    public boolean contem(Object dado); //em inglês contains
    public int primeiroIndice(Object dado); //em inglês firstIndex
    // U
    public void atualizar(Object dado, int index); //em inglês update
    // D
    public Object apagar(int index); // em inglês remove
    public void limpar(); // em inglês clear 

    //Auxiliares
    public boolean estaCheia(); // ou boolean isCheia(); em inglês isFull
    public boolean estaVazia(); // ou boolean isVazia(); em inglês isEmpty
    public String imprimir(); // ou void mostrar(); em inglês show
}