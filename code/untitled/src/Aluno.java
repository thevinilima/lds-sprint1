import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class Aluno extends User {
    private Set<Disciplina> disciplinas = new HashSet<>();
    private static final int MAX_OBRIGATORIAS = 4;
    private static final int MAX_OPTATIVAS = 2;

    public Aluno(String username, String password) {
        super(username, password);
    }

    public void matricular(String disciplinaId, List<Disciplina> disciplinasDisponiveis) {
        Disciplina disciplina = buscarDisciplinaPorId(disciplinaId, disciplinasDisponiveis);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        // Contar matrículas atuais
        int obrigatoriasMatriculadas = (int) disciplinas.stream().filter(d -> !d.isOptativa()).count();
        int optativasMatriculadas = (int) disciplinas.stream().filter(Disciplina::isOptativa).count();

        if (disciplina.isOptativa()) {
            if (optativasMatriculadas >= MAX_OPTATIVAS) {
                System.out.println("Limite de " + MAX_OPTATIVAS + " disciplinas optativas atingido.");
                return;
            }
        } else {
            if (obrigatoriasMatriculadas >= MAX_OBRIGATORIAS) {
                System.out.println("Limite de " + MAX_OBRIGATORIAS + " disciplinas obrigatórias atingido.");
                return;
            }
        }

        if (!disciplina.podeMatricular()) {
            System.out.println("Disciplina " + disciplina.getNome() + " está cheia.");
            return;
        }

        disciplina.matricularAluno(this);
        disciplinas.add(disciplina);
        System.out.println("Matrícula realizada com sucesso!");
    }

    public void cancelar(String disciplinaId, List<Disciplina> disciplinasDisponiveis) {
        Disciplina disciplina = buscarDisciplinaPorId(disciplinaId, disciplinasDisponiveis);
        if (disciplina != null && disciplinas.remove(disciplina)) {
            disciplina.cancelarMatricula(this);
        } else {
            System.out.println("Disciplina não encontrada ou você não está matriculado nela.");
        }
    }

    public double getValorTotalSemestre() {
        double total = 0;
        for (Disciplina d : disciplinas) {
            total += d.getValor();
        }
        return total;
    }

    private Disciplina buscarDisciplinaPorId(String id, List<Disciplina> disciplinasDisponiveis) {
        for (Disciplina d : disciplinasDisponiveis) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }
}