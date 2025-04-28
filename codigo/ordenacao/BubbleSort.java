package ordenacao;

public class BubbleSort {
    public static void main(String[] args) {
        final int QTD = 15;
        int[] array = new int[QTD];

        for(int i = 0; i < QTD; i++){
            array[i] = (int) (Math.random()*20 + 1);
        }

        String retorno = "[";
        for (int i = 0; i < QTD; i++) {
            if (i == QTD - 1) {
                retorno += array[i];
            } else {
                retorno += array[i] + ", ";
            }
        }
        retorno += "]";

        System.out.println(retorno);

        int temp;
        for(int i = 0; i < QTD - 1; i++){
            for(int j = i + 1; j < QTD; j++){
                if(array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        String retornoOrdem = "[";
        for (int i = 0; i < QTD; i++) {
            if (i == QTD - 1) {
                retornoOrdem += array[i];
            } else {
                retornoOrdem += array[i] + ", ";
            }
        }
        retornoOrdem += "]";

        System.out.println(retornoOrdem);

    }
}
