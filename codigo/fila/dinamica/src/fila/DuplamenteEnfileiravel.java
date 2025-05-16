package fila;

public interface DuplamenteEnfileiravel<T> {
    void enfileirarInicio(T dado); 
    void enfileirarFim(T dado); 

    T frente();  
    T tras();   

    void atualizarInicio(T dado);         
    void atualizarFim(T dado);  

    T desenfileirarInicio();   
    T desenfileirarFim();      
   
    boolean estaCheia();
    boolean estaVazia();

    String imprimirTrasFrente();
    String imprimirFrenteTras();
    
    void limpar();

}
