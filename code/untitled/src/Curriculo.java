import java.util.*;
public class Curriculo {
    private List<Curso> cursos = new ArrayList<>();
    private Boolean podeMatricular;

    public Curriculo() {
        podeMatricular = true;
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
    }

    public void removeCurso(String cursoId) {
        cursos.removeIf(c -> c.getId().equals(cursoId));
    }

    public void finalizarPeriodoMatricula() {
        podeMatricular = false;
    }

    public Boolean podeMatricular() {
        return podeMatricular;
    }
}