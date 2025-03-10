public class User {
    protected String id;
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void login() {
        System.out.println("Usuário " + username + " logado.");
    }

    public void logout() {
        System.out.println("Usuário " + username + " deslogado.");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}