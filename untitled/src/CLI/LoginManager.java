package CLI;

import java.util.HashMap;
import java.util.Scanner;
<<<<<<< HEAD

import People.Customer;
=======
>>>>>>> ffbe52922593a2bb3d656eb8a3c64dca98e590f0
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

    public static boolean checkPass(String username, String passedPassword) {
        return !loginManager.isEmpty() &&
                loginManager.containsKey(username) &&
                loginManager.get(username).getPassword().equals(passedPassword);
    }

    public void run() {
        switch (type) {
            case "customer" -> new UserMenu(in, (Customer) user).run();
            case "employee" -> new EmployeeMenu(in, user).run();
            case "chef" -> new ChefMenu(in, user).run();
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(String userName) {
        user = loginManager.get(userName);
    }
}
