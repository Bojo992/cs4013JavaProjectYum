package CLI;

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

    //TODO check if the password is correct before login
    public void run() {
        if(username.contains("u_")) {
            new UserMenu(in).run();
        } else if (username.contains("e_")) {
            new EmployeeMenu(in).run();
        } else if (username.contains("c_")) {
            new ChefMenu(in).run();
        }
    }
}
