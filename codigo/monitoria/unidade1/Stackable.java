package monitoria.unidade1;

public interface Stackable {
    //CRUD
    void insert(Object dado);

    Object top();

    Object pop();

    void update(Object element);

    String print();
}
