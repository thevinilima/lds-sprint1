import java.util.*;

public class Curriculo {
    private List<Curso> cursos = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public void addDisciplina(Disciplina disciplina) {
        System.out.println("Adicionando disciplina: " + disciplina.getNome());
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
        System.out.println("Curso " + curso.getNome() + " adicionado ao currículo.");
    }

    public void delDisciplina(Disciplina disciplina) {
        System.out.println("Removendo disciplina: " + disciplina.getNome());
    }

    public void delCurso(Curso curso) {
        cursos.remove(curso);
    }

    public void finalizarPeriodoMatricula() {
        System.out.println("Período de matrícula finalizado!");
    }
}