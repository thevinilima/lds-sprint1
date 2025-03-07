import java.util.*;
public class User {
    protected String id;
    protected String username;
    protected String password;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void login() {
        System.out.println("Usuário " + username + " logado.");
    }

    public void logout() {
        System.out.println("Usuário " + username + " deslogado.");
    }
}