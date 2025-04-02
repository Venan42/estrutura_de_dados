package Fila.FilaEstaticaCircular;

import Fila.FilaEstatica.Enfileiravel;

public class FilaEstaticaCircular implements Enfileiravel{
    private Object[] dados;    
    private int ponteiroInicio; 
    private int ponteiroFim;  
    private int quantidade;  

    public FilaEstaticaCircular() {
        this(10);
    }

    public FilaEstaticaCircular(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        this.quantidade = 0;
    }

    @Override
    public void enfileirar(Object dado) {
        if(!estaCheia()){
            ponteiroFim = (ponteiroFim+1)%dados.length;
            dados[ponteiroFim] = dado;
            quantidade++;
        }else{
            System.err.println("Queue is Full!");
        }
    }

    @Override
    public Object desenfileirar() {
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
        return (quantidade == dados.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }    

    @Override
    public String imprimir() {
        String aux = "[";
        for(int i = ponteiroInicio;i < quantidade + ponteiroInicio;i++){
            if (i == (quantidade+ponteiroInicio)-1){
                aux += dados[i%dados.length]; //% - Volta para o inicio, se alcançar o fim
            } else {
                aux += dados[i] + ", ";
            }
        }
        return aux + "]";
    } 
}
