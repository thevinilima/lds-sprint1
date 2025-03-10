public class Secretaria extends User {

    public Secretaria(String username, String password) {
        super(username, password);
    }

    public Curriculo gerarCurriculo() {
        Curriculo curriculo = new Curriculo();
        Curso curso = new Curso("ENG001", "Engenharia", 200);
        curriculo.addCurso(curso);
        return curriculo;
    }
}