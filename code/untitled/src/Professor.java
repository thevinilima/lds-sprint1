import java.util.*;
public class Professor extends User {
    private List<Disciplina> disciplinas;

    public Professor(String id, String username, String password) {
        super(id, username, password);
        disciplinas = new ArrayList<>();
    }

    public Set<Aluno> getAlunosByDisciplina(String disciplinaId) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId().equals(disciplinaId)) {
                return disciplina.getAlunos();
            }
        }
        return null;
    }
}