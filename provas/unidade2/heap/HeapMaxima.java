package unidade2.heap;

public class HeapMaxima<T> implements Amontoavel<T> {
    private T[] dados;
    private int ponteiroFim;

    public HeapMaxima() {
        this(10);
    }

    public HeapMaxima(int tamanho){
        dados = (T[]) new Object[tamanho];
        ponteiroFim = -1;
    }

    private int getFilhoEsquerdo(int index){
        return index * 2 + 1;
    }

    private int getFilhoDireito(int index){
        return index * 2 + 2;
    }

    private void troca(int index1, int index2){
        T temp = dados[index1];
        dados[index1] = dados[index2];
        dados[index2] = temp;
    }

    private void ajustarAcima(int index) {
        while(index != 0){
            if((int)dados[getPai(index)] < (int) dados[index])
                troca(getPai(index), index);
            index = getPai(index);
        }
    }

    private void ajustarAbaixo(int index) {
        while (true) {
            int filhoEsquerdo = getFilhoEsquerdo(index);
            int filhoDireito = getFilhoDireito(index);
            int maior = index;

            if(filhoDireito <= ponteiroFim && (int)dados[filhoDireito] > (int) dados[maior])
                maior = filhoDireito;
            if(filhoEsquerdo <=ponteiroFim && (int)dados[filhoEsquerdo] > (int) dados[maior])
                maior = filhoEsquerdo;
            if(maior == index)
                break;
            troca(index, maior);
            index = maior;
        }
    }

    private int getPai(int filho){
        return (filho - 1)/2;
    }
    @Override
    public void inserir(T dado) throws Exception {
        if(estaCheia())
            throw new Exception("Heap cheia!");
        ponteiroFim++;
        dados[ponteiroFim] = dado;
        ajustarAcima(ponteiroFim);
    }

    @Override
    public T extrair() throws Exception {
        if(estaVazia())
            throw new Exception("Heap vazia!");
        T dado = dados[0];
        dados[0] = dados[ponteiroFim];
        ponteiroFim--;
        ajustarAbaixo(0);
        return dado;
    }

    @Override
    public T obterRaiz() throws Exception{
        if(estaVazia())
            throw new Exception("Heap vazia");
        return dados[0];
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < ponteiroFim;i++){
            sb.append(dados[i]);
            if(i != ponteiroFim-1){
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    @Override
    public boolean estaVazia() {
        return ponteiroFim == -1;
    }

    @Override
    public boolean estaCheia() {
        return ponteiroFim + 1 == dados.length;
    }
}
