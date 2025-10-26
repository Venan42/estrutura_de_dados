package monitoria.unidade2;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random =  new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));

        selectionSort(array);

        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for(int i = 0; i < array.length-1; i++) {
            int menor = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[menor]) {
                    menor = j;
                }
            }
            if(menor != i) {
                int temp = array[i];
                array[i] = array[menor];
                array[menor] = temp;
            }
        }
    }

}
