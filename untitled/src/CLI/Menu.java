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
            System.out.println("Login as E)mployee, C)hef, U)ser or Q)uit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "E" -> new UserLoginMenu(in, "employee").run();
                case "C" -> new UserLoginMenu(in, "chef").run();
                case "U" -> new UserLoginMenu(in, "customer").run();
                case "Q" -> quit = false;
            }
        }
    }
}
