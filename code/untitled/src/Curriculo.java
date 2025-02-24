import java.util.*;
public class Curriculo {
    private List<Curso> cursos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public void addDisciplina(Disciplina disciplina) {
        System.out.println("Adicionando disciplina: " + disciplina);
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
    }

    public void delDisciplina(Disciplina disciplina) {
        System.out.println("Removendo disciplina: " + disciplina);
    }

    public void delCurso(Curso curso) {
        cursos.remove(curso);
    }
}