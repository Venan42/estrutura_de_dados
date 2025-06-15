package ordenacao;

import java.util.Arrays;

public class Ordenacao {
    static int array[] = {18, 19, 5, 13, 7, 2, 14, 16, 4, 11, 7, 20, 2, 19, 7};

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
        for (int j = 1; j < array.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (array[i + 1] < array[i]) {
                    troca(i + 1, i);
                } else {
                    break;
                }
            }
        }
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
        Ordenacao ordem = new Ordenacao();
        int[] dados1 = {1, 2, 6, 4, 2, 6, 8, 2};
        int[] dados2 = {7, 8, 5, 3, 7, 2, 4, 5};
        ordem.imprimir();
        ordem.insertionSort();
        ordem.imprimir();
        System.out.println(Arrays.toString(ordem.merge(dados1, dados2)));
    }


}
