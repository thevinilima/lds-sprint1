import java.util.HashSet;
import java.util.Set;

public class Disciplina {
    private String id;
    private String nome;
    private Integer maxAlunos;
    private Boolean isOptativa;
    private Professor professor;
    private Set<Aluno> alunos = new HashSet<>();
    private double valor;

    public Disciplina(String id, String nome, double valor, boolean isOptativa) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.isOptativa = isOptativa;
        this.maxAlunos = 60;
    }

    public void associarProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getUsername() + " associado.");
    }

    public boolean isAtiva() {
        return alunos.size() >= 3;
    }

    public boolean podeMatricular() {
        return alunos.size() < maxAlunos;
    }

    public void matricularAluno(Aluno aluno) {
        if (podeMatricular()) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getUsername() + " matriculado na disciplina " + nome);
        } else {
            System.out.println("Disciplina " + nome + " atingiu o limite de " + maxAlunos + " alunos.");
        }
    }

    public void cancelarMatricula(Aluno aluno) {
        if (alunos.remove(aluno)) {
            System.out.println("Matrícula cancelada para o aluno " + aluno.getUsername());
        } else {
            System.out.println("Aluno " + aluno.getUsername() + " não estava matriculado nesta disciplina.");
        }
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public boolean isOptativa() {
        return isOptativa;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return id + "," + nome + "," + valor + "," + isOptativa;
    }
}