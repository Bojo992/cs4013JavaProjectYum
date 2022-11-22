package CLI;

import java.util.Scanner;

public class ChefMenu {
    private Scanner in;

    public ChefMenu(Scanner in) {
        this.in = in;
    }

    public void run() {
        boolean quit = true;
        while (quit) {
            System.out.println("Select a table you would like to view : ");
            //ToDo List all tables from tables class
            String command = in.nextLine().toUpperCase();
            switch (command) {
                case "T" -> { //ToDo let chef choose via Number beside table (e.g. 1)table_1, 2)table_2..)
                    System.out.println("S)ee order, C)hange state of order, L)ogout");
                }

                case "S" -> {
                    System.out.println("These are the orders and their state : ");
                    //ToDo need to assign state from order class
                }
                case "C" -> { //ToDo make sure that after order is changed, the program goes back to case "T"
                    System.out.println("Select which order you want to change status : ");
                }

                case "L" -> { //Returns to Login page
                    quit = false;
                }
            }
        }
    }
}