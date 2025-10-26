package monitoria.unidade1.prova;

import java.util.ArrayDeque;

public class Binario {
    /**
     * 2. Implemente em Java um método “String decToBin(String data)” que retorne a
     * representação Binária de números Decimais, utilizando a estrutura de dados do tipo Pilha
     * Estática. Considere que todos os métodos da pilha estática estejam disponíveis para uso.
     */
    public static String decToBin(String data) {
        int num = Integer.parseInt(data);
        ArrayDeque<Integer> pilha = new ArrayDeque<>();
        while(num > 0) {
            pilha.push(num % 2); //impar(1) par(0)
            num = num / 2;
        }

        String aux = "";
        while(!pilha.isEmpty()) {
            aux += pilha.pop();
        }

        return aux;
    }

    public static void main(String[] args) {
        System.out.println(decToBin("10"));
        System.out.println(decToBin("255"));
        System.out.println(decToBin("35"));
    }
}
