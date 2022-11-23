package CLI;

import People.Person;
import Restaurant.Table;
import utils.DataStorage;
import utils.UtilsMenu;
import java.util.Scanner;

public class EmployeeMenu extends UtilsMenu {
    private Scanner in;
    private Person user;

    public EmployeeMenu(Scanner in, Person user) {
        this.in = in;
        this.user = user;
    }

    public void run() {
        boolean quitToMain = true;
        while (quitToMain) {
            System.out.println("W)alk-in, A)dd order, V)iew tables, O)rder List, C)hange order, L)ogout");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "W" -> {
                    boolean quitFromWalkIn = true;
                    while (quitFromWalkIn) {
                        System.out.println("C)heck available tables, R)eserve table, G)o Back");
                        command = in.nextLine().toUpperCase();

                        switch (command) {
                            case "C" -> {
                                System.out.println("These tables are available for walk-ins : ");
                                show(DataStorage.getAllTables().values().toArray());
                                //ToDo display tables that are available (this can be an option just to view for employer
                                // info)
                            }

                            case "R" -> {
                                System.out.println("Select a table for walk-in customer : ");
                                var table = (Table) pick(DataStorage.getAllTables().values().toArray());
                            }

                            case "G" -> {
                                quitFromWalkIn = false;
                            }
                        }
                    }
                }

                case "A" -> {
                    System.out.println("Select the Restaurant.Table you want to add order to : ");
                    var table = (Table) pick(DataStorage.getAllTables().values().toArray());

                    System.out.println("Add Order : ");
                    //var order = (Order) chooseFirstType(DataStorage.getAllOrder().values().toArray());

                    System.out.println("Order Successfully Added.");

                    /*
                    System.out.println("Print something with a choice 1) 2) 3) F)");
                    command = in.nextLine();

                    switch (command) { //ToDo check if works, testing merging cases
                        case "1", "2", "3" -> { //ToDo need table numbers
                            System.out.println("A)dd meal, C)hange meal, F)inish ");
                            switch (command) {
                                case "A" -> {
                                    System.out.println("What items would you like to add? : ");
                                }
                                case "C" -> {
                                    System.out.println("Previous meal : ");
                                    System.out.println("New meal : ");
                                }
                                case "F" -> {
                                    quitFromAddOrder = false;
                                }
                            }

                            //This shouldn't be here
                            //it would need another switch, requesting input A)dd meal, C)hange meal, F)inish
                        }

                        //ToDo need menu ArrayList

                        case "F" -> {
                            quitFromAddOrder = false;
                        }
                    } */
                }

                case "V" -> {
                    System.out.println("Here are all the tables in the restaurant : ");
                    show(DataStorage.getAllTables().values().toArray());
                }

                case "O" -> {
                    System.out.println("Here is a list of all the current orders : ");
                    //showFirstType(DataStorage.getAllOrders().values().toArray());
                    //ToDo make sure that list updates depending on order status.
                }

                case "C" -> {
                    System.out.println("Which order would you like to change? : ");
                    //var order = (Order) chooseFirstType(DataStorage.getAllOrders().values().toArray());
                    //ToDo Display all orders based on table selection??? or based on just order number?
                }

                case "L" -> {
                    quitToMain = false;
                }
            }
        }
    }
}
