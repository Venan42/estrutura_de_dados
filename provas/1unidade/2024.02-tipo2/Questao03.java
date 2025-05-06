public class Questao03 {
    private Object dados[];
    private int ponteiroFim;
    private int ponteiroInicio;
    private int quantidade;

    public Questao03() {
        this(10);
    }

    public Questao03(int tamanho){
        this.dados = new Object[tamanho];
        this.ponteiroFim = -1;
        this.ponteiroInicio = 0;
        this.quantidade = 0;
    }

    private int avancar(int index) {
        return (index + 1) % dados.length;
    }

    private int retroceder(int index){
        return ((index - 1) + dados.length) % dados.length;
    }

    private int mapeamento(int logica){
        return (logica+ponteiroInicio) % dados.length;
    }

    public boolean estaCheia(){
        return quantidade == dados.length;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    public void anexar(Object dado){
        if(!estaCheia()){
            quantidade++;
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
        } else {
            System.out.println("List is full!");
        }
    }

    public Object apagar(int posicaoLogica) {
        Object aux = null;
        if(!estaVazia()){
            if(posicaoLogica <= quantidade && posicaoLogica >= 0){
                int posicaoFisica = mapeamento(posicaoLogica);
                aux = dados[posicaoFisica];
                int auxPosicao = posicaoFisica;
                for(int i = posicaoLogica; i >= 0; i--){
                    dados[auxPosicao] = dados[retroceder(auxPosicao)];
                    auxPosicao--;
                }
                ponteiroInicio = avancar(ponteiroInicio);
                quantidade--;
            } else{
                System.out.println("Invalid index!");
            }
        } else {
            System.out.println("List is empty!");
        }
        return aux;
    }

    public String imprimir(int index){
        String string = "[";
        if(index >= 0 && index <= quantidade) {
            for(int i = 0; i <= index; i++) {
                if(i == index){
                    string += dados[mapeamento(i)];
                } else {
                    string += dados[mapeamento(i)] + ", ";
                }
            }
        }
        return string + "]";
    }

    public static void main(String[] args) {
        Questao03 lista = new Questao03();
        for(int i = 0; i < 10; i++){
            lista.anexar(i);
        }

        System.out.println(lista.imprimir(8));

        lista.apagar(2);

        System.out.println(lista.imprimir(2));
    }

}
