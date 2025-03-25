package Fila;

public class FilaEstatica implements Enfileiravel{
    private Object[] dados;    
    private int ponteiroInicio; //head
    private int ponteiroFim;    //tail

    public FilaEstatica() {
        this(10);
    }

    public FilaEstatica(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
    }

    @Override
    public void enfileirar(Object dado) {
        if(!estaCheia()){
            ponteiroFim++;
            dados[ponteiroFim] = dado;
        }else{
            System.err.println("Queue is Full!");
        }
    }

    @Override
    public Object desenfileirar() {
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
            ponteiroInicio++;
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
        return (ponteiroFim == dados.length-1);
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroFim == ponteiroInicio-1);
    }    

    @Override
    public String imprimir() {
        String aux = "[";
        for(int i = ponteiroInicio;i <= ponteiroFim;i++){
            if (i == ponteiroFim)
                aux += dados[i];
            else
                aux += dados[i] + ", ";
        }
        return aux + "]";
    } 
}