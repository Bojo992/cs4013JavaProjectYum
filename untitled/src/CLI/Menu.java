package CLI;

import java.util.Scanner;

public class Menu {

    private Scanner in;

    public Menu() {

        in = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Restaurant.Restaurant CLI.Menu");
        boolean quit = true;

        while (quit) {
            System.out.println("Login as E)mployee, U)ser or Q)uit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "E" -> {
                    System.out.println("Enter employee's ID and password");
                    new EmployeeMenu(in).run();
                }

                case "U" -> {
                    new UserLoginMenu(in).run();
                }
                case "Q" -> {
                    quit = false;
                }
            }
        }
    }
}
