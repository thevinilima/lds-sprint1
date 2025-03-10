import java.io.*;
import java.util.*;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static Curriculo curriculo = new Curriculo();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean periodoMatriculasAberto = true;

    public static void main(String[] args) {
        carregarUsuarios();
        exibirMenu();
    }

    private static void exibirMenu() {
        while (true) {
            System.out.println("\n===== Sistema de Matrícula =====");
            System.out.println("1. Login");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    realizarLogin();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    salvarUsuarios();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void realizarLogin() {
        System.out.print("Usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login bem-sucedido!");
                user.login();
                if (user instanceof Aluno) {
                    menuAluno((Aluno) user);
                } else if (user instanceof Professor) {
                    menuProfessor((Professor) user);
                } else if (user instanceof Secretaria) {
                    menuSecretaria((Secretaria) user);
                }
                return;
            }
        }
        System.out.println("Usuário ou senha incorretos.");
    }

    private static void cadastrarUsuario() {
        System.out.print("Tipo (1-Aluno, 2-Professor, 3-Secretaria): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        User novoUsuario;
        if (tipo == 1) {
            novoUsuario = new Aluno(username, password);
        } else if (tipo == 2) {
            novoUsuario = new Professor(username, password);
        } else {
            novoUsuario = new Secretaria(username, password);
        }

        users.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
        salvarUsuarios();
    }

    private static void menuAluno(Aluno aluno) {
        while (true) {
            System.out.println("\n===== Menu Aluno =====");
            System.out.println("1. Matricular em Disciplina");
            System.out.println("2. Cancelar Matrícula");
            System.out.println("3. Ver Valor Total do Semestre");
            System.out.println("4. Logout");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (!periodoMatriculasAberto && (opcao == 1 || opcao == 2)) {
                System.out.println("Período de matrículas encerrado!");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("ID da Disciplina: ");
                    String disciplinaId = scanner.nextLine();
                    aluno.matricular(disciplinaId, disciplinas);
                    System.out.println("Sistema de cobranças notificado para o aluno " + aluno.getUsername());
                    break;
                case 2:
                    System.out.print("ID da Disciplina: ");
                    disciplinaId = scanner.nextLine();
                    aluno.cancelar(disciplinaId, disciplinas);
                    break;
                case 3:
                    System.out.println("Valor total do semestre: R$" + aluno.getValorTotalSemestre());
                    break;
                case 4:
                    aluno.logout();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuProfessor(Professor professor) {
        while (true) {
            System.out.println("\n===== Menu Professor =====");
            System.out.println("1. Listar Alunos por Disciplina");
            System.out.println("2. Adicionar Disciplina");
            System.out.println("3. Logout");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID da Disciplina: ");
                    String disciplinaId = scanner.nextLine();
                    Aluno[] alunos = professor.getAlunosByDisciplina(disciplinaId);
                    if (alunos.length > 0) {
                        System.out.println("Alunos matriculados:");
                        for (Aluno a : alunos) {
                            System.out.println("- " + a.getUsername());
                        }
                    } else {
                        System.out.println("Nenhum aluno encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("ID da Disciplina: ");
                    disciplinaId = scanner.nextLine();
                    Disciplina disciplina = buscarDisciplinaPorId(disciplinaId);
                    if (disciplina != null) {
                        professor.adicionarDisciplina(disciplina);
                        disciplina.associarProfessor(professor);
                    } else {
                        System.out.println("Disciplina não encontrada.");
                    }
                    break;
                case 3:
                    professor.logout();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuSecretaria(Secretaria secretaria) {
        while (true) {
            System.out.println("\n===== Menu Secretaria =====");
            System.out.println("1. Cadastrar Disciplina");
            System.out.println("2. Gerar Currículo");
            System.out.println("3. Finalizar Período de Matrícula");
            System.out.println("4. Logout");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    curriculo = secretaria.gerarCurriculo();
                    System.out.println("Currículo gerado com sucesso!");
                    break;
                case 3:
                    periodoMatriculasAberto = false;
                    curriculo.finalizarPeriodoMatricula();
                    for (Disciplina d : disciplinas) {
                        if (!d.isAtiva()) {
                            System.out.println("Disciplina " + d.getNome() + " cancelada por falta de alunos.");
                        }
                    }
                    break;
                case 4:
                    secretaria.logout();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarDisciplina() {
        System.out.print("ID da Disciplina: ");
        String id = scanner.nextLine();
        System.out.print("Nome da Disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        System.out.print("É optativa? (1-Sim, 0-Não): ");
        int optativa = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = new Disciplina(id, nome, valor, optativa == 1);
        disciplinas.add(disciplina);
        curriculo.addDisciplina(disciplina);
        System.out.println("Disciplina cadastrada!");
        salvarUsuarios();
    }

    private static Disciplina buscarDisciplinaPorId(String id) {
        for (Disciplina d : disciplinas) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    private static void carregarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader("code/untitled/src/usuarios.csv"))) {
            String linha;
            boolean lendoDisciplinas = false;

            while ((linha = br.readLine()) != null) {
                if (linha.equals("---DISCIPLINAS---")) {
                    lendoDisciplinas = true;
                    continue;
                }

                if (!lendoDisciplinas) {
                    String[] dados = linha.split(",");
                    if (dados.length == 3) {
                        String tipo = dados[0];
                        String username = dados[1];
                        String password = dados[2];

                        User user;
                        if ("Aluno".equals(tipo)) {
                            user = new Aluno(username, password);
                        } else if ("Professor".equals(tipo)) {
                            user = new Professor(username, password);
                        } else {
                            user = new Secretaria(username, password);
                        }
                        users.add(user);
                    }
                } else {
                    if (!linha.trim().isEmpty()) {
                        String[] dados = linha.split(",");
                        if (dados.length == 4) {
                            String id = dados[0];
                            String nome = dados[1];
                            double valor = Double.parseDouble(dados[2]);
                            boolean isOptativa = Boolean.parseBoolean(dados[3]);
                            Disciplina disciplina = new Disciplina(id, nome, valor, isOptativa);
                            disciplinas.add(disciplina);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar usuários ou disciplinas: " + e.getMessage());
            File file = new File("code/untitled/src/usuarios.csv");
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
                System.out.println("Arquivo src/usuarios.csv criado.");
            } catch (IOException ex) {
                System.out.println("Erro ao criar arquivo: " + ex.getMessage());
            }
        }
    }

    private static void salvarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("code/untitled/src/usuarios.csv"))) {
            for (User user : users) {
                String tipo = user instanceof Aluno ? "Aluno" : user instanceof Professor ? "Professor" : "Secretaria";
                bw.write(tipo + "," + user.getUsername() + "," + user.getPassword());
                bw.newLine();
            }
            bw.write("---DISCIPLINAS---");
            bw.newLine();
            for (Disciplina disciplina : disciplinas) {
                bw.write(disciplina.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários ou disciplinas: " + e.getMessage());
        }
    }
}