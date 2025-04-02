import PilhaDupla.EmpilhavelDupla;
import PilhaDupla.PilhaDupla;
import PilhaEstatica.Empilhavel;
import PilhaEstatica.PilhaEstatica;
import PilhaInversa.PilhaInversa;

public class PilhaMain {
    public static void main(String[] args) {
        Empilhavel p = new PilhaEstatica();
        Empilhavel p2 = new PilhaEstatica();
        Empilhavel p3 = new PilhaInversa();
        EmpilhavelDupla p4 = new PilhaDupla(15);
        p.empilhar("O");
        p.empilhar("Astronauta");
        p.empilhar("de");
        p.empilhar("Mármore");
        p.empilhar("Azul");

        p.desempilhar();
        System.out.println(p.imprimir());

        p2.empilhar("Azul");
        System.out.println(p2.imprimir());

        p3.empilhar("Mármore");
        p3.empilhar("de");
        p3.empilhar("Astronauta");
        p3.empilhar("O");
        p3.empilhar("Azul");
        p3.desempilhar();

        System.out.println(p3.imprimir());

        p4.empilhar1("O");
        p4.empilhar1("Astronauta");
        p4.empilhar1("de");
        p4.empilhar1("Mármore");
        p4.empilhar1("Azul");
        p4.desempilhar1();

        p4.empilhar2("Mármore");
        p4.empilhar2("de");
        p4.empilhar2("Astronauta");
        p4.empilhar2("O");
        p4.empilhar2("Azul");
        p4.desempilhar2();

        System.out.println(p4.imprimir1());
        System.out.println(p4.imprimir2());



    }
}