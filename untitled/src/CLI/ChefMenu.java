package CLI;

import People.Person;
import Restaurant.Table;
import utils.DataStorage;
import utils.UtilsMenu;
import java.util.Scanner;

public class ChefMenu extends UtilsMenu {
    private Scanner in;
    private Person user;

    public ChefMenu(Scanner in, Person user) {
        this.in = in;
        this.user = user;
    }

    public void run() {
        boolean quit = true;
        while (quit) {
            System.out.println("Select a table you would like to view : ");
            var table = (Table) chooseFirstType(DataStorage.getAllTables().values().toArray());
            String command = in.nextLine().toUpperCase();

            System.out.println("S)ee order, C)hange state of order, L)ogout");
            //ToDo THIS PART IS A WORK IN PROGRESS
            switch (command) {
                case "S" -> { //ToDo let chef choose via Number beside table (e.g. 1)table_1, 2)table_2..)
                    showFirstType(DataStorage.getAllOrders().toArray());
                }

                case "C" -> {
                    System.out.println("These are the orders and their state : ");
                    //ToDo need to assign state from order class
                    chooseFirstType(DataStorage.getAllOrders().toArray());
                }


                case "L" -> { //Returns to Login page
                    quit = false;
                }
            }
        }
    }
}