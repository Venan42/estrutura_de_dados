package abp.src;

import java.util.Objects;

public class ABP<T extends Comparable<T>> implements Arborivel<T> {
    private NodoTriplo<T> raiz;

    public ABP() {
        raiz = null;
    }

    @Override
    public void inserir(T dado) {
        NodoTriplo<T> novoNodo = new NodoTriplo<>(dado);
        if (dado == null) {
            throw new IllegalArgumentException("Dado não pode ser nulo");
        }
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
}
