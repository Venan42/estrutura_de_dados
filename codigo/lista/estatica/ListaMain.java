package lista.estatica;

public class ListaMain {
    public static void main(String[] args) {
        Listavel lista = new ListaEstaticaCircular(10);
        for(int i = 0; i < 9; i++){
            lista.anexar("a");
        }

        lista.inserir("b", 10);
        System.out.println(lista.imprimir());

    }
}