package CLI;

import java.util.HashMap;
import java.util.Scanner;
import utils.dataStorage;

public class LoginManager {
    private String type;
    private Scanner in;
    private static HashMap<String, String> loginManager = new HashMap<String, String>();

    public LoginManager(String type, Scanner in) {
        this.type = type;
        this.in = in;
        dataStorage.setAllUsernamesAndPasswords(loginManager);
    }

    public static void createAcc(String user, String pass) {
        loginManager.put(user,pass);
    }

    public static boolean checkPass(String user, String passedPassword) {
        return !loginManager.isEmpty() &&
                loginManager.containsKey(user) &&
                loginManager.get(user).equals(passedPassword);
    }

    public void run() {
        switch (type) {
            case "customer" -> new UserMenu(in).run();
            case "employee" -> new EmployeeMenu(in).run();
            case "chef" -> new ChefMenu(in).run();
        }
    }
}
