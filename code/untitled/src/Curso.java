import java.util.*;
public class Curso {
    private String id;
    private String nome;
    private Integer creditos;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void finalizarPeriodoMatricula() {
        System.out.println("Finalizando período de matrícula.");
    }
}