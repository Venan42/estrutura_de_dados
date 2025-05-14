package pilha_dinamica;

public class PilhaDinamicaGenericaMain {
    public static void main(String[] args) {
        PilhaDinamicaGenerica<Integer> p = new PilhaDinamicaGenerica<>(214748364);
        for(int i = 0; i < 21474836; i++){
            p.empilhar(i);
        }
        System.out.println(p.imprimir());
    }
}
