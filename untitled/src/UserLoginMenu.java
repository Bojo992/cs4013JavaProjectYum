import java.util.Scanner;

public class UserLoginMenu {
    private Scanner in;

    public UserLoginMenu(Scanner in) {

        this.in = in;
    }
    public void run() {
        while (true) {
            System.out.println("L)ogin, C)reate Account, B)ack");
            String command = in.nextLine().toUpperCase();
            switch (command) {
                case "L" -> {
                    System.out.print("Enter Username : ");
                    String username = in.nextLine().toUpperCase();
                    System.out.print("Enter password : ");
                    String password = in.nextLine().toUpperCase();
                    new LoginHandler(username, password, in);
                    new UserMenu(in).run();

                }
                case "C" -> {
                    System.out.print("Create Username :");
                    String username = in.nextLine().toUpperCase();
                    System.out.print("Create Password :");
                    String password = in.nextLine().toUpperCase();

                }
                case "B" -> {
                    break;
                }

            }
        }
    }
}
