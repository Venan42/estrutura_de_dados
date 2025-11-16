package monitoria.unidade2.revisao;

import java.util.Arrays;
import java.util.Random;

public class Ordenacao {
    public static void bubbleSort(int[] dados) {
        for (int i = 0; i < dados.length - 1; i++) {
            for(int j = i + 1; j < dados.length; j++) {
                if(dados[j] < dados[i]) {
                    troca(dados, j, i);
                }
            }
        }
    }

    public static void selectionSort(int[] dados) {
        for (int i = 0; i < dados.length - 1; i++) {
            int menor = i;

            for(int j = i + 1; j < dados.length; j++) {
                if(dados[j] < dados[menor]) {
                    menor = j;
                }
            }

            if(menor != i) {
                troca(dados, menor, i);
            }
        }
    }

    public static void insertionSort(int[] dados) {
        for (int i = 1; i < dados.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(dados[j] > dados[j + 1]) {
                    troca(dados, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void troca(int[] dados, int i, int j) {
        int temp = dados[i];
        dados[i] = dados[j];
        dados[j] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] dados = new int[10];

        for (int i = 0; i < 10; i++) {
            dados[i] = random.nextInt(0, 100);
        }

        System.out.println(Arrays.toString(dados));

        insertionSort(dados);

        System.out.println(Arrays.toString(dados));
    }
}
