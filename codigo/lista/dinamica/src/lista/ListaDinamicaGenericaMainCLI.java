package lista;
public class ListaDinamicaGenericaMainCLI {
    public static void main(String[] args) {
        Listavel<String> lista = new ListaDinamicaGenerica<>();
        lista.anexar("O");
        lista.anexar("Astronauta");
        lista.anexar("Azul");
        lista.anexar("de");
        lista.anexar("Marmore");
        lista.apagar(2);

        System.out.println(lista.imprimir());
    }
}
