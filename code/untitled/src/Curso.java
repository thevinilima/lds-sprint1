import java.util.*;
public class Curso {
    private String id;
    private String nome;
    private Integer creditos;
<<<<<<< HEAD
    private List<Disciplina> disciplinas = new ArrayList<>();
=======
    private List<Disciplina> disciplinas;

    public Curso(String id, String nome, Integer creditos) {
        this.id = id;
        this.nome = nome;
        this.creditos = creditos;
        disciplinas = new ArrayList<>();
    }
>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

<<<<<<< HEAD
    public void finalizarPeriodoMatricula() {
        System.out.println("Finalizando período de matrícula.");
    }
=======
    public void removeDisciplina(String disciplinaId) {
        disciplinas.removeIf(d -> d.getId().equals(disciplinaId));
    }

    public void finalizarPeriodoMatricula() {
        System.out.println("Finalizando período de matrícula.");
    }

    public String getId() {
        return this.id;
    }
>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
}