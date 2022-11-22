package Restaurant;

import People.*;
import utils.DataStorage;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private Menu menu;
    private ArrayList<Table> tables;
    private ArrayList<Waiter> waiters;
    private ArrayList<Chef> chefs;
    private ArrayList<Customer> customers;
    private int numberOfTables;
    private String id;

    public Restaurant(int numberOfTables) {
        this.menu = new Menu();
        this.tables = new ArrayList<>();
        this.waiters = new ArrayList<>();
        this.chefs = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.numberOfTables = numberOfTables;
        int id = DataStorage.getAllRestaurants().keySet().size();

        while (DataStorage.getAllRestaurants().containsKey(id + "")) {
            id++;
        }

        this.id = id + "";
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

    public Menu getMenu() {
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

    public String getId() {
        return id;
    }

    public void addTable(Table tableToAdd) {
        if (tables.size() < numberOfTables) {
            tables.add(tableToAdd);
        } else {
            throw new IndexOutOfBoundsException("You have maximum number of tables");
        }
    }

    public void addChef(Chef chef) {
        chefs.add(chef);
    }
}
