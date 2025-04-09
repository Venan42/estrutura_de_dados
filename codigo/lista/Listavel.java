package lista;
public interface Listavel {
    // C
    public void inserir(Object dado, int index); // ou void anexar(Object dado); em inglês insert
    public void anexar(Object dado); // ou void anexar(Object dado); em inglês append
    // R
    public Object selecionar(int index); // ou Object obter(int posicao); em inglês get
    public Object[] selecionarTodos(); // ou Object[] obterTodos(); em inglês getAll
    public boolean contem(Object dado); // ou boolean contem(Object dado); em inglês contains
    public int primeiroIndice(Object dado); // ou int primeiroIndice(Object dado); em inglês firstIndex
    // U
    public void atualizar(Object dado, int index); // ou void atualizar(int posicao, Object dado); em inglês update
    // D
    public Object apagar(int index); // ou void remover(); em inglês remove
    public void limpar(); // ou void apagarTudo(); em inglês clear 
    public boolean estaCheia(); // ou boolean isCheia(); em inglês isFull
    public boolean estaVazia(); // ou boolean isVazia(); em inglês isEmpty
    public String imprimir(); // ou void mostrar(); em inglês show
}