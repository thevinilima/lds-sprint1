import java.util.*;
public class Disciplina {
    private static final int MIN_ALUNOS = 3;

    private String id;
    private String nome;
    private Integer maxAlunos;
    private Boolean isOptativa;
    private Professor professor;
    private Set<Aluno> alunos;
    private double valor;

    public Disciplina(String id, String nome, Integer maxAlunos, Boolean isOptativa, double valor) {
        this.id = id;
        this.nome = nome;
        this.maxAlunos = maxAlunos;
        this.isOptativa = isOptativa;
        this.valor = valor;
        this.alunos = new HashSet<>();
    }

    public boolean isAtiva() {
        return alunos.size() >= MIN_ALUNOS;
    }

    public void associarProfessor(Professor professor) {
        this.professor = professor;
    }

    public double getValor() {
        return this.valor;
    }

    public boolean isOptativa() {
        return this.isOptativa;
    }

    public String getId() {
        return this.id;
    }

    public Set<Aluno> getAlunos() {
        return this.alunos;
    }
}

