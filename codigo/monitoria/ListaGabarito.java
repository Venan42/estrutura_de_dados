package monitoria;

public class ListaGabarito {
    /**
     * Questão 1 - Implemente o método Java Lista intercala(Lista listaA,
     * Lista listaB) que recebe duas Listas Estáticas de Inteiros (pré‑ordenadas em
     * ordem crescente) e retorne uma nova lista também ordenada, resultante da fusão
     * de listaA e listaB, sem ordenação adicional. O algoritmo deve percorrer cada
     * elemento de listaA e de listaB apenas uma vez.
     */
    public static Lista intercala(Lista listaA, Lista listaB) {
        //1,4,5
        //2,4
        //1,2,3,4,5
        int countA = 0, countB = 0;
        Lista aux = new Lista();

        while(countA < listaA.size() && countB < listaB.size()) {
            if(listaA.get(countA) > listaB.get(countB)) {
                aux.add(listaB.get(countB));
                countB++;
            } else {
                aux.add(listaA.get(countA));
                countA++;
            }
        }

        while(countA < listaA.size()) {
            aux.add(listaA.get(countA));
            countA++;
        }

        while(countB < listaB.size()) {
            aux.add(listaB.get(countB));
            countB++;
        }

        return aux;
    }

    /**
     * Questão 2. (2023 FADE-UFPE) Considere a implementação de uma fila (FIFO) de
     * forma estática (array) com indexação circular, iniciando em 0 e finalizando no índice
     * N-1, onde N é o tamanho do array. Seja Ins o índice da posição livre na qual a
     * próxima inserção na fila deve ocorrer; seja Prim o índice do elemento mais antigo a
     * permanecer na fila; e seja (A MOD B) o resto da divisão inteira de A por B. Com
     * base nesses dados, analise as afirmações a seguir.
     * a) Para inserção, caso a fila não esteja cheia, atribuímos o elemento ao array na
     * posição Ins e, em seguida, atribuímos a Ins o valor de (Ins MOD N)+1.
     * b) Para deleção, caso a fila não esteja vazia, atribuímos a Prim o valor de ((Prim+1)
     * MOD N).
     * c) Se Prim=Ins, podemos concluir que a fila está vazia.
     * d) Se Prim=((Ins+1) MOD N), podemos concluir que a fila está cheia. Quais as
     * afirmativas estão corretas? Justifique sua resposta.
     */
    //INS -> POSICAO LIVRE ONDE O PROXIMO DADO VAI ENTRAR
    //Prim -> PRIMEIRO DA FILA
    //N -> tamanho do array
    //MOD -> %

    //A)  Incorreta. A expressão correta seria: Ins = (Ins + 1) % N; A forma (Ins MOD N)+1
    //    pode fazer Ins ultrapassar o limite superior do array se Ins já for N-1. Por exemplo,
    //    (5 MOD 6) + 1 = 6, o que está fora do intervalo válido 0..5;
    //B)  Correta. Para deleção, caso a fila não esteja vazia, atribuímos a Prim o valor de
    //    ((Prim+1) MOD N), pois, após remover o elemento da posição Prim, devemos avançar o
    //    índice Prim para a próxima posição, usando a indexação circular: Prim = (Prim + 1) % N;
    //C)  Incorreta. Mesmo que Prim=Ins realmente indique corretamente quando a fila está vazia,
    //    podemos concluir errôneamente que que a  fila está vazia, quando na verdade ela estiver
    //    cheia, porque as condições são equivalentes. Exatamente por este motivo, que nas estruturas
    //    de dados circulares não usamos os ponteiros para isEmpty e isFull, e sim a quantidade de elementos;
    //D)  Incorreta. Prim = ((Ins + 1) MOD N) não indica quando a fila está cheia,  pois quando a fila
    //    está cheia Prim=Ins. Por curiosidade, Prim = ((Ins + 1) MOD N) indicaria quando faltasse apenas
    //    uma posição livre antes que a fila se tornasse cheia.

    /**
     * Questao 3 - Implemente um método em Java boolean parentesisCheck(String input)
     * que utilize uma Pilha Estática para verificar se uma expressão contendo parênteses (),
     * colchetes [] e chaves {} está bem formada. Por exemplo, a expressão "([{}])" é válida,
     * mas "{[(])}" não é.
     */
    public boolean parentesisCheck(String input) {
        Pilha aux = new Pilha();
        char[] c = input.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(c[i] == '{' || c[i] == '[' || c[i] == '(') {
                aux.push(c[i]);
            } else if(c[i] == '}' || c[i] == ']' || c[i] == ')') { //(
                if(aux.isEmpty()) {
                    return false;
                }
                char head = aux.pop();

                if(c[i] == ')' && head != '(') {
                    return false;
                }

                if(c[i] == ']' && head != '[') {
                    return false;
                }

                if(c[i] == '}' && head != '{') {
                    return false;
                }
            }
        }

        return aux.isEmpty();
    }

    /**
     * Questão 4. Dada uma Max-heap, diga o resultado final da ordenação dos dados no
     * array com os seguintes inputs: 9, 4, 12, 4, 10, 1, 8, 3, 6, 5.
     */
    //R: 12, 10, 9, 6, 5, 1, 8, 3, 4, 4

    /**
     * Questão 5. Considere uma implementação de fila estática circular com capacidade
     * para 6 elementos. Partindo de uma fila vazia, descreva o estado do array (incluindo
     * os ponteiros de início e fim) após a seguinte sequência de operações: enfileirar(A),
     * enfileirar(B), desenfileirar(), enfileirar(C), enfileirar(D), enfileirar(E), desenfileirar(),
     * enfileirar(F), enfileirar(G), enfileirar(H). Mostre como os dados estarão ordenados no array.
     */
    /*
     * ponteiroInicio = C
     * ponteiroFim = G
     * R: A, B, C, D, E, F, G
     */

    /**
     * Questão 6. Utilizando um Heap Mínimo (Min Heap) estático como base, implemente
     * os métodos void insert(int elemento) e int remove() para uma Fila de Prioridade.
     * Explique como as operações de inserção e remoção no heap garantem que o
     * elemento de maior prioridade (o menor valor) seja sempre o primeiro a ser
     * removido.
     */
    public void insert(int element) {
        if(!isFull()) {
            data[tail] = element;
            int currentIndex = tail;
            while(currentIndex > 0) {
                int parentIndex = (currentIndex - 1)/2;
                if(data[currentIndex] < data[parentIndex]) {
                    int temp = data[currentIndex];
                    data[currentIndex] = data[parentIndex];
                    data[parentIndex] = temp;
                } else {
                    break;
                }
            }
        } else {
            System.err.println("Heap is full!");
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.err.println("Heap is empty!");
            return -1;
        }

        int removedElement = data[0];
        tail--;
        data[0] = data[tail];

        int currentIndex = 0;
        while (true) {
            int leftChild = (currentIndex * 2) + 1;
            int rightChild = (currentIndex * 2) + 2;
            int smallestChild = currentIndex;

            if (leftChild < tail && data[leftChild] < data[smallestChild]) { // <- MUDANÇA no limite
                smallestChild = leftChild;
            }

            if (rightChild < tail && data[rightChild] < data[smallestChild]) { // <- MUDANÇA no limite
                smallestChild = rightChild;
            }

            if (smallestChild == currentIndex) {
                break;
            }

            int temp = data[currentIndex];
            data[currentIndex] = data[smallestChild];
            data[smallestChild] = temp;
            currentIndex = smallestChild;
        }

        return removedElement;
    }

    /**
     * Questão 7. Implemente, em uma Fila Estática, o método inserir e remover utilizando
     * 2 Pilhas Estáticas.
     */
    public void inserir(Object dado) {
        if(!pilha1.isFull()) {
            pilha1.inserir(dado);
        } else {
            System.err.println("Queue is full!");
        }
    }

    public Object remover() {
        Object aux = null;
        if(!pilha1.isEmpty()) {
            while(!pilha1.isEmpty()) {
                pilha2.push(pilha1.pop());
            }
            aux = pilha2.pop();
            while(!pilha2.isEmpty) {
                pilha1.push(pilha2.pop());
            }
        } else {
            System.err.println("Queue is empty!");
        }

        return aux;
    }

    /**
     * Questão 8. Considerando uma classe que implementa uma Lista Estática de
     * inteiros, crie um método void removerOcorrencias(Object elemento) que remove todas
     * as instâncias de um determinado elemento. Por exemplo, para a lista [10, 20, 50,
     * 20, 40], a chamada removerOcorrencias(20) deve resultar na lista [10, 50, 40].
     */
    public void removerOcorrencias(Object dado) {
        if(!isEmpty) {
            for (int i = 0; i < tamanho; i++) {
                if(data[i] == dado) {
                    remove(i);
                    i--;
                }
            }
        } else {
            System.err.println("Stack is empty!");
        }
    }
}
