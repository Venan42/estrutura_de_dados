package Java;

public class aula_pilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.adicionar("E");
        pilha.adicionar("B");
        pilha.adicionar("Z");
        pilha.adicionar("D");
        pilha.adicionar("C");
        pilha.adicionar("I");

        System.out.println("Topo: " + pilha.get());

        pilha.remover();

        System.out.println("Novo Topo: " + pilha.get());
    }
}
