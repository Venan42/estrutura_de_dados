package monitoria;

public class Stack implements Stackable {
    private Object[] data;
    private int pointerTop;

    public Stack() {
        this(10);
    }

    public Stack(int size) {
        data = new Object[size];
        pointerTop = -1;
    }

    public boolean isEmpty() {
        return pointerTop == -1;
    }

    public boolean isFull() {
        return pointerTop == data.length - 1;
    }

    @Override
    public void insert(Object element) {
        if(!isFull()) {
            pointerTop++;
            data[pointerTop] = element;
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public Object top() {
        Object aux = null;
        if(!isEmpty()) {
            aux = data[pointerTop];
        } else {
            System.err.println("Stack is empty!");
        }

        return aux;
    }

    @Override
    public Object pop() {
        Object aux = null;
        if(!isEmpty()) {
            aux = data[pointerTop];
            pointerTop--;
        } else {
            System.err.println("Stack is empty!");
        }

        return aux;
    }

    @Override
    public void update(Object element) {
        if(!isEmpty()) {
             data[pointerTop] = element;
        } else {
            System.err.println("Stack is empty!");
        }
    }

    @Override
    public String print() {
        String aux = "["; // [8,7,9, , , , , , , ] -> [8, 7, 9]
        for(int i = 0; i <= pointerTop; i++) {
            aux += data[i];

            if(i != pointerTop) {
                aux += ", ";
            }
        }
        return aux + "]"; // []
    }
}
