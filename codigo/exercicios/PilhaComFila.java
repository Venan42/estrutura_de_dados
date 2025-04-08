package exercicios;

import fila.Enfileiravel;
import fila.FilaEstaticaCircular;
import pilha.Empilhavel;


public class PilhaComFila implements Empilhavel{
    private Enfileiravel f1 = new FilaEstaticaCircular();
    private Enfileiravel f2 = new FilaEstaticaCircular();

    public PilhaComFila(){
        this(10);
    }

    public PilhaComFila(int numero){
        this.f1 = new FilaEstaticaCircular(numero);
        this.f2 = new FilaEstaticaCircular(numero);
    }

    @Override
    public void empilhar(Object dado){
        if(!estaCheia()){
            while(!f1.estaVazia()){
                f2.enfileirar(f1.desenfileirar());
            } 
            f2.enfileirar(dado);
            while(!f2.estaVazia()){
                f1.enfileirar(f2.desenfileirar());
            } 
        } else{
            System.err.println("Stack is full!");
        }
    
    }

    @Override
    public Object desempilhar(){
        Object aux = null;
        if(!estaVazia()){
            while(!f1.estaVazia()){
                f2.enfileirar(f1.desenfileirar());
            } 
            aux = f2.desenfileirar();
            while(!f2.estaVazia()){
                f1.enfileirar(f2.desenfileirar());
            } 
        } else{
            System.err.println("Stack is empty!");
        }

        return aux;
    }

    @Override
    public void atualizar(Object dado){
        if(!estaVazia()){
            while(!f1.estaVazia()){
                f2.enfileirar(f1.desenfileirar());
            } 
            f2.atualizarFim(dado);
            while(!f2.estaVazia()){
                f1.enfileirar(f2.desenfileirar());
            } 
        } else{
            System.err.println("Stack is empty!");
        }
    }
    @Override
    public String imprimir(){
        return f1.imprimir();
    }

    @Override
    public Object espiar(){
        Object aux = null;
        if(!estaVazia()){
            while(!f1.estaVazia()){
                f2.enfileirar(f1.desenfileirar());
            } 
            aux = f2.frente();
            while(!f2.estaVazia()){
                f1.enfileirar(f2.desenfileirar());
            } 
        } else{
            System.err.println("Stack is empty!");
        }

        return aux;
    }
    @Override
    public boolean estaCheia(){
        return f1.estaCheia();
    }
    @Override
    public boolean estaVazia(){
        return f1.estaVazia();
    }

    public static void main(String[] args) {
        Empilhavel p1 = new PilhaComFila();

        p1.empilhar("O");
        p1.empilhar("Astronauta");
        p1.empilhar("de");
        p1.empilhar("Mármore");
        p1.empilhar("Azul");

        p1.desempilhar();

        System.out.println(p1.imprimir());

    }

}
