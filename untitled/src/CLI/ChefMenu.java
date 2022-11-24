package CLI;

import People.*;
import Restaurant.*;
import utils.*;
import java.util.Scanner;

public class ChefMenu extends UtilsMenu {
    private Scanner in;
    private Chef user;
    private Restaurant restaurant;

    public ChefMenu(Scanner in, Chef user) {
        this.in = in;
        this.user = user;

        for (Restaurant restaurant1 : DataStorage.getAllRestaurants()) {
            for (Chef chef : restaurant1.getChefs()) {
                if (chef == user) {
                    this.restaurant = restaurant1;
                }
            }
        }
    }

    public void run() {
        boolean quit = true;
        while (quit) {
            System.out.println("S)ee orders, C)hange state of order, L)ogout");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "S" -> show(restaurant.getOrders().toArray());

                case "C" -> {
                    System.out.println("These are the orders and their state : ");
                    var order = (Order) pick(restaurant.getOrders().toArray());

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