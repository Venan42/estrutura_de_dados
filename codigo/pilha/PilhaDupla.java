package pilha;

public class PilhaDupla implements EmpilhavelDupla {
    public Object[] dados;
    public int ponteiroTopoInverso;
    public int ponteiroTopo;

    public PilhaDupla(){
        this(10);
    }

    public PilhaDupla(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroTopoInverso = dados.length;
        this.ponteiroTopo = -1;
    }
    //Métodos necessários 
    @Override
    public void empilhar1(Object dado){
        if(!this.estaCheia1()) {
            ponteiroTopo++;
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public Object desempilhar1(){
        Object aux = null;
        if(!this.estaVazia1()) {
            aux = dados[ponteiroTopo];
            ponteiroTopo--;
        } else {
            System.err.println("Stack is empty");
        }

        return aux;
    }
    @Override
    public void atualizar1(Object dado) {
        if(!this.estaVazia1()) {
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is empty!");
        }
    }

    @Override
    public String imprimir1(){
        String resultado = "[";

        if(!estaVazia1()) {
            for(int i = 0; i <= ponteiroTopo; i++) {
                if(i != ponteiroTopo) {
                    resultado += dados[i] + ", ";
                } else {
                    resultado += dados[i];
                }
            }
        } else {
            System.err.println("Stack is empty!");
        }

        return resultado + "]";
    }
    //Métodos auxiliares
    @Override
    public Object espiar1(){
        Object aux = null;
        if(!this.estaVazia1()) {
            aux = dados[ponteiroTopo];
        } else {
            System.err.println("Stack is empty");
        }

        return aux;
    }

    @Override
    public boolean estaCheia1(){
        return (ponteiroTopo + 1 == ponteiroTopoInverso);
    }

    @Override
    public boolean estaVazia1(){
        return (ponteiroTopo == -1);
    }

    @Override
    public void empilhar2(Object dado){
        if(!this.estaCheia2()) {
            ponteiroTopoInverso--;
            dados[ponteiroTopoInverso] = dado;
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public Object desempilhar2(){
        Object aux = null;
        if(!this.estaVazia2()) {
            aux = dados[ponteiroTopoInverso];
            ponteiroTopoInverso++;
        } else {
            System.err.println("Stack is empty");
        }

        return aux;
    }
    @Override
    public void atualizar2(Object dado) {
        if(!this.estaVazia2()) {
            dados[ponteiroTopoInverso] = dado;
        } else {
            System.err.println("Stack is empty!");
        }
    }

    @Override
    public String imprimir2(){
        String resultado = "[";

        if(!estaVazia2()) {
            for(int i = ponteiroTopoInverso; i < dados.length; i++) {
                if(i != dados.length-1) {
                    resultado += dados[i] + ", ";
                } else {
                    resultado += dados[i];
                }
            }
        } else {
            System.err.println("Stack is empty!");
        }

        return resultado + "]";
    }
    //Métodos auxiliares
    @Override
    public Object espiar2(){
        Object aux = null;
        if(!this.estaVazia2()) {
            aux = dados[ponteiroTopoInverso];
        } else {
            System.err.println("Stack is empty");
        }

        return aux;
    }

    @Override
    public boolean estaCheia2(){
        return (ponteiroTopoInverso -1 == ponteiroTopo);
    }

    @Override
    public boolean estaVazia2(){
        return (ponteiroTopoInverso == dados.length);
    }


}
