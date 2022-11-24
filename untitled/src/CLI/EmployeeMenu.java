package CLI;

import People.Person;
import People.Waiter;
import Restaurant.*;
import utils.DataStorage;
import utils.UtilsMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeMenu extends UtilsMenu {
    private Scanner in;
    private Person user;

    private Restaurant restaurant;


    public EmployeeMenu(Scanner in, Person user) {
        this.in = in;
        this.user = user;

        for (Restaurant restaurant1: DataStorage.getAllRestaurants()) {
            for (Waiter waiter : restaurant1.getWaiters()) {
                if (waiter == user) {
                    this.restaurant = restaurant1;
                }
            }
        }
    }


    public void run() {
        boolean quitToMain = true;
        while (quitToMain) {
            System.out.println("W)alk-in, A)dd order, V)iew tables, O)rder List, L)ogout");
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
                    System.out.println("Select the Table you want to add order to : ");
                    boolean quitAddOrder = true;
                    var table = (Table) pick(DataStorage.getAllTables().values().toArray());
                    System.out.println("Add Order : ");
                    Order order = new Order(table);
                    while (quitAddOrder) {
                        Food food = chooseFoodMenu(restaurant.getMenu());

                        if (food == null) {
                            break;
                        }else {
                            order.addFood(food);
                        }
                    }

                    if (order.getTableFood().isEmpty()) {
                        System.out.println("Order canceled.");
                        break;
                    }

                    restaurant.addOrder(order);
                    System.out.println("Order Successfully Added.");

                }

                case "V" -> {
                    System.out.println("Here are all the tables in the restaurant : ");
                    show(DataStorage.getAllTables().values().toArray());
                }

                case "O" -> {
                    System.out.println("Here is a list of all the current orders : ");
                    show(restaurant.getOrders().toArray());
                }

                case "L" -> {
                    quitToMain = false;
                }
            }
        }
    }

    private Food chooseFoodMenu(Menu menu){
        System.out.println("Choose category:");
        System.out.println(" 0) Cancel");
        int i = 1;
        for (Menu.Category c: menu.getCategories()) {
            i++;
            System.out.printf(" %d) %s", i, c.getName());
            System.out.println();
        }
        System.out.print("Please pick your category: ");
        String line = in.nextLine();

        while (true){
            try{
                i = Integer.parseInt(line);
                if (i>0 && i<=menu.getCategories().size() ) {
                    break;
                }
                System.out.print("Please pick from above: ");
                line = in.nextLine();

            } catch (Exception e) {
                System.out.print("Please pick from above: ");
                line = in.nextLine();
            }
        }
        int j = 1;
        ArrayList<Food> foods = menu.getCategories().get(i).getFood();
        for (Food food : foods) {
            System.out.printf(" %d) %s", j++, food.toString());
            System.out.println();
        }
        System.out.print("Please pick your meal: ");
        line = in.nextLine();
        while (true){
            try{
                i = Integer.parseInt(line);
                if (i>0 && i<=foods.size() ) {
                    break;
                }
                System.out.print("Please pick from above: ");
                line = in.nextLine();
            } catch (Exception e) {
                System.out.print("Please pick from above: ");
                line = in.nextLine();
            }
        }

        return foods.get(i);
    }
}
