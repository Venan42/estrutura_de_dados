package monitoria.unidade1.prova;

public class Aeroporto {
    static class Passageiro implements Comparable{
        private String nome;
        private int idade;
        private boolean prioridadeEspecial; // (2) (1)
        public long prioridade;
        private static long contador = 0;

        public long calcularPrioridade(int idade, boolean prioridadeEspecial) {
            long incremento = 999_999 - contador;
            contador++;
            int risk;
            if(prioridadeEspecial) {
                risk = 2;
            } else {
                risk = 1;
            }

            return 1_000_000 * risk + incremento;
        }

        @Override
        public int compareTo(Object outro) { //-1, 0, 1
            int cmp = Long.compare(this.prioridade, outro.prioridade);
            if(cmp == 0) {
                cmp = Integer.compare(this.idade, outro.idade);
            }

            return cmp;
        }
    }
}
