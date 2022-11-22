package CLI;

import java.util.Scanner;

public class LoginHandler {
    private String username;
    private String password;
    private Scanner in;
    private String type;

    public LoginHandler(String username, String password, Scanner in, String type) {
        this.username = username;
        this.password = password;
        this.in = in;
        this.type = type;
    }

    //TODO check if the password is correct before login
    public void run() {
        switch (type) {
            case "customer" -> new UserMenu(in).run();
            case "employee" -> new EmployeeMenu(in).run();
            case "chef" -> new ChefMenu(in).run();
        }
    }

    public String getPassword() {
        return password;
    }
}
