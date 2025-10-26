package monitoria.unidade1.prova;

import java.util.ArrayList;
import java.util.Arrays;

public class Questao2 {
    String[] alunosA;
    String[] alunosB;
    String[] alunosC;

    public Questao2(ArrayList<String> A, ArrayList<String> B, ArrayList<String> C) {
        // conversão correta para String[]
        alunosA = A.toArray(new String[0]);
        alunosB = B.toArray(new String[0]);
        alunosC = C.toArray(new String[0]);
    }

    //////////////////////
    // Métodos utilitários e principais
    private boolean contains(String nome, String[] alunos) {
        for (String a : alunos)
            if (a.equals(nome))
                return true;
        return false;
    }

    /** a) alunos que fazem esportiva e cultural e não extensão */
    public String[] culturaEEsporteSemExtensao() {
        ArrayList<String> result = new ArrayList<>();
        for (String aluno : alunosB) {
            if (contains(aluno, alunosA) && !contains(aluno, alunosC)) {
                result.add(aluno);
            }
        }
        return result.toArray(new String[0]);
    }

    /** b) alunos que fazem somente extensão */
    public String[] somenteExtensao() {
        ArrayList<String> result = new ArrayList<>();
        for (String aluno : alunosC) {
            if (!contains(aluno, alunosA) && !contains(aluno, alunosB)) {
                result.add(aluno);
            }
        }
        return result.toArray(new String[0]);
    }

    /** c) alunos que fazem cultural ou extensão, mas não fazem esportiva */
    public String[] culturaOuExtensaoSemEsporte() {
        ArrayList<String> result = new ArrayList<>();
        // incluir os de A que não estão em B
        for (String aluno : alunosA) {
            if (!contains(aluno, alunosB) && !contains(aluno, result.toArray(new String[0]))) {
                result.add(aluno);
            }
        }

        // incluir os de C que não estão em B, e que ainda não foram incluídos
        for (String aluno : alunosC) {
            if (!contains(aluno, alunosB) && !result.contains(aluno)) {
                result.add(aluno);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        ArrayList<String> culturaA = new ArrayList<>();
        culturaA.add("Alice");
        culturaA.add("Bob");
        culturaA.add("Carol");
        culturaA.add("David");

        ArrayList<String> esporteB = new ArrayList<>();
        esporteB.add("Bob");
        esporteB.add("David");
        esporteB.add("Eve");
        esporteB.add("Frank");

        ArrayList<String> extensaoC = new ArrayList<>();
        extensaoC.add("Carol");
        extensaoC.add("David");
        extensaoC.add("Frank");
        extensaoC.add("Gael");

        Questao2 q2 = new Questao2(culturaA, esporteB, extensaoC);
        System.out.println("a) Esporte + Cultura, sem Extensão: " + Arrays.toString(q2.culturaEEsporteSemExtensao()));   // [Bob]
        System.out.println("b) Somente Extensão: " + Arrays.toString(q2.somenteExtensao()));                             // [Gael]
        System.out.println("c) Cultura ou Extensão, sem Esporte: " + Arrays.toString(q2.culturaOuExtensaoSemEsporte())); // [Alice, Carol, Gael]
    }
}
