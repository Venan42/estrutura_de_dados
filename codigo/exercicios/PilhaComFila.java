public class PilhaComFila implements Empilhavel{
    private Enfileiravel f1;
    private Enfileiravel f2;

    public PilhaComFila(){
        this(10);
    }

    public PilhaComFila(int numero){
        this.f1 = new FilaEstaticaCircular(numero);
        this.f2 = new FilaEstaticaCircular(numero);
    }

    private boolean transferir(Enfileiravel origem, Enfileiravel destino) {
        while (!origem.estaVazia()) {
            if (destino.estaCheia()) {
                System.err.println("Erro ao transferir: fila cheia.");
                return false;
            }
            destino.enfileirar(origem.desenfileirar());
        }
        return true;
    }

    @Override
    public int tamanho() {
        return f1.tamanho();
    }

    @Override
    public void empilhar(Object dado) {
        if (!estaCheia()) {
            if (!transferir(f1, f2)) return;

            if (!f2.estaCheia()) {
                f2.enfileirar(dado);
            } else {
                System.err.println("Stack is full (ao enfileirar novo elemento)!");
                return;
            }

            if (!transferir(f2, f1)) return;
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public Object desempilhar(){
        Object aux = null;
        if (!estaVazia()) {
            while (f1.tamanho() > 1) {
                transferir(f1, f2);
            }
            aux = f1.desenfileirar(); // este é o último elemento inserido (topo da pilha)
            // agora inverte de volta
            while (!f2.estaVazia()) {
                transferir(f2, f1);
            }
        } else {
            System.err.println("Stack is empty!");
        }

        return aux;
    }

    @Override
    public void atualizar(Object dado){
        if(!estaVazia()){
            while(!f1.estaVazia()){
                f2.enfileirar(f1.desenfileirar());
            } 
            f2.atualizarFim(dado);
            while(!f2.estaVazia()){
                f1.enfileirar(f2.desenfileirar());
            } 
        } else{
            System.err.println("Stack is empty!");
        }
    }
    @Override
    public String imprimir(){
        return f1.imprimir();
    }

    @Override
    public Object espiar(){
        Object aux = null;
        if(!estaVazia()){
            while(!f1.estaVazia()){
                f2.enfileirar(f1.desenfileirar());
                System.out.println(f2.imprimir());
            } 
            aux = f2.frente();
            while(!f2.estaVazia()){
                f1.enfileirar(f2.desenfileirar());
            } 
        } else{
            System.err.println("Stack is empty!");
        }

        return aux;
    }
    @Override
    public boolean estaCheia(){
        return f1.estaCheia();
    }
    @Override
    public boolean estaVazia(){
        return f1.estaVazia();
    }

    public static void main(String[] args) {
        Empilhavel p1 = new PilhaComFila();

        p1.empilhar("O");
        p1.empilhar("Astronauta");
        p1.empilhar("de");
        p1.empilhar("Mármore");
        p1.empilhar("Azul");

        p1.desempilhar();

        System.out.println(p1.imprimir());

    }

}
