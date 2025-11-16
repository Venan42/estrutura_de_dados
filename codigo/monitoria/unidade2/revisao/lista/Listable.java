package monitoria.unidade2.revisao.lista;

public interface Listable<T> {
    void insert(int logic, T data) throws OverFlowException;
    T remove(int logic);
    void update(int logic, T data);
    boolean isEmpty();
    boolean isFull();
    String print();
}
