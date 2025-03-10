import java.util.*;

public class Curso {
    private String id;
    private String nome;
    private Integer creditos;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Curso(String id, String nome, Integer creditos) {
        this.id = id;
        this.nome = nome;
        this.creditos = creditos;
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        System.out.println("Disciplina " + disciplina.getNome() + " adicionada ao curso.");
    }

    public void finalizarPeriodoMatricula() {
        System.out.println("Finalizando período de matrícula.");
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public Integer getCreditos() {
        return creditos;
    }

    @Override
    public String toString() {
        return "Curso{id='" + id + "', nome='" + nome + "', creditos=" + creditos + "}";
    }
}