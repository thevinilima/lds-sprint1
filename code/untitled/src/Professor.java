import java.util.*;
<<<<<<< HEAD
public class Professor {
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Aluno[] getAlunosByDisciplina(String disciplinaId) {
        System.out.println("Obtendo alunos da disciplina: " + disciplinaId);
        return new Aluno[0];
=======
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
>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
    }
}