//compilar um código-fonte específico: 
//javac src/Enfileiravel.java -d bin
public interface DuplamenteEnfileiravelGenerica<T>{
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
}