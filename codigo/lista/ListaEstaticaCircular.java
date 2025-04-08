package lista;

public class ListaEstaticaCircular implements Listavel {

    private Object[] dados;
    private int ponteiroInicio;
    private int ponteiroFim;
    private int quantidade;

    public ListaEstaticaCircular() {
        this(10);
    }
    
    public ListaEstaticaCircular(int tamanho) {
        dados = new Object[tamanho];
        ponteiroInicio = 0;
        ponteiroFim = -1;
        quantidade = 0;
    }
    private int avancar(int aux) {
        return (aux + 1) % dados.length;
    }

    private int retroceder(int aux) {
        return (aux - 1 + dados.length) % dados.length;
    }

    private int mapeamento(int logica) {
        return (logica + ponteiroInicio) % dados.length;
    }
    @Override
    public void atualizar(Object dado, int index) {
        if (!estaVazia()) {
            if (index >= 0 && index < quantidade) {
                int posicaoFisica = mapeamento(index);
                dados[posicaoFisica] = dado;
            } else{
                System.err.println("Indix invalid!");
            }
        } else {
            System.err.println("List is empty!");
        }
    }

    @Override
    public boolean estaCheia() {
        return quantidade == dados.length;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimir() {
        String retorno = "[";
        for (int i = ponteiroInicio; i < quantidade + ponteiroInicio; i++) {

            // if (i == dados.length)
            // i = 0;
            if (i == quantidade + ponteiroInicio - 1) {
                retorno += dados[i % dados.length];
            } else {
                retorno += dados[i] + ", ";
            }
        }
        return retorno + "]";
    }

    @Override
    public void anexar(Object dado){
        if(!estaCheia()){
            quantidade++;
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
        }else{
            System.err.println("List is Full!");
        }
        
    }

    @Override
    public Object selecionar(int posicao){
        Object dadoSelect = null;
        if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade){
                int posicaoFisica = mapeamento(posicao);
                dadoSelect = dados[posicaoFisica];
            } else{
                System.err.println("Index is invalid!");
            }
        } else {
            System.err.println("List is empty!");
        }

        return dadoSelect;
    }

    @Override
    public void inserir(Object dado, int posicaoLogica){
        if(!estaCheia()){
            if(posicaoLogica >= 0 && posicaoLogica < quantidade){
                int posicaoFisica = mapeamento(posicaoLogica);

                if(posicaoLogica >= quantidade/2){
                    int auxQtde = mapeamento(quantidade);
                    for(int i = posicaoLogica; i < quantidade; i++){
                        dados[avancar(auxQtde)] = dados[auxQtde];
                        auxQtde--;
                    }
                    ponteiroFim = avancar(ponteiroFim);
                } else {
                    int ponteiroAux = ponteiroInicio;
                    for(int i = posicaoLogica; i >= 0; i--){
                        dados[retroceder(ponteiroAux)] = dados[ponteiroAux];
                        ponteiroAux++;
                    }
                    ponteiroInicio = retroceder(ponteiroInicio);
                }
                quantidade++;
                dados[posicaoFisica] = dado;
            } else {
                System.err.println("Index is invalid!");
            }
        }else{
            System.err.println("List is Full!");
        }
    }

    @Override
    public Object apagar(int posicaoLogica){
        Object aux = null;
        if(!estaVazia()){
            if(posicaoLogica >= 0 && posicaoLogica < quantidade){
                int posicaoFisica = mapeamento(posicaoLogica);
                aux = dados[posicaoFisica];
                int x = posicaoFisica;
                if(posicaoLogica >= quantidade/2){
                    for(int i = 0; i < quantidade - posicaoLogica - 1; i++){
                        dados[x] = dados[avancar(x)];
                        x++;
                    }
                    ponteiroFim = retroceder(ponteiroFim);
                } else {
                    for(int i = posicaoLogica; i >= 0; i--){
                        dados[x] = dados[retroceder(x)];
                        x--;
                    }
                    ponteiroInicio = avancar(ponteiroInicio);
                }
                quantidade--;
                retroceder(ponteiroFim);
            } else {
                System.err.println("Index is invalid!");
            }
        }else{
            System.err.println("List is empty!");
        }
        return aux;
    }

    @Override
    public void limpar(){
        quantidade = 0;
        ponteiroFim = -1;
        ponteiroInicio = 0;
    }

    @Override
    public Object[] selecionarTodos(){
        Object[] aux = null;

        if(!estaVazia()){
            aux = new String[quantidade];
            for(int i = 0; i < quantidade; i++){
                aux[i] = dados[mapeamento(i)];
            }
        } else {
            System.err.println("List is empty!");
        }

        return aux;
    }

}