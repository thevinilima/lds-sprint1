import java.util.*;
public class Disciplina {
    private String id;
    private String nome;
    private Integer maxAlunos;
    private Boolean isOptativa;
    private Professor professor;
    private Set<Aluno> alunos = new HashSet<>();
    private double valor;

    public boolean isAtiva() {
        return !alunos.isEmpty();
    }

    public void associarProfessor(Professor professor) {
        this.professor = professor;
    }

    public double getValor() {
        return this.valor;
    }
}

