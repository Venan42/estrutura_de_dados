public class PilhaMain {
    public static void main(String[] args) {
        Empilhavel p = new PilhaEstatica();
        p.empilhar("O");
        p.empilhar("Astronauta");
        p.empilhar("de");
        p.empilhar("Mármore");
        p.empilhar("Azul");

        p.desempilhar();
        System.out.println(p.imprimir());
    }
}