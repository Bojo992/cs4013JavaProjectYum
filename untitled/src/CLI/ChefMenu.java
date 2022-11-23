package CLI;

import People.Person;
import Restaurant.Order;
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
<<<<<<< HEAD
            var table = (Table) pick(DataStorage.getAllTables().values().toArray());
            //ToDo List all tables from tables class
=======
            var table = (Table) chooseFirstType(DataStorage.getAllTables().values().toArray());
>>>>>>> ffbe52922593a2bb3d656eb8a3c64dca98e590f0
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
                    var order = (Order)chooseFirstType(DataStorage.getAllOrders().toArray());
                    if (order != null){
                        System.out.println("Current state of order (in progress, ready): ");
                        order.setStatus(in.nextLine());
                    }
                }


                case "L" -> { //Returns to Login page
                    quit = false;
                }
            }
        }
    }
}