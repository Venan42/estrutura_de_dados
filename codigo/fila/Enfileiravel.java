package fila;

public interface Enfileiravel{
    void enfileirar(Object dado);               //Enqueue     
    Object frente();                            //Front
    void atualizarInicio(Object dado);          //Update head
    void atualizarFim(Object dado);             //Uptade trail
    Object desenfileirar();                     //Dequeue
   
    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}