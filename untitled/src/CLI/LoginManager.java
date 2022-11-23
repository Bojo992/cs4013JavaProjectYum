package CLI;

import java.util.HashMap;
import java.util.Scanner;

import People.Person;
import utils.DataStorage;

public class LoginManager {
    private Person user;
    private String type;
    private Scanner in;
    private static HashMap<String, Person> loginManager = DataStorage.getAllUsernamesAndPasswords();

    public LoginManager(String type, Scanner in, Person user) {
        this.type = type;
        this.in = in;
        this.user = user;
    }

    public static void createAcc(String user, Person person) {
        loginManager.put(user, person);
    }

    public static boolean checkPass(String user, String passedPassword) {
        return !loginManager.isEmpty() &&
                loginManager.containsKey(user) &&
                loginManager.get(user).getPassword().equals(passedPassword);
    }

    public void run() {
        switch (type) {
            case "customer" -> new UserMenu(in, user).run();
            case "employee" -> new EmployeeMenu(in, user).run();
            case "chef" -> new ChefMenu(in, user).run();
        }
    }
}
