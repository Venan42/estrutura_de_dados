package monitoria.unidade2.revisao.lista;

public class OverFlowException extends Exception {
    public OverFlowException(String message) {
        super(message);
    }
    public OverFlowException() {
        super("The list is full!");
    }
}
