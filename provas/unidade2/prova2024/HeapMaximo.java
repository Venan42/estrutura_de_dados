package unidade2.prova2024;

public class HeapMaximo {
    public long ajustarPrioridade(int prioridade){
        long tempoInverso = 1_000_000_000_000L - System.nanoTime();
        return prioridade * 1_000_000_000_000L + tempoInverso;
    }
}
