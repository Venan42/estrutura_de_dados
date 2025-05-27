public class FilaEstaticaDupla implements DuplamenteEnfileravel {
    private Object[] dados;
    private int ponteiroInicio;
    private int ponteiroFim;
    private int quantidade;

    public FilaEstaticaDupla() {
        this(10);
    }

    public FilaEstaticaDupla(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        this.quantidade = 0;
    }

    public int avancar(int numero) {
        return (numero + 1) % dados.length;
    }

    public int voltar(int numero) {
        return (numero - 1 + dados.length) % dados.length;
    }

    @Override
    public void enfileirarInicio(Object dado) {
        if (!estaCheia()) {
            ponteiroInicio = voltar(ponteiroFim);
            dados[ponteiroInicio] = dado;
            quantidade++;
        } else {
            System.err.println("Queue is Full!");
        }
    }

    @Override
    public void enfileirarFim(Object dado) {
        if (!estaCheia()) {
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
            quantidade++;
        } else {
            System.err.println("Queue is Full!");
        }
    }

    @Override
    public Object desenfileirarInicio() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroInicio];
            ponteiroInicio = avancar(ponteiroInicio);
            quantidade--;
        } else {
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public Object desenfileirarFim() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroFim];
            ponteiroFim = voltar(ponteiroFim);
            quantidade--;
        } else {
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public Object frente() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroInicio];
        } else {
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public Object tras() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroFim];
        } else {
            System.err.println("Queue is Empty!!!");
        }
        return aux;
    }

    @Override
    public void atualizarInicio(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroInicio] = dado;
        } else {
            System.err.println("Queue is Empty!!!");
        }
    }

    @Override
    public void atualizarFim(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroFim] = dado;
        } else {
            System.err.println("Queue is Empty!!!");
        }
    }

    @Override
    public boolean estaCheia() {
        return (quantidade == dados.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String imprimirTrasFrente() {
        String aux = "[";
        int pos = ponteiroFim;
        for (int i = 0; i < quantidade; i++) {
            aux += dados[pos];
            if (i < quantidade - 1)
                aux += ", ";
            pos = voltar(pos);
        }
        return aux + "]";
    }

    @Override
    public String imprimirFrenteTras() {
        String aux = "[";
        int pos = ponteiroInicio;

        for (int i = 0; i < quantidade; i++) {
            aux += dados[pos];
            if (i < quantidade - 1)
                aux += ", ";
            pos = avancar(pos);
        }

        return aux + "]";
    }

}
