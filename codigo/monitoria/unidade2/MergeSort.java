package monitoria.unidade2;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {2,5,4,7,8,3,1,6,9};
        int[] arrayAux = new int[array.length];
        mergeSort(array, arrayAux, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int[] aux, int ini, int fim) {
        if(ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSort(array, aux, ini, meio);
            mergeSort(array, aux, meio+1, fim);
            intercala(array, aux, ini, meio, fim);
        }
    }

    private static void intercala(int[] array, int[] aux, int ini, int meio, int fim) {
        for (int i = ini; i <= fim; i++) {
            aux[i] = array[i];
        }

        int inicio1 = ini;
        int inicio2 = meio + 1;

        for(int i = ini; i <= fim; i++) {
            if(inicio1 > meio) array[i] = aux[inicio2++];
            else if(inicio2 > fim) array[i] = aux[inicio1++];
            else if(aux[inicio1] < aux[inicio2]) array[i] = aux[inicio1++];
            else array[i] = aux[inicio2++];
        }
    }
}
