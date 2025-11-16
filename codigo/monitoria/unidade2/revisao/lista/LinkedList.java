package monitoria.unidade2.revisao.lista;

import java.lang.classfile.constantpool.DoubleEntry;
import java.util.Objects;

public class LinkedList<T> implements Listable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int quantity;
    private int size;

    public LinkedList(int size) {
        this.size = size;
        quantity = 0;
        head = null;
        tail = null;
    }

    @Override
    public T remove(int logic) {
        if(isEmpty()) {
            throw new UnderFlowException();
        }
        if(logic < 0 || logic >= quantity) {
            throw new IndexOutOfBoundsException("The position is invalid!");
        }

        DoubleNode<T> aux = head;

        for(int i = 0; i < logic; i++) {
            aux = aux.getNext();
        }
        T data = aux.getData();
        DoubleNode<T> auxPrev = aux.getPrevious();
        DoubleNode<T> auxNext = aux.getNext();

        if(auxPrev == null) {
            head = auxNext;
            if(head == null) {
                tail = null;
            } else {
                head.setPrevious(null);
            }
        } else if (auxNext == null) {
            tail = auxPrev;
            tail.setNext(null);
        } else {
            auxPrev.setNext(auxNext);
            auxNext.setPrevious(auxPrev);
        }

        quantity--;
        return data;
    }

    public String printToEnd(int logic) {
        if(logic < 0 || logic > quantity) {
            throw new IndexOutOfBoundsException("The position is invalid!");
        }
        if(isEmpty()) {
            throw new UnderFlowException();
        }
        DoubleNode<T> aux = head;
        for (int i = 0; i < logic; i++) {
            aux = aux.getNext();
        }
        String auxString = "[";
        for (int i = logic; i < quantity; i++) {
            if(i == quantity - 1) {
                auxString += aux.getData();
            } else {
                auxString += aux.getData() + ", ";
            }

            aux = aux.getNext();
        }

        return auxString + "]";
    }

    public int occurences(T data) {
        if(isEmpty()) {
            throw new UnderFlowException();
        }
        int logic = -1;
        DoubleNode<T> aux = head;
        for (int i = 0; i < quantity; i++) {
            if(Objects.equals(aux.getData(), data)) {
                logic = i;
            }
            aux = aux.getNext();
        }
        return logic;
    }

    @Override
    public boolean isEmpty() {
        return quantity == 0;
    }

    @Override
    public boolean isFull() {
        return quantity == size;
    }

    @Override
    public void insert(int logic, T data) throws OverFlowException {

    }

    @Override
    public void update(int logic, T data) {

    }

    @Override
    public String print() {
        return "";
    }
}
