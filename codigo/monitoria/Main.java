package monitoria;

public class Main {
    public static void main(String[] args) {
        QueueCircular a = new QueueCircular();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);
        a.remove();

        System.out.println(a.print());
    }
}
