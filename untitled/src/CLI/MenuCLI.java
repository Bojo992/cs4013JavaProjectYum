package CLI;

import utils.DataStorage;
import utils.UtilsCSV;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuCLI {

    private Scanner in;

    public MenuCLI() {
        in = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Restaurant CLI Menu");
        boolean quit = true;

        UtilsCSV csv = new UtilsCSV();

        try {
            DataStorage.setAllRestaurants(csv.readRestaurants());
            DataStorage.getAllRestaurants();
        } catch (FileNotFoundException e) {
        }

        while (true) {
            System.out.print("Do you want to add the a restaurant? Y)es or N)ot: ");
            String input = in.nextLine().toUpperCase();

            while (!input.equals("Y") && !input.equals("N")) {
                System.out.print("Please enter Y)es or N)ot: ");
                input = in.nextLine().toUpperCase();
            }

            if (input.equals("Y")) {
                new CreateRestaurant(in).run();
            } else {
                break;
            }
        }

        while (quit) {
            System.out.println("Login as E)mployee, C)hef, U)ser or Q)uit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "E" -> new UserLoginMenu(in, "employee").run();
                case "C" -> new UserLoginMenu(in, "chef").run();
                case "U" -> new UserLoginMenu(in, "customer").run();
                case "Q" -> {
                    csv.writeRestaurants(DataStorage.getAllRestaurants());
                    quit = false;
                }
            }
        }
    }
}
