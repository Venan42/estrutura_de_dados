public class PilhaEstatica implements Empilhavel{
    public Object[] dados;
    public int ponteiroTopo;

    public PilhaEstatica(){
        this(10);
    }

    public PilhaEstatica(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroTopo = -1;
    }
    //Métodos necessários 
    @Override
    public void empilhar(Object dado){
        if(!this.estaCheia()) {
            ponteiroTopo++;
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public int tamanho() {
        return ponteiroTopo + 1;
    }

    @Override
    public Object desempilhar(){
        Object aux = null;
        if(!this.estaVazia()) {
            aux = dados[ponteiroTopo];
            ponteiroTopo--;
        } else {
            System.err.println("Stack is empty!");
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
        return (ponteiroTopo == dados.length-1);
    }

    @Override
    public boolean estaVazia(){
        return (ponteiroTopo == -1);
    }

}