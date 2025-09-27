package monitoria;

public interface Queueable {
    //CRUD
    void insert(Object dado);

    Object peekHead();
    Object peekTail();

    Object remove();

    void updateHead(Object element);

    void updateTail(Object element);

    String print();

    int size();
}
