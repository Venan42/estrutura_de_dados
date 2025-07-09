package abp.src;

import java.util.Objects;

public class ABP<T extends Comparable<T>> implements Arborivel<T> {
    private NodoTriplo<T> raiz;

    public ABP() {
        raiz = null;
    }

    @Override
    public void inserir(T dado) throws IllegalArgumentException {
        if (dado == null) {
            throw new IllegalArgumentException("Dado não pode ser nulo");
        }
        NodoTriplo<T> novoNodo = new NodoTriplo<>(dado);
        if (raiz == null) {
            raiz = novoNodo;
        } else {
            NodoTriplo<T> aux = raiz;
            while (true) {
                if ((Integer) dado <= (Integer) aux.getDado()) {
                    if (aux.getFilhoEsquerdo() != null) {
                        aux = aux.getFilhoEsquerdo();
                    } else {
                        novoNodo.setGenitor(aux);
                        aux.setFilhoEsquerdo(novoNodo);
                        break;
                    }

                } else {
                    if (aux.getFilhoDireito() != null) {
                        aux = aux.getFilhoDireito();
                    } else {
                        novoNodo.setGenitor(aux);
                        aux.setFilhoDireito(novoNodo);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public NodoTriplo<T> getRaiz() {
        return raiz;
    }

    @Override
    public void apagar(T dado) throws Exception {
        if (!existeRec(raiz, dado))
            throw new Exception("Dado não existe!");
        NodoTriplo<T> aux = buscar(dado);
        if (aux.getFilhoEsquerdo() == null && aux.getFilhoDireito() == null) {
            apagarNoFilho(aux);
        } else if (aux.getFilhoEsquerdo() == null && aux.getFilhoDireito() != null
                || aux.getFilhoEsquerdo() != null && aux.getFilhoDireito() == null) {
            apagarComUmFilho(aux);
        } else {
            apagarComDoisFilhos(aux);
        }
    }

    public void apagarNoFilho(NodoTriplo<T> no) {
        NodoTriplo<T> auxPai = no.getGenitor();
        if (auxPai.getFilhoEsquerdo().getDado().compareTo(no.getDado()) == 0)
            auxPai.setFilhoEsquerdo(null);
        else
            auxPai.setFilhoDireito(null);
    }

    public void apagarComUmFilho(NodoTriplo<T> no) {
        NodoTriplo<T> auxPai = no.getGenitor();
        NodoTriplo<T> auxFilho;
        if(no.getFilhoEsquerdo() != null)
            auxFilho = no.getFilhoEsquerdo();
        else
            auxFilho = no.getFilhoDireito();

        auxFilho.setGenitor(auxPai);

        if (auxPai.getFilhoEsquerdo().getDado().compareTo(no.getDado()) == 0)
            auxPai.setFilhoEsquerdo(auxFilho);
        else
            auxPai.setFilhoDireito(auxFilho);
    }

    public void apagarComDoisFilhos(NodoTriplo<T> no) {
        NodoTriplo<T> aux = no.getFilhoEsquerdo();
        NodoTriplo<T> auxPai = no;
        while (aux.getFilhoDireito() != null) {
            auxPai = aux;
            aux = aux.getFilhoDireito();
        }
        no.setDado(aux.getDado());
        if (auxPai == no) { //checagem para ver se não teve nenhuma iteração no while
            auxPai.setFilhoEsquerdo(aux.getFilhoEsquerdo());
            if (aux.getFilhoEsquerdo() != null)
                aux.getFilhoEsquerdo().setGenitor(auxPai);
        } else {
            auxPai.setFilhoDireito(aux.getFilhoEsquerdo());
            if (aux.getFilhoEsquerdo() != null)
                aux.getFilhoEsquerdo().setGenitor(auxPai);
        }
    }

    @Override
    public boolean existe(T dado) {
        if (raiz == null || dado == null)
            return false;
        NodoTriplo<T> aux = raiz;
        while (aux != null) {
            int cmp = dado.compareTo(aux.getDado());
            if (cmp == 0) return true;
            aux = (cmp < 0) ? aux.getFilhoEsquerdo() : aux.getFilhoDireito();
        }
        return false;
    }

    public boolean existeRec(NodoTriplo<T> subArvore, T dado) {
        if (subArvore == null)
            return false;
        if (Objects.equals(dado, subArvore.getDado()))
            return true;
        boolean aux = false;
        if (dado.compareTo(subArvore.getDado()) > 0) {
            if (subArvore.getFilhoDireito() != null) {
                aux = existeRec(subArvore.getFilhoDireito(), dado);
            }
        } else {
            if (subArvore.getFilhoEsquerdo() != null) {
                aux = existeRec(subArvore.getFilhoEsquerdo(), dado);
            }
        }
        return aux;
    }

    @Override
    public void limpar() {
        raiz = null;
    }

    @Override
    public NodoTriplo<T> buscar(T dado) {
        if (raiz == null || dado == null)
            return null;
        NodoTriplo<T> aux = raiz;
        while (aux != null) {
            int cmp = dado.compareTo(aux.getDado());
            if (cmp == 0) return aux;
            aux = (cmp < 0) ? aux.getFilhoEsquerdo() : aux.getFilhoDireito();
        }
        return null;
    }

    public String imprimirPreOrdem() {
        return imprimirPreOrdemRec(raiz);
    }

    private String imprimirPreOrdemRec(NodoTriplo<T> no) {
        if(no == null)
            return "";
        return no.getDado() + " " +
                imprimirPreOrdemRec(no.getFilhoEsquerdo()) + " " +
                imprimirPreOrdemRec(no.getFilhoDireito());
    }

    public String imprimirEmOrdem() {
        return imprimirEmOrdemRec(raiz);
    }

    private String imprimirEmOrdemRec(NodoTriplo<T> no) {
        if(no == null)
            return "";
        return imprimirPreOrdemRec(no.getFilhoEsquerdo()) + " " +
                no.getDado() +
                imprimirPreOrdemRec(no.getFilhoDireito());
    }

    public String imprimirPosOrdem() {
        return imprimirPosOrdemRec(raiz);
    }

    private String imprimirPosOrdemRec(NodoTriplo<T> no) {
        if(no == null)
            return "";
        return imprimirPreOrdemRec(no.getFilhoEsquerdo()) + " " +
                imprimirPreOrdemRec(no.getFilhoDireito()) + " " +
                no.getDado();
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
    //Exercício 5.
    public int nodosNaoFolha() {
        return nodosNaoFolhaRec(raiz);
    }
    private int nodosNaoFolhaRec(NodoTriplo<T> no){
        if(no == null || ehFolha(no))
            return 0;
        return 1 + nodosNaoFolhaRec(no.getFilhoEsquerdo()) + nodosNaoFolhaRec(no.getFilhoDireito());
    }

    //Exercício 10.
    public boolean arvoresIguais(ABP<T> arvore2){
        return imprimirEmOrdem().equals(arvore2.imprimirEmOrdem());
    }
}
