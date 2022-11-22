package Restaurant;

import CLI.LoginManager;
import CLI.Menu;
import People.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Food> menu;
    private ArrayList<Table> tables;
    private ArrayList<Waiter> waiters;
    private ArrayList<Chef> chefs;
    private ArrayList<Customer> customers;

    public Restaurant(int numberOfTables) {
        menu = new ArrayList<>();
        tables = new ArrayList<>(numberOfTables);
        waiters = new ArrayList<>();
        chefs = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addWaiter(Waiter newWaiter) {
        waiters.add(newWaiter);
        //LoginManager.createAcc();
    }


    /*
    add array lists from the datastorage
    - add waiter() which will generate an user + password and pass thru the login manager
    same for others
     */

    public List<Food> getMenu() {
        return menu;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public ArrayList<Waiter> getWaiters() {
        return waiters;
    }

    public ArrayList<Chef> getChefs() {
        return chefs;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
