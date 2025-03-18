public interface Empilhavel {
    public void empilhar(Object dado);
    public Object desempilhar();
    public void atualizar(Object dado);
    public String imprimir();

    public Object espiar();
    public boolean estaCheia();
    public boolean estaVazia();

}