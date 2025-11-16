package ordenacao;

import java.util.Arrays;

public class Ordenacao {
    private int array[];

    public Ordenacao(int tamanho){
        array = new int[tamanho];
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            //Se tirar o -i não vai alterar o funcionamento do programa, só vai ser menos eficiente
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    troca(j, j + 1);
                }
            }
        }
    }

    public int[] merge(int[] a, int[] b) {
        int[] retorno = new int[a.length + b.length];
        Arrays.sort(a);
        Arrays.sort(b);
        int ponteiroA = 0;
        int ponteiroB = 0;
        int ponteiroRetorno = 0;
        while (ponteiroA < a.length && ponteiroB < b.length) {
            if (a[ponteiroA] < b[ponteiroB]) {
                retorno[ponteiroRetorno] = a[ponteiroA];
                ponteiroA++;
            } else {
                retorno[ponteiroRetorno] = b[ponteiroB];
                ponteiroB++;
            }
            ponteiroRetorno++;

        }
        while (ponteiroA < a.length) {
            retorno[ponteiroRetorno] = a[ponteiroA];
            ponteiroRetorno++;
            ponteiroA++;
        }
        while (ponteiroB < b.length) {
            retorno[ponteiroRetorno] = b[ponteiroB];
            ponteiroRetorno++;
            ponteiroB++;
        }

        return retorno;
    }

    public void selectionSort() {
        for (int j = 0; j < array.length; j++) {
            int menor = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[menor] > array[i])
                    menor = i;
            }
            troca(j, menor);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j + 1] < array[j]) {
                    troca(j + 1, j);
                } else {
                    break;
                }
            }
        }
    }
    public static void quickSort(int[] arranjo, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(arranjo, inicio, fim);
            quickSort(arranjo, inicio, pivoIndex - 1); // Lado esquerdo
            quickSort(arranjo, pivoIndex + 1, fim);   // Lado direito
        }
    }

    private static int particionar(int[] arranjo, int inicio, int fim) {
        int pivo = arranjo[fim]; // escolhe o último elemento como pivô
        int i = inicio - 1; // índice do menor elemento
        for (int j = inicio; j < fim; j++) {
            if (arranjo[j] <= pivo) {
                i++;
                trocar(arranjo, i, j);
            }
        }
        trocar(arranjo, i + 1, fim); // coloca o pivô na posição correta
        return i + 1; // retorna o índice do pivô
    }

    private static void trocar(int[] arranjo, int i, int j) {
        int temp = arranjo[i];
        arranjo[i] = arranjo[j];
        arranjo[j] = temp;
    }

    private void troca(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void imprimir() {
        for (int dado : array) {
            System.out.print(dado + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Ordenacao ordem = new Ordenacao(10);
        int[] dados1 = {1, 2, 6, 4, 2, 6, 8, 2};
        int[] dados2 = {7, 8, 5, 3, 7, 2, 4, 5};
        ordem.imprimir();
        ordem.insertionSort();
        ordem.imprimir();
        System.out.println(Arrays.toString(ordem.merge(dados1, dados2)));
    }


}
