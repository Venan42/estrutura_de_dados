package heap.maxima.src;

import java.util.NoSuchElementException;

public class ArvoreBinariaHeapMaxima<T> implements Amontoavel<T> {
    private T[] dados;
    private int ponteiroFim;

    public ArvoreBinariaHeapMaxima(int tamanho){
        dados = (T[]) new Object[tamanho];
        ponteiroFim = -1;
    }

    public ArvoreBinariaHeapMaxima(){
        this(10);
    }

    private int indicePai(int filho){
        return (filho -1)/2;
    }

    private int indiceFilhoDireito(int pai){
        return (pai * 2) +1;
    }

    private int indiceFilhoEsquerdo(int pai){
        return (pai * 2) +2;
    }

    private void ajustarAcimaRec(int indice) {
        if (indice!= 0){
            int indicePai = indicePai(indice);
            if((int)dados[indice]> (int)dados[indicePai])
                trocar(indice, indice);
            ajustarAcimaRec(indicePai);
        }
    }

    private void ajustarAcima(int indice) {
        int indiceFilho = indice;
        int indicePai;

        while(indiceFilho != 0) {
            indicePai = indicePai(indiceFilho);
            if ((int)dados[indiceFilho] > (int)dados[indicePai]) {
                trocar(indicePai, indiceFilho);
            }
            indiceFilho = indicePai;
        }
    }

    private void ajustarAbaixoRecursivo(int pai) {
        int filhoEsquerdo = indiceFilhoEsquerdo(pai);
        int filhoDireito = indiceFilhoDireito(pai);
        int maior = pai;

        //está dentro dos indices válidos do array, no intervalo [0, ponteiroFim]
        if (filhoEsquerdo <= ponteiroFim) {
            if ((int)dados[filhoEsquerdo] > (int)dados[maior]) {
                maior = filhoEsquerdo;
            }
        }

        //está dentro dos indices válidos do array, no intervalo [0, ponteiroFim]
        if (filhoDireito <= ponteiroFim) {
            if ((int)dados[filhoDireito] > (int)dados[maior]) {
                maior = filhoDireito;
            }
        }

        if (maior != pai) {
            trocar(pai, maior);
            ajustarAbaixoRecursivo(maior);
        }
    }

    @Override
    public void inserir(T dado) throws Exception {
        if(estaCheia())
            throw new Exception("Heap is full!");
        ponteiroFim++;
        dados[ponteiroFim] = dado;
        ajustarAcima(ponteiroFim);
    }

    @Override
    public T obterRaiz() {
        if (estaVazia()){
            throw new NoSuchElementException("Heap is empty!");
        }
        return dados[0];
    }

    @Override
    public T extrair() throws Exception {
        if (estaVazia()) {
            throw new Exception("Heap Vazia!");
        }
        T dadoRaiz = dados[0];
        dados[0] = dados[ponteiroFim];
        ponteiroFim--;
        ajustarAbaixoRecursivo(0);

        return dadoRaiz;
    }
    @Override
    public String imprimir() {
        StringBuilder aux = new StringBuilder("[");

        for(int i=0; i <=ponteiroFim; i++){
            aux.append(dados[i]);
            if(i !=ponteiroFim){
                aux.append(", ");
            }
        }
        return aux.toString();
    }

    @Override
    public boolean estaVazia() {
        return ponteiroFim == -1;
    }

    @Override
    public boolean estaCheia() {
        return ponteiroFim == dados.length -1;
    }

    private void trocar(int i, int j) {
        T temp = dados[i];
        dados[i] = dados[j];
        dados[j] = temp;
    }


}
