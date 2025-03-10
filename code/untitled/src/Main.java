import java.io.*;
import java.util.*;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

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
                System.out.println("Login bem-sucedido!" );
                if (user instanceof Aluno) {
                    menuAluno((Aluno) user);
                } else if (user instanceof Professor) {
                    menuProfessor((Professor) user);
                } else {
                    menuSecretaria();
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
        System.out.println("\nBem-vindo, Aluno " + aluno.getUsername());
        // Adicionar opções do aluno aqui
    }

    private static void menuProfessor(Professor professor) {
        System.out.println("\nBem-vindo, Professor " + professor.getUsername());
        // Adicionar opções do professor aqui
    }

    private static void menuSecretaria() {
        System.out.println("\nBem-vindo à Secretaria");
        // Adicionar opções da secretaria aqui
    }

    private static void carregarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
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
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }

    private static void salvarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.csv"))) {
            for (User user : users) {
                String tipo = user instanceof Aluno ? "Aluno" : user instanceof Professor ? "Professor" : "Secretaria";
                bw.write(tipo + "," + user.getUsername() + "," + user.getPassword());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }
}
