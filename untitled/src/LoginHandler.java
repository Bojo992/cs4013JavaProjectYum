import java.util.Scanner;

public class LoginHandler {

    private String username;
    private String password;
    private Scanner in;

    public LoginHandler(String username, String password, Scanner in) {
        this.username = username;
        this.password = password;
        this.in = in;
    }

}
