package CLI;

import java.util.Scanner;

public class UserLoginMenu {
    private String username;
    private String password;
    private Scanner in;
    private String type;
    private LoginHandler login;

    public UserLoginMenu(Scanner in, String type) {
        this.in = in;
        this.type = type;
    }

    public void run() {
        while (true) {
            System.out.println("L)ogin, C)reate Account, B)ack");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "L" -> {
                    System.out.print("Enter Username : ");
                    String username1 = in.nextLine().toUpperCase();
                    System.out.print("Enter password : ");
                    String password1 = in.nextLine().toUpperCase();

                    if(username1.equals(this.username) && password1.equals(this.password)) {
                        login.run();
                    } else {
                        System.out.println("Invalid Username and/or Password");
                    }
                }

                case "C" -> {
                    System.out.print("Create Username : ");
                    this.username = in.nextLine().toUpperCase();
                    System.out.print("Create Password : ");
                    this.password = in.nextLine().toUpperCase();

                    login = new LoginHandler(username, password, in, type);
                }

                case "B" -> new Menu().run();


            }
        }
    }
}
