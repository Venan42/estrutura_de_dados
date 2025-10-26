package monitoria.unidade2;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random =  new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));

        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int count = i-1;
            while(count >= 0 && array[count] > currentValue) {
                array[count+1] = array[count];
                count--;
            }
            array[count + 1] = currentValue;
        }
    }
}
