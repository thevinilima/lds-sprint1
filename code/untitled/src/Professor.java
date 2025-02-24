import java.util.*;
public class Professor {
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Aluno[] getAlunosByDisciplina(String disciplinaId) {
        System.out.println("Obtendo alunos da disciplina: " + disciplinaId);
        return new Aluno[0];
    }
}