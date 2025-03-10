import java.util.*;
public class Professor extends User {
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Professor(String username, String password) {
        super(username, password);
    }

    public Aluno[] getAlunosByDisciplina(String disciplinaId) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId().equals(disciplinaId)) {
                return disciplina.getAlunos().toArray(new Aluno[0]);
            }
        }
        return new Aluno[0];
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        System.out.println("Disciplina " + disciplina.getNome() + " vinculada.");
    }

    
}