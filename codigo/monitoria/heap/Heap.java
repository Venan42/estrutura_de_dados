package monitoria.heap;

public class Heap {
    private Object[] data;

    private Heap() {
        this(10);
    }

    private Heap(int size) {
        data = new Object[size];
    }


}
