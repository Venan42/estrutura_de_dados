package abp;

import java.util.Objects;

public class ABP<T> implements Arborivel<T> {
    NodoTriplo<T> raiz;

    public ABP(){
        raiz = null;
    }

    @Override
    public void inserir(T dado) {
        NodoTriplo<T> novoNodo = new NodoTriplo<>();
        novoNodo.setDado(dado);

        NodoTriplo<T> aux = raiz;
        while(true){
            if((Integer) dado <= (Integer) aux.getDado()){
                if(aux.getFilhoEsquerdo() != null){
                    aux = aux.getFilhoEsquerdo();
                } else {
                    novoNodo.setGenitor(aux);
                    aux.setFilhoEsquerdo(novoNodo);
                    break;
                }

            } else {
                if(aux.getFilhoDireito() != null){
                    aux = aux.getFilhoDireito();
                } else {
                    novoNodo.setGenitor(aux);
                    break;
                }
            }
        }
    }

    @Override
    public NodoTriplo<T> getRaiz() {
        return raiz;
    }

    @Override
    public void apagar(T dado) {
        NodoTriplo<T> aux = raiz;
        while(true){
            if(dado == aux.getDado()){
                if(aux.getFilhoEsquerdo() == null && aux.getFilhoDireito() == null) {
                    apagarNoFilho(aux);
                } else if(aux.getFilhoEsquerdo() == null && aux.getFilhoDireito() != null
                || aux.getFilhoEsquerdo() != null && aux.getFilhoDireito() == null) {
                    apagarComUmFilho(aux);
                } else {
                    apagarComDoisFilhos(aux);
                }
            } else if( dado <= aux.getDado()){
                aux = aux.getFilhoEsquerdo();
            } else {
                aux = aux.getFilhoDireito();
            }
        }
    }

    public void apagarNoFilho(NodoTriplo<T> no) {
        NodoTriplo<T> auxPai = no.getGenitor();
        if(auxPai.getFilhoEsquerdo().getDado() == no.getDado())
            auxPai.setFilhoEsquerdo(null);
        else
            auxPai.setFilhoDireito(null);
    }
    public void apagarComUmFilho(NodoTriplo<T> no) {
        NodoTriplo<T> auxAvo = no.getGenitor();
        if(no.getFilhoEsquerdo() != null)
            no.getFilhoEsquerdo().setGenitor(auxAvo);
        else
            no.getFilhoDireito().setGenitor(auxAvo);
    }
    public void apagarComDoisFilhos(T dado) {
    }

    @Override
    public boolean existe(T dado) {
        NodoTriplo<T> aux = raiz;
        while(true){
            if((Integer) dado <= (Integer) aux.getDado()){
                if(aux.getFilhoEsquerdo() != null){
                    aux = aux.getFilhoEsquerdo();
                } else if(aux.getDado() == dado){
                    return false;
                }

            } else {
                if(aux.getFilhoDireito() != null){
                    aux = aux.getFilhoDireito();
                } else {
                    return false;
                }
            }
        }
    }

    public boolean existeRec(NodoTriplo<T> subArvore, T dado){
        if(subArvore.getDado() == null)
            return false;
        if(Objects.equals( dado, subArvore.getDado()))
            return true;
        if((Integer) dado <= (Integer) subArvore.getDado()){
            if(subArvore.getFilhoEsquerdo() != null){
                existeRec(subArvore.getFilhoEsquerdo(), dado);
            }
        } else {
            if (subArvore.getFilhoDireito() != null) {
                existeRec(subArvore.getFilhoDireito(), dado);
            }
        }
    }

    @Override
    public void limpar() {
        raiz = null;
    }
}
