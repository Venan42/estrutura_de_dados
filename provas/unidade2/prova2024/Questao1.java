package unidade2.prova2024;

import java.util.Scanner;

public class Questao1<T> implements Listavel<T> {
    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private final int tamanho;

    public Questao1(){
        this(10);
    }
    public Questao1(int tamanho) {
        quantidade = 0;
        this.tamanho = tamanho;
    }

    @Override
    public T selecionar(int index) throws Exception{
        if(estaVazia())
            throw new Exception("Lista vazia!");
        if(index >= quantidade && index < 0){
            throw new Exception("Índice inválido!");
        }
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < index; i++) {
            ponteiroAux = ponteiroAux.getPonteiroProximo();
        }
        return ponteiroAux.getDado();
    }

    @Override
    public void inserir(int index, T dado) throws Exception{
        if(estaCheia())
            throw new Exception("Lista cheia!");
        if(index > quantidade || index < 0){
            throw new Exception("Índice inválido!");
        }
        NodoDuplo<T> novoNodo = new NodoDuplo<>(dado);
        NodoDuplo<T> nodoAnterior = null;
        NodoDuplo<T> nodoProximo = ponteiroInicio;

        for (int i = 0; i < index; i++) {
            nodoAnterior = nodoProximo;
            nodoProximo = nodoProximo.getPonteiroProximo();
        }
        novoNodo.setPonteiroAnterior(nodoAnterior);
        novoNodo.setPonteiroProximo(nodoProximo);

        if(nodoAnterior != null)
            nodoAnterior.setPonteiroProximo(novoNodo);
        else
            ponteiroInicio = novoNodo;

        if(nodoProximo != null)
            nodoProximo.setPonteiroAnterior(novoNodo);
        else
            ponteiroFim = novoNodo;

        quantidade++;
    }

    @Override
    public void anexar(T dado) throws Exception {
        if(estaCheia())
            throw new Exception("Lista cheia!");
        NodoDuplo<T> novoNodo = new NodoDuplo<>(dado);
        novoNodo.setPonteiroAnterior(ponteiroFim);
        if(estaVazia()) {
            ponteiroInicio = novoNodo;
        } else {
            ponteiroFim.setPonteiroProximo(novoNodo);
        }
        ponteiroFim = novoNodo;
        quantidade++;
    }

    @Override
    public T apagar(int index) throws Exception{
        if(estaVazia())
            throw new Exception("Lista vazia!");
        if(index > quantidade || index < 0){
            throw new Exception("Índice inválido!");
        }
        T dado = selecionar(index);
        NodoDuplo<T> nodoAnterior = null;
        NodoDuplo<T> nodoProximo = ponteiroInicio;
        for (int i = 0; i < index; i++){
            nodoAnterior = nodoProximo;
            nodoProximo = nodoProximo.getPonteiroProximo();
        }
        nodoProximo = nodoProximo.getPonteiroProximo();

        if(nodoAnterior != null)
            nodoAnterior.setPonteiroProximo(nodoProximo);
        else
            ponteiroInicio = ponteiroInicio.getPonteiroProximo();
        if(nodoProximo != null)
            nodoProximo.setPonteiroAnterior(nodoAnterior);
        else
            ponteiroFim = nodoProximo;
        quantidade--;
        return dado;
    }


    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimirPosicao(int index) throws Exception{
        if(index >= quantidade && index < 0){
            throw new Exception("Índice inválido!");
        }
        StringBuilder sb = new StringBuilder("[");
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < index; i++) {
            sb.append(ponteiroAux);
            if (i != index-1)
                sb.append(", ");
            ponteiroAux = ponteiroAux.getPonteiroProximo();
        }
        return sb.append("]").toString();
    }

    public int[] occurrences(T dado){
        int[] resp = new int[quantidade];
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            if(ponteiroAux.getDado() == dado){
                resp[i] = i;
            }
        }
        return resp;
    }
    public int getQuantidade(){
        return quantidade;
    }

    public static void main(String[] args) {
        try {
            Questao1<Integer> lista = new Questao1<>(10); // capacidade 10

            // Inserindo alguns elementos
            lista.inserir(0, 10);
            lista.inserir(1, 20);
            lista.inserir(2, 30);
            lista.inserir(3, 40);
            lista.anexar(50);
            lista.anexar(60);
            lista.anexar(70);

            System.out.println("Antes de apagar:");
            for (int i = 0; i < lista.getQuantidade(); i++) {
                System.out.print(lista.selecionar(i) + " ");
            }

            // Apagando o elemento na posição 2 (valor 30)
            Integer removido = lista.apagar(2);
            System.out.println("\nElemento removido: " + removido);

            System.out.println("Depois de apagar:");
            for (int i = 0; i < lista.getQuantidade(); i++) {
                System.out.print(lista.selecionar(i) + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
