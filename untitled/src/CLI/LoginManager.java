package CLI;

import java.util.HashMap;

public class LoginManager {
    private static HashMap<String, String> loginManager = new HashMap<String, String>();

    public static void createAcc(String user, String pass) {
        loginManager.put(user,pass);
    }

    public static boolean checkPass(String user, String password, String passedPassword) {
        return !loginManager.isEmpty() &&
                loginManager.containsKey(user) &&
                loginManager.get(password).equals(passedPassword);
    }

}
