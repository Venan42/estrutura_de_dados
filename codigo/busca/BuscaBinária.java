package busca;

import java.util.Scanner;

public class BuscaBinária {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[100];

        for(int i = 0; i < 100; i++){
            numeros[i] = i*2;
        }

        System.out.println("Qual número você quer procurar?");
        int buscado = scanner.nextInt();

        int inicio = 0, fim = numeros.length - 1, meio, index = -1;
        int contador = 0;

        while(inicio <= fim){
            contador++;
            meio = (int) ((inicio + fim)/2);
            if(numeros[meio] == buscado){
                index = meio;
                break;
            } else if(buscado > numeros[meio]){
                inicio = meio + 1;
            } else {
                fim    = meio - 1; 
            }
        }

        System.out.println("O numero buscado está na posição: " + index);
        System.out.println("O numero foi encontrado em " + contador + " passos.");

        
    }
}
