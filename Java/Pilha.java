package Java;

public class Pilha {
    //Irei utilizar uma classe que o professor Leguarino disponibilizou na aula dele
    private ListaLigada lista;

    public Pilha()  {
        this.lista = new ListaLigada();
    }

    public void adicionar(String novoValor)  {
        this.lista.adicionarComeco(novoValor);
    }

    public void remover()  {
        this.lista.remover(this.get());
    }

    public String get() {
        return this.lista.getPrimeiro().getValor();
    }
}