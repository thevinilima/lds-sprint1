import java.util.*;
public class Disciplina {
<<<<<<< HEAD
=======
    private static final int MIN_ALUNOS = 3;

>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
    private String id;
    private String nome;
    private Integer maxAlunos;
    private Boolean isOptativa;
    private Professor professor;
<<<<<<< HEAD
    private Set<Aluno> alunos = new HashSet<>();
    private double valor;

    public boolean isAtiva() {
        return !alunos.isEmpty();
=======
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
>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
    }

    public void associarProfessor(Professor professor) {
        this.professor = professor;
    }

    public double getValor() {
        return this.valor;
    }
<<<<<<< HEAD
=======

    public boolean isOptativa() {
        return this.isOptativa;
    }

    public String getId() {
        return this.id;
    }

    public Set<Aluno> getAlunos() {
        return this.alunos;
    }
>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
}

