public interface Questao01 {
    public void anexarReceita(Receita receita);
    public void inserirReceita(Receita receita);
    public void favoritar(Receita receita);
    public Object deletetarReceita(Receita receita);
    public void limparReceitas();
    public Object selecionarReceita(int posicao);
    public Object selecionarTodasReceitas();

}

class Receita {
}
