package CLI;

import java.util.Scanner;

public class Menu {

    private Scanner in;

    public Menu() {

        in = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Restaurant.Restaurant CLI.Menu");

        while (true) {
            System.out.println("Login as E)mployee or U)ser");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "E" -> new UserLoginMenu(in, "employee").run();
                case "U" -> new UserLoginMenu(in, "customer").run();
            }
        }
    }
}
