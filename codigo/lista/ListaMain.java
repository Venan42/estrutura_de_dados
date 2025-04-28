package lista;

public class ListaMain {
    public static void main(String[] args) {
        Listavel lista = new ListaEstaticaCircular(10);
        for(int i = 0; i < 8; i++){
            lista.anexar("a");
        }

        lista.inserir("b", 0);
        lista.inserir("c", 1);
        System.out.println(lista.imprimir());

    }
}