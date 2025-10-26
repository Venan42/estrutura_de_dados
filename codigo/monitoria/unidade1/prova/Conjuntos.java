package monitoria.unidade1.prova;

public class Conjuntos {
    /**
     * Questão 1. Implemente em Java três métodos que recebam duas listas estáticas
     * (Lista) como parâmetros e retornem um array com os seguintes resultados:
     */

    /*
    a) difference(listaA, listaB): retorna os elementos que estão presentes apenas em listaA,
    excluindo aqueles que aparecem também em listaB. Ex.: listaA = [1, 2, 3] e listaB = [2, 4]
    deve retornar [1, 3].
     */

    public Lista difference(Lista listaA, Lista listaB) {
        Lista resposta = new Lista();

        for(Object element : listaA) {
            if(!listaB.contains(num)) {
                resposta.add(num);
            }
        }

        return resposta;
    }

    /*
    b) union(listaA, listaB): retorna todos os elementos únicos presentes em listaA ou em listaB,
    ou em ambas, sem duplicações. Ex.: listaA = [1, 2] e listaB = [2, 3], cujo resultado esperado
    é [1, 2, 3].
     */
    public Lista union(Lista listaA, Lista listaB) {
        Lista resposta = new Lista();

        for(Object element : listaA) {
            if(!resposta.contains(element)) {
                resposta.add(element);
            }
        }

        for(Object element : listaB) {
            if(!resposta.contains(element)) {
                resposta.add(element);
            }
        }

        return resposta;
    }

    //fingir que ele esta dentro da lista
    public boolean contains(Object element) {
        boolean aux = false;
        for(Object var : data) {
            if(var == element) {
                aux = true;
                break;
            }
        }

        return aux;
    }

    /*
    c) intersection(listaA, listaB): retorna apenas os elementos que aparecem em ambas as
    listas. Ex.: listaA = [1, 2, 3] e listaB = [2, 4], cujo resultado esperado é [2].
     */
    public Lista intersection(Lista listaA, Lista listaB) {
        Lista resposta = new Lista();

        for(Object element : listaA) {
            if(listaB.contains(element) && !resposta.contains(element)) {
                resposta.add(element);
            }
        }

        return resposta;
    }
}
