package monitoria;

public class Queue implements Queueable{
    private Object[] data;
    private int head;
    private int tail;
    private int quantity;

    public Queue() {
        this(10);
    }

    public Queue(int size) {
        data = new Object[size];
        head = 0;
        tail = -1;
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
            tail++;
            data[tail] = element;
            quantity++;
        } else {
            System.err.println("Queue is full!");
        }
    }

    @Override
    public Object head() {
        Object aux = null;
        if(!isEmpty()) {
            aux = data[head];
        } else {
            System.err.println("Queue is empty!");
        }
        return aux;
    }

    @Override
    public Object remove() {
        Object aux = null;
        if(!isEmpty()) {
            aux = data[head];
            head++;
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
        String aux = "["; // [8,7,9, , , , , , , ] -> [8, 7, 9]
        for(int i = head; i <= tail; i++) {
            aux += data[i];

            if(i != tail) {
                aux += ", ";
            }
        }
        return aux + "]"; // []
    }
}
