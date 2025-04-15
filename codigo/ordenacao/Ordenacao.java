package ordenacao;
public class Ordenacao {
    static int array[] = {18, 19, 5, 13, 7, 2, 14, 16, 4, 11, 7, 20, 2, 19, 7};

    public void bubbleSort() {
        for(int i = 0; i < array.length-1; i++){
            //Se tirar o -i não vai alterar o funcionamento do programa, só vai ser menos eficiente
            for(int j = 0; j < array.length-i-1; j++){
                if(array[j]>array[j+1]){
                    troca(j, j+1);
                }
            }
        }
    }

    public void selectionSort() {
        for(int j = 0; j < array.length; j++){
            int menor = j;
            for(int i = j+1; i < array.length; i++) { 
                if(array[menor]>array[i])
                    menor = i;
            }
            troca(j, menor);
        }
    }

    public void insertionSort(){
        for(int j = 1; j < array.length; j++) {
            for(int i = j-1; i >= 0; i--) {  
                if(array[i+1]<array[i]) {
                    troca(i+1, i);
                } else  { 
                    break;
                }
            }
        }
    }

    private void troca(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void imprimir(){
        for(int dado: array){
            System.out.print(dado + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Ordenacao ordem = new Ordenacao();

        ordem.imprimir();
        ordem.insertionSort();
        ordem.imprimir();
    }

    
}
