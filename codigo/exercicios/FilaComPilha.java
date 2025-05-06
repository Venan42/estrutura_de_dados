package exercicios;

import fila.Enfileiravel;
import pilha.estatica.Empilhavel;
import pilha.estatica.PilhaEstatica;

public class FilaComPilha implements Enfileiravel {
    private Empilhavel p1;
    private Empilhavel p2;

    public FilaComPilha(){
        this(10);
    }

    public FilaComPilha(int tamanho){
        p1 = new PilhaEstatica(tamanho);
        p2 = new PilhaEstatica(tamanho);
    }
    
    @Override
    public void enfileirar(Object dado) {
        if(!estaCheia()){
            while(!p1.estaVazia()){
                p2.empilhar(p1.desempilhar());
            }
            p2.empilhar(dado);
            while(!p2.estaVazia()){
                p1.empilhar(p2.desempilhar());
            }
        } else {
            System.err.println("Queue is full!");
        }
    }        

    @Override
    public Object frente(){
        Object aux = null;
        if(!estaVazia()){
            aux = p1.espiar();
        } else {
            System.err.println("Queue is empty!");
        }
        return aux;
    }

    @Override
    public void atualizarInicio(Object dado){
        if(!estaVazia()){
            p1.atualizar(dado);
        } else {
            System.err.println("Queue is empty!");
        }
    }

    @Override
    public void atualizarFim(Object dado){
        if(!estaVazia()){
            while(!p1.estaVazia()){
                p2.empilhar(p1.desempilhar());
            } 
            p2.atualizar(dado);
            while(!p2.estaVazia()){
                p1.empilhar(p2.desempilhar());
            }
        } else {
            System.err.println("Queue is empty!");
        }
    }

    @Override
    public Object desenfileirar(){
        Object aux = null;
        if(!estaVazia()){
            aux = p1.desempilhar();
        } else {
            System.err.println("Queue is empty!");
        }

        return aux;
    }
    
    @Override
    public boolean estaCheia(){
        return p1.estaCheia();
    }

    @Override
    public boolean estaVazia(){
        return p1.estaVazia();
    }

    @Override
    public String imprimir(){
        String aux;
        while(!p1.estaVazia()){
            p2.empilhar(p1.desempilhar());
        }
        aux = p2.imprimir();
        while(!p2.estaVazia()){
            p1.empilhar(p2.desempilhar());
        }
        return aux;
    }

    public static void main(String[] args) {
        Enfileiravel p1 = new FilaComPilha(10);

        p1.enfileirar("Azul");
        p1.enfileirar("O");
        p1.enfileirar("Astronauta");
        p1.enfileirar("de");
        p1.enfileirar("Mármore");

        p1.desenfileirar();

        System.out.println(p1.imprimir());


    }

}
