public class PilhaInversa implements Empilhavel {
    private int ponteiroTopo;
    private Object[] dados;

    public PilhaInversa(){
        this(10);
    }

    public PilhaInversa(int tamanho){
        this.dados = new Object[tamanho];
        ponteiroTopo = dados.length;
    }
    
    //Métodos necessários 
    @Override
    public void empilhar(Object dado){
        if(!this.estaCheia()) {
            ponteiroTopo--;
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public Object desempilhar(){
        Object aux = null;
        if(!this.estaVazia()) {
            aux = dados[ponteiroTopo];
            ponteiroTopo++;
        } else {
            System.err.println("Stack is empty");
        }

        return aux;
    }
    @Override
    public void atualizar(Object dado) {
        if(!this.estaVazia()) {
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is empty!");
        }
    }

    @Override
    public String imprimir(){
        String resultado = "[";

        if(!estaVazia()) {
            for(int i = ponteiroTopo; i < dados.length; i++) {
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
    public Object espiar(){
        Object aux = null;
        if(!this.estaVazia()) {
            aux = dados[ponteiroTopo];
        } else {
            System.err.println("Stack is empty");
        }

        return aux;
    }

    @Override
    public boolean estaCheia(){
        return (ponteiroTopo == 0);
    }

    @Override
    public boolean estaVazia(){
        return (ponteiroTopo == dados.length);
    }

}