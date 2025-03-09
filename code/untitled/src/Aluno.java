import java.util.*;
public class Aluno extends User {
<<<<<<< HEAD
    private Set<Disciplina> disciplinas = new HashSet<>();

    public void matricular(String disciplinaId) {
        System.out.println("Matriculando aluno na disciplina: " + disciplinaId);
    }

    public void cancelar(String disciplinaId) {
        System.out.println("Cancelando disciplina: " + disciplinaId);
=======
    private static final int MAX_DISCIPLINAS_OBRIGATORIAS = 4;
    private static final int MAX_DISCIPLINAS_OPTATIVAS = 2;

    private Set<Disciplina> disciplinas;

    public Aluno(String id, String nome, String password) {
        super(id, nome, password);
        disciplinas = new HashSet<>();
    }

    public void matricular(Disciplina disciplina) {
        if (disciplina.isOptativa() && !podeMatricularOptativa()) {
            System.out.println("Aluno já atingiu o limite de disciplinas optativas.");
            return;
        }
        if (!disciplina.isOptativa() && !podeMatricularObrigatoria()) {
            System.out.println("Aluno já atingiu o limite de disciplinas obrigatórias.");
            return;
        }
        disciplinas.add(disciplina);
    }

    public void cancelar(String disciplinaId) {
        if (disciplinas.removeIf(d -> d.getId().equals(disciplinaId))) {
            System.out.println("Disciplina removida com sucesso.");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
    }

    public double getValorTotalSemestre() {
        double total = 0;
        for (Disciplina d : disciplinas) {
            total += d.getValor();
        }
        return total;
    }
<<<<<<< HEAD
=======

    private boolean podeMatricularObrigatoria() {
        return disciplinas.stream().filter(d -> !d.isOptativa()).count() < MAX_DISCIPLINAS_OBRIGATORIAS;
    }

    private boolean podeMatricularOptativa() {
        return disciplinas.stream().filter(d -> d.isOptativa()).count() < MAX_DISCIPLINAS_OPTATIVAS;
    }
>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
}