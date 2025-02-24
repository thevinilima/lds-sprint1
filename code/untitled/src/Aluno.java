import java.util.*;
public class Aluno extends User {
    private Set<Disciplina> disciplinas = new HashSet<>();

    public void matricular(String disciplinaId) {
        System.out.println("Matriculando aluno na disciplina: " + disciplinaId);
    }

    public void cancelar(String disciplinaId) {
        System.out.println("Cancelando disciplina: " + disciplinaId);
    }

    public double getValorTotalSemestre() {
        double total = 0;
        for (Disciplina d : disciplinas) {
            total += d.getValor();
        }
        return total;
    }
}