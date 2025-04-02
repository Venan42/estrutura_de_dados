package Fila.FilaEstaticaDupla;

public class FilaEstaticaDupla implements DuplamenteEnfileravel{
    private Object[] dados;    
    private int ponteiroInicio; 
    private int ponteiroFim;  
    private int quantidade;  

    public FilaEstaticaDupla(){
        this(10);
    }

    public FilaEstaticaDupla(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        this.quantidade = 0;
    }

    @Override
    public void enfileirarInicio(Object dado) {
        if(!estaCheia()){
            ponteiroFim = ((ponteiroFim-1)+dados.length)%dados.length;
            dados[ponteiroFim] = dado;
            quantidade++;
        }else{
            System.err.println("Queue is Full!");
        }
    }

    @Override
    public void enfileirarFim(Object dado) {
        if(!estaCheia()){
            ponteiroFim = (ponteiroFim+1)%dados.length;
            dados[ponteiroFim] = dado;
            quantidade++;
        }else{
            System.err.println("Queue is Full!");
        }
    }

    @Override
    public Object desenfileirarInicio() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
            ponteiroInicio = (ponteiroInicio+1)%dados.length;
            quantidade--;
        }else{
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public Object desenfileirarFim() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroFim];
            ponteiroInicio = ((ponteiroFim+1)+dados.length)%dados.length;
            quantidade--;
        }else{
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public Object frente() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
        }else{
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    
    @Override
    public Object tras() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroFim];
        }else{
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

     @Override
    public void atualizarInicio(Object dado) {
        if(!estaVazia()){
            dados[ponteiroInicio] = dado;
        } else {
            System.err.println("Queue is Empty!!!");
        }
    }

    @Override
    public void atualizarFim(Object dado) {
        if(!estaVazia()){
            dados[ponteiroFim] = dado;
        } else {
            System.err.println("Queue is Empty!!!");
        }
    }

    @Override
    public boolean estaCheia() {
        return (quantidade == dados.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String imprimirTrasFrente() {
        String aux = "[";
        for(int i = ponteiroFim;i > ponteiroFim - quantidade;i--){
            if ((i+dados.length)%dados.length == ponteiroInicio){
                aux += dados[i%dados.length]; //% - Volta para o inicio, se alcançar o fim
            } else {
                aux += dados[i%dados.length] + ", ";
            }
        }
        return aux + "]";
    } 

    @Override
    public String imprimirFrenteTras() {
        String aux = "[";
        for(int i = ponteiroInicio;i < quantidade + ponteiroInicio;i++){
            if (i%dados.length == ponteiroFim){
                aux += dados[i%dados.length]; //% - Volta para o inicio, se alcançar o fim
            } else {
                aux += dados[i%dados.length] + ", ";
            }
        }
        return aux + "]";
    }

    
}
