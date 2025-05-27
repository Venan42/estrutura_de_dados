public interface Enfileiravel{
    public void enfileirar(Object dado);               //Enqueue     
    public Object frente();                            //Front
    public void atualizarInicio(Object dado);          //Update head
    public void atualizarFim(Object dado);             //Uptade trail
    public Object desenfileirar();                     //Dequeue
   
    public boolean estaCheia();
    public boolean estaVazia();
    public String imprimir();
    public int tamanho();
}