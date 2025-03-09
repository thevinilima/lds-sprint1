import java.util.*;
public class Curriculo {
    private List<Curso> cursos = new ArrayList<>();
<<<<<<< HEAD
    private List<Professor> professores = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();

    public void addDisciplina(Disciplina disciplina) {
        System.out.println("Adicionando disciplina: " + disciplina);
=======
    private Boolean podeMatricular;

    public Curriculo() {
        podeMatricular = true;
>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
    }

<<<<<<< HEAD
    public void delDisciplina(Disciplina disciplina) {
        System.out.println("Removendo disciplina: " + disciplina);
    }

    public void delCurso(Curso curso) {
        cursos.remove(curso);
=======
    public void removeCurso(String cursoId) {
        cursos.removeIf(c -> c.getId().equals(cursoId));
    }

    public void finalizarPeriodoMatricula() {
        podeMatricular = false;
    }

    public Boolean podeMatricular() {
        return podeMatricular;
>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
    }
}