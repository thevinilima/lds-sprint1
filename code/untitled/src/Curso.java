import java.util.*;
public class Curso {
    private String id;
    private String nome;
    private Integer creditos;
    private List<Disciplina> disciplinas;

    public Curso(String id, String nome, Integer creditos) {
        this.id = id;
        this.nome = nome;
        this.creditos = creditos;
        disciplinas = new ArrayList<>();
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void removeDisciplina(String disciplinaId) {
        disciplinas.removeIf(d -> d.getId().equals(disciplinaId));
    }

    public void finalizarPeriodoMatricula() {
        System.out.println("Finalizando período de matrícula.");
    }

    public String getId() {
        return this.id;
    }
}