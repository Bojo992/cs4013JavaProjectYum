package CLI;

import java.util.Scanner;

public class UserLoginMenu {
    private Scanner in;
    private String type;
    private LoginManager login;

    public UserLoginMenu(Scanner in, String type) {
        this.in = in;
        this.type = type;
    }

    public void run() {
        boolean quit = true;
        while (quit) {
            System.out.println("L)ogin, C)reate Account, B)ack");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "L" -> {
                    System.out.print("Enter Username : ");
                    String username= in.nextLine().toUpperCase();
                    System.out.print("Enter password : ");
                    String password = in.nextLine().toUpperCase();

                    if(LoginManager.checkPass(username, password)) {
                        login.run();
                    } else {
                        System.out.println("Invalid Username and/or Password");
                    }
                }

                case "C" -> {
                    System.out.print("Create Username : ");
                    String username = in.nextLine().toUpperCase();
                    System.out.print("Create Password : ");
                    String password = in.nextLine().toUpperCase();

                    login = new LoginManager(type, in);
                    LoginManager.createAcc(username, password);
                }

                case "B" -> quit = false;
            }
        }
    }
}
