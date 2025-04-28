public interface ListaAfazeres {
    //Adiciona uma tarefa no ultimo lugar da lista
    public void adicionarTarefa(String tarefa);
    //Insere uma tarefa núm indice escolhido
    public void inserirTarefa(String tarefa, int posicao);

    //Apaga uma tarefa na posição escolhida
    public String apagarTarefa(int posicao);
    //Limpa toda a lista de afazeres
    public String limparListaDeAfazeres();

    //Marcar como afazer urgente
    public void afazerUrgente(int posicao);
    //Marcar como afazer não importante
    public void afazerNaoImportante(int posicao);
    //Checar se o afazer ainda está na lista
    public boolean checarAfazer(String tarefa);

    //Auxiliares
    public boolean estaCheia();
    public boolean estaVazia();
    public String imprimir();
}
