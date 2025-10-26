package monitoria.unidade1;

public class QueueCircular implements Queueable {
    private Object[] data;
    private int tail;
    private int head;
    private int quantity;

    public QueueCircular() {
        this(10);
    }

    public QueueCircular(int size) {
        data = new Object[size];
        head = 0;
        tail = -1;
        quantity = 0;
    }

    private int next(int number) {
        return (number + 1)%data.length;
    }

    private int less(int number) {
        return (number - 1 + data.length)%data.length;
    }

    @Override
    public int size() {
        return quantity;
    }

    private boolean isEmpty() {
        return quantity == 0;
    }

    private boolean isFull() {
        return quantity == data.length;
    }

    @Override
    public void insert(Object element) {
        if(!isFull()) {
            tail = next(tail);
            data[tail] = element;
            quantity++;
        } else {
            System.err.println("Queue is full!");
        }
    }

    @Override
    public Object peekHead() {
        Object aux = null;
        if(!isFull()) {
            aux = data[head];
        } else {
            System.err.println("Queue is full!");
        }

        return aux;
    }

    @Override
    public Object peekTail() {
        Object aux = null;
        if(!isFull()) {
            aux = data[tail];
        } else {
            System.err.println("Queue is full!");
        }

        return aux;
    }

    @Override
    public Object remove() {
        Object aux = null;
        if(!isEmpty()) {
            aux = data[tail];
            tail = less(tail);
            quantity--;
        } else {
            System.err.println("Queue is empty!");
        }

        return aux;
    }

    @Override
    public void updateHead(Object element) {
        if(!isEmpty()) {
            data[head] = element;
        } else {
            System.err.println("Queue is empty!");
        }
    }

    @Override
    public void updateTail(Object element) {
        if(!isEmpty()) {
            data[tail] = element;
        } else {
            System.err.println("Queue is empty!");
        }
    }

    @Override
    public String print() {
        String aux = "[";
        for(int i = 0; i <= tail; i++) {
            aux += data[i];

            if(i != tail) {
                aux += ", ";
            }
        }
        return aux + "]";
    }
}