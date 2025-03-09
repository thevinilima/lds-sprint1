import java.util.*;
public class User {
    protected String id;
    protected String username;
    protected String password;

<<<<<<< HEAD
=======
    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

>>>>>>> c0d198dfff5541c980f7cd56c3cf806f44c3bb81
    public void login() {
        System.out.println("Usuário " + username + " logado.");
    }

    public void logout() {
        System.out.println("Usuário " + username + " deslogado.");
    }
}