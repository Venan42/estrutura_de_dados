package Fila;

public class FilaMain {
    public static void main(String[] args) {
        Enfileiravel f1 = new FilaEstatica();
        Enfileiravel f2 = new FilaEstaticaCircular(8);
        DuplamenteEnfileravel f3 = new FilaEstaticaDupla(15);
        
        f1.enfileirar("Azul");
        f1.enfileirar("O");
        f1.enfileirar("Astronauta");
        f1.enfileirar("de");
        f1.enfileirar("Mármore");
        f1.desenfileirar();

        f2.enfileirar("Azul");
        f2.enfileirar("O");
        f2.enfileirar("Astronauta");
        f2.enfileirar("de");
        f2.enfileirar("Mármore");
        f2.desenfileirar();

        f3.enfileirarFim("Azul");
        f3.enfileirarFim("O");
        f3.enfileirarFim("Astronauta");
        f3.enfileirarFim("de");
        f3.enfileirarFim("Mármore");
        f3.desenfileirarInicio();


        System.out.println(f1.imprimir());
        System.out.println(f2.imprimir());
        System.out.println(f3.imprimirTrasFrente());
        System.out.println(f3.imprimirFrenteTras());

    }
    
}
