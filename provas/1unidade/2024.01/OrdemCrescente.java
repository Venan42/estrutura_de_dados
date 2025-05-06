public class OrdemCrescente {
    private int dados[];
    private int quantidade;
    private int ponteiroFim;
    private int ponteiroInicio;

    public OrdemCrescente() {
        this(10);
    }

    public OrdemCrescente(int tamanho) {
        this.dados = new int[tamanho];
        this.quantidade = 0;
        this.ponteiroFim = -1;
        this.ponteiroInicio = 0;
    }

    public boolean estaCheia(){
        return quantidade == dados.length;
    }

    public boolean estaVazia(){
        return quantidade == 0;
    }

    public int mapeamento(int posicao){
        return (posicao + ponteiroInicio)%dados.length;
    }

    public int avancar(int posicao){
        return (posicao +1)%dados.length;
    }

    public void troca(int i, int j){
        int temp = dados[i];
        dados[i] = dados[j];
        dados[j] = temp;
    }

    public String imprimir(){
        String string = "[";
        for(int i = 0; i < quantidade; i++) {
            if(i == quantidade - 1){
                string += dados[mapeamento(i)];
            } else {
                string += dados[mapeamento(i)] + ", ";
            }
        }
        return string + "]";
    }
    //Questao02
    public void bubbleSortCrescente(){
        for(int i = 0; i < dados.length-1; i++){
            for(int j = i + 1; j < dados.length; j++){
                if(dados[i] > dados[j])
                    troca(i, j);
            }
        }
    }
    //Questão 03
    public void bubbleSortDecrescente(){
        for(int i = 0; i < dados.length-1; i++){
            for(int j = i + 1; j < dados.length; j++){
                if(dados[i] < dados[j])
                    troca(i, j);
            }
        }
    }

    public void insertionSortCrescente(){
        for(int j = 1; j < dados.length; j++) {
            for(int i = j-1; i >= 0; i--) {  
                if(dados[i+1]<dados[i]) {
                    troca(i+1, i);
                } else  { 
                    break;
                }
            }
        }
    }
    public void insertionSortDecrescente(){
        int j, aux;
        for(int i = 1; i < dados.length; i++){
            aux = dados[i];
            j = i -1;
            while(j >= 0 && dados[j] < aux){
                dados[j+1] = dados[j];
                j--;
            }
            dados[j+1] = aux;
        }
    }



    public void anexar(int dado){
        if(!estaCheia()){
            quantidade++;
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
        }
    }

    public static void main(String[] args) {
        OrdemCrescente listaBubble = new OrdemCrescente(10);       
        for(int i = 0; i < 10; i++){
            listaBubble.anexar((int) (Math.random()*21));
        }

        System.out.println("dados(bubble sort): "+ listaBubble.imprimir());

        listaBubble.bubbleSortCrescente();

        System.out.println("dados em ordem crescente: " + listaBubble.imprimir());

        listaBubble.bubbleSortDecrescente();
        System.out.println("dados em ordem decrescente: " + listaBubble.imprimir());

        OrdemCrescente listaInsertion = new OrdemCrescente(10);    
        
        for(int i = 0; i < 10; i++){
            listaInsertion.anexar((int) (Math.random()*21));
        }


        System.out.println("dados(insertion sort): "+ listaInsertion.imprimir());

        listaInsertion.insertionSortCrescente();

        System.out.println("dados em ordem crescente: " + listaInsertion.imprimir());

        listaInsertion.insertionSortDecrescente();
        System.out.println("dados em ordem decrescente: " + listaInsertion.imprimir());

    }

}
