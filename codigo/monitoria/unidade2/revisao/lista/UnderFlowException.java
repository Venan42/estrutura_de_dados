package monitoria.unidade2.revisao.lista;

public class UnderFlowException extends RuntimeException {
    public UnderFlowException(String message) {
        super(message);
    }
    public UnderFlowException() {
        super("The list is empty!");
    }
}
