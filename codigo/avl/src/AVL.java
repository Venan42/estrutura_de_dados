package avl.src;

public class AVL<T extends Comparable<T>> implements Arborivel<T> {

    private NodoTriplo<T> raiz;

    public AVL() {
        raiz = null;
    }

    /**
     * Retorna, se o nodo não for nulo, a diferença da altura da direita com a da esquerda (ou seja, é o fator de balanceamento).
     *
     * @param nodo nó a ser analisado
     * @return fator de balanceamento do nodo.
     */
    private int balanceamento(NodoTriplo<T> nodo) {
        return nodo != null
                ? altura(nodo.getFilhoDireito()) - altura(nodo.getFilhoEsquerdo())
                : 0;

    }

    private void atualizaAltura(NodoTriplo<T> nodo) {
        int maiorAltura = Math.max(altura(nodo.getFilhoEsquerdo()),
                altura(nodo.getFilhoDireito()));
        nodo.setAltura(maiorAltura + 1);
    }

    private int altura(NodoTriplo<T> no) {
        return no != null ? no.getAltura() : 0;
    }


    private NodoTriplo<T> aplicarRotacao(NodoTriplo<T> no) {
        NodoTriplo<T> novaRaiz;
        int fatorBalanceamento = balanceamento(no);
        if (fatorBalanceamento > 1) { //filhos da direita - filhos da esquerda > 1 --> precisa rotacionar para a esquerda
            if (balanceamento(no.getFilhoDireito()) < 0) {
                /* Em casos específicos, o nó direito pode ficar errado numa eventual rotação a esquerda. Ex: 6,10, 7
                 *          6
                 *           \                10
                 *            10  ---->      /  \  <- ambos os nós são menores que o 10, mas o 7 esta na posicao errada
                 *           /              6    7
                 *          7
                 *   para resolver isso, existe essa checagem prévia, para realizar
                 *   uma rotação à direita do 7 e o 10 antes. No exemplo, ficaria:
                 *
                 *          6               6
                 *           \               \               7
                 *            10  ---->       7   ---->    /   \
                 *           /                 \          6    10
                 *          7                   10
                 *
                 */
                no.setFilhoDireito(rotacaoDireita(no.getFilhoDireito()));
            }
            novaRaiz = rotacaoEsquerda(no);
        } else if (fatorBalanceamento < -1) { //filhos da direita - filhos da esquerda < 0 --> precisa rotacionar para a direita
            if (balanceamento(no.getFilhoEsquerdo()) > 1) { //exemplo parecido com o de cima, mas espelhado
                no.setFilhoEsquerdo(rotacaoEsquerda(no));
            }
            novaRaiz = rotacaoDireita(no);
        } else {
            novaRaiz = no;
        }
        return novaRaiz;
    }

    private NodoTriplo<T> rotacaoDireita(NodoTriplo<T> no) {
        /*       10                         7
         *      /  \                      /   \
         *     7    null  --------->     4    10
         *    / \                             /
         *   4   9                           9
         */
        // no exemplo, o 10 é o nó
        NodoTriplo<T> filhoEsquerdo = no.getFilhoEsquerdo(); // no exemplo, o 7
        NodoTriplo<T> filhoCentral = filhoEsquerdo.getFilhoDireito(); //no exemplo, o 9
        //não precisa de checagem para saber se o filho central é nulo, já que em nenhum momento a gente tenta acessá-lo.
        filhoEsquerdo.setFilhoDireito(filhoEsquerdo); //setando o 10 como filho direito do 7
        no.setFilhoEsquerdo(filhoCentral);//setando o 9 como filho esquerdo de 10

        atualizaAltura(no);
        atualizaAltura(filhoEsquerdo);

        return filhoEsquerdo; //retorna o nó que agora é a raiz
    }

    private NodoTriplo<T> rotacaoEsquerda(NodoTriplo<T> no) {
        /*       4                   10
         *      /  \                /   \
         *    null  10 --------->  4    11
         *          / \             \
         *         8   11            8
         */
        // no exemplo, o 4 é o nó
        NodoTriplo<T> filhoDireito = no.getFilhoDireito(); // no exemplo, o 10
        NodoTriplo<T> filhoCentral = filhoDireito.getFilhoEsquerdo(); //no exemplo, o 8
        filhoDireito.setFilhoEsquerdo(no); //setando o 4 como filho esquerdo do 10
        no.setFilhoDireito(filhoCentral); //setando o 8 como filho direito de 4

        atualizaAltura(no);
        atualizaAltura(filhoDireito);

        return filhoDireito; //retorna o nó que agora é a raiz

        //namaste :emojirezando:
    }

    @Override
    public NodoTriplo<T> getRaiz() {
        return raiz;
    }

    @Override
    public void inserir(T dado) {
        if (dado == null) {
            throw new IllegalArgumentException("Dado nao pode ser nulo!");
        }
        NodoTriplo<T> novoNodo = new NodoTriplo<>(dado);

        if (raiz == null) { //se a arvore for vazia, o novoNodo já entra direto.
            raiz = novoNodo;
        } else {
            NodoTriplo<T> aux = raiz;
            while (true) {
                if (dado.compareTo(aux.getDado()) >= 0) { //se a comparação der igual ou positiva, vá para a direita.
                    if (aux.getFilhoDireito() != null) { //checando se existe direita
                        aux = aux.getFilhoDireito();
                    } else { //se o aux não puder ir para a direita, significa que o novoNodo entra na direita de aux.
                        aux.setFilhoDireito(novoNodo);
                        novoNodo.setGenitor(aux);

                        NodoTriplo<T> atual = novoNodo.getGenitor();
                        while (atual != null) { //atualiza a altura e aplica a rodação em todos os nodos genitores do novoNodo.
                            atualizaAltura(atual);
                            aplicarRotacao(atual);
                            atual = atual.getGenitor();
                        }
                        break;
                    }
                } else {//se a comparação der negativa, vá para a esquerda.
                    if (aux.getFilhoDireito() != null) {//checando se existe esquerda.
                        aux = aux.getFilhoEsquerdo();
                    } else {//se o aux não puder ir para a direita, significa que o novoNodo entra na esquerda de aux.
                        aux.setFilhoEsquerdo(novoNodo);
                        novoNodo.setGenitor(aux);

                        NodoTriplo<T> atual = novoNodo.getGenitor();
                        while (atual != null) {//atualiza a altura e aplica a rodação em todos os nodos genitores do novoNodo.
                            atualizaAltura(atual);
                            aplicarRotacao(atual);
                            atual = atual.getGenitor();
                        }
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void apagar(T dado) throws Exception {
        NodoTriplo<T> aux = buscar(dado);
        if (aux == null)
            throw new Exception("Dado não existe!");
        if (aux.getFilhoEsquerdo() == null && aux.getFilhoDireito() == null) {
            apagarNoFolha(aux);
        } else if (aux.getFilhoEsquerdo() == null || aux.getFilhoDireito() == null) {
            apagarComUmFilho(aux);
        } else {
            apagarComDoisFilhos(aux);
        }

        NodoTriplo<T> atual = aux.getGenitor();
        while(atual != null) {
            atualizaAltura(atual);
            aplicarRotacao(atual);
            atual = atual.getGenitor();
        }

    }

    private void apagarNoFolha(NodoTriplo<T> no) {
        if(no == raiz) {
            raiz = null;
        } else {
            NodoTriplo<T> auxPai = no.getGenitor();
            if (auxPai.getFilhoEsquerdo() != null) {
                auxPai.setFilhoEsquerdo(null);
            } else {
                auxPai.setFilhoDireito(null);
            }
        }
    }

    private void apagarComUmFilho(NodoTriplo<T> no) {
        NodoTriplo<T> filho = (no.getFilhoEsquerdo() != null) ? no.getFilhoEsquerdo() : no.getFilhoDireito();

        if(no.getGenitor() == null) {
            raiz = filho;
            filho.setGenitor(null);
        } else {
            NodoTriplo<T> auxPai = no.getGenitor();
            if (auxPai.getFilhoEsquerdo() == no) {
                auxPai.setFilhoEsquerdo(filho);
            } else {
                auxPai.setFilhoDireito(filho);
            }
            filho.setGenitor(auxPai);
        }
    }

    private void apagarComDoisFilhos(NodoTriplo<T> no) {
        NodoTriplo<T> filhoCentral = no.getFilhoEsquerdo();
        //o filho central é nodo mais a direita da subárvore esquerda do nodo a ser apagado
        //isso se faz pois é o nodo mais próximo em valor do nodo apagado
        while (filhoCentral.getFilhoDireito() != null) {
            filhoCentral = filhoCentral.getFilhoDireito();
        }

        no.setDado(filhoCentral.getDado());

        if(filhoCentral.getFilhoEsquerdo() != null) {
            apagarComUmFilho(filhoCentral);
        } else {
            apagarNoFolha(filhoCentral);
        }
    }

    @Override
    public boolean existe(T dado) {
        return existeRec(raiz, dado);
    }

    public boolean existeRec(NodoTriplo<T> no, T dado){
        if(no == null) {
            return false;
        }
        if(no.getDado() == dado) {
            return true;
        }

        if(dado.compareTo(no.getDado()) >= 0) {
            return existeRec(no.getFilhoDireito(), dado);
        } else {
            return existeRec(no.getFilhoEsquerdo(), dado);
        }
    }

    @Override
    public void limpar() {
        raiz = null;
    }

    @Override
    public NodoTriplo<T> buscar(T dado) {
        return buscarRec(raiz, dado);
    }

    private NodoTriplo<T> buscarRec(NodoTriplo<T> no, T dado){
        if(no == null) {
            return null;
        }
        if(no.getDado() == dado) {
            return no;
        }

        if(dado.compareTo(no.getDado()) >= 0) {
            return buscarRec(no.getFilhoDireito(), dado);
        } else {
            return buscarRec(no.getFilhoEsquerdo(), dado);
        }
    }

    public boolean estaBalanceada() {
        int fatorBalanceamento = balanceamento(raiz);
        return fatorBalanceamento == -1
                || fatorBalanceamento == 0
                || fatorBalanceamento == 1;
    }

    public boolean estaVazia() {
        return raiz == null;
    }


    public String imprimirPreOrdem() {
        return imprimirPreOrdemRec(raiz).trim();
    }

    private String imprimirPreOrdemRec(NodoTriplo<T> no) {
        if(no == null)
            return "";
        return no.getDado() + " " +
                imprimirPreOrdemRec(no.getFilhoEsquerdo()) +
                imprimirPreOrdemRec(no.getFilhoDireito());
    }

    public String imprimirEmOrdem() {
        return imprimirEmOrdemRec(raiz).trim();
    }

    private String imprimirEmOrdemRec(NodoTriplo<T> no) {
        if(no == null)
            return "";
        return imprimirEmOrdemRec(no.getFilhoEsquerdo()) +
                no.getDado() + " " +
                imprimirEmOrdemRec(no.getFilhoDireito());
    }

    public String imprimirPosOrdem() {
        return imprimirPosOrdemRec(raiz).trim();
    }

    private String imprimirPosOrdemRec(NodoTriplo<T> no) {
        if(no == null)
            return "";
        return imprimirPosOrdemRec(no.getFilhoEsquerdo()) +
                imprimirPosOrdemRec(no.getFilhoDireito()) +
                no.getDado() + " ";
    }

    public int contarPreOrdem() {
        return contarPreOrdemRec(raiz);
    }
    private int contarPreOrdemRec(NodoTriplo<T> no) {
        if(no == null)
            return 0;
        return 1 +
                contarPreOrdemRec(no.getFilhoEsquerdo()) +
                contarPreOrdemRec(no.getFilhoDireito());
    }

    public int somarPreOrdem() {
        return somarPreOrdemRec(raiz);
    }

    private int somarPreOrdemRec(NodoTriplo<T> no) {
        if(no == null)
            return 0;
        return (Integer) no.getDado() +
                somarPreOrdemRec(no.getFilhoEsquerdo()) +
                somarPreOrdemRec(no.getFilhoDireito());
    }

    private boolean ehFolha(NodoTriplo<T> no) {
        return (no.getFilhoEsquerdo() == null) && (no.getFilhoDireito() == null);
    }

    public int contarFolhasPreOrdem() {
        return contarFolhasPreOrdemRec(raiz);
    }

    private int contarFolhasPreOrdemRec(NodoTriplo<T> no) {
        if(no == null)
            return 0;
        if(ehFolha(no))
            return 1;
        return contarFolhasPreOrdemRec(no.getFilhoEsquerdo()) +
                contarFolhasPreOrdemRec(no.getFilhoDireito());
    }
}
