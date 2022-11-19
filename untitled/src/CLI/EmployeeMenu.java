package CLI;

import java.util.Scanner;

public class EmployeeMenu {
    private Scanner in;

    public EmployeeMenu(Scanner in) {
        this.in = in;
    }

    public void run() {
        while (true) {
            System.out.println("W)alk-in, A)dd order, V)iew tables, C)hange order, L)ist Order, B)ack");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "W" -> {
                    while (true) {
                        System.out.println("C)heck available tables, R)eserve table, G)o Back");
                        command = in.nextLine().toUpperCase();

                        switch (command) {
                            case "C" -> {
                                System.out.println("These tables are available for walk-ins : ");
                                //ToDo display tables that are available (this can be an option just to view for employer
                                // info)
                            }

                            case "R" -> {
                                System.out.println("Select a table for walk-in customer : ");
                                //ToDo display tables with a number for choice
                            }

                            case "G" -> {
                                break;
                            }
                        }
                    }
                }

                case "A" -> {
                    System.out.println("Select the Table you want to add order to : ");
                    //ToDo display tables and customers

                    while (true) {
                        switch (command) {
                            case "T" -> { //ToDo need table numbers
                                System.out.println("A)dd meal, C)hange meal, F)inish ");
                            }

                            case "A" -> { //ToDo need menu ArrayList
                                System.out.println("What items would you like to add? : ");
                                //ToDo list of menu from arraylist of food
                            }

                            case "C" -> { //ToDo need table numbers
                                System.out.println("Previous eal : ");
                                //ToDo getMeal from food class
                                System.out.println("New meal : ");
                                //ToDo setMeal from food class
                            }

                            case "F" -> {
                                break;
                            }
                        }
                    }
                }

                case "V" -> {
                    System.out.println("All tables : ");
                    //ToDo tables from tables object
                }

                case "C" -> {
                    System.out.println("Which order would you like to change? : ");
                    //ToDo Display all orders based on table selection??? or based on just order number?
                }

                case "L" -> {
                    System.out.println("Here is a list of all the current orders : ");
                    //ToDo make sure that list updates depending on order status.
                }

                case "B" -> {
                    break;
                }
            }

        }
    }
}
