package Restaurant;

import CLI.LoginManager;
import People.*;
import utils.DataStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private String getRandomNum() {
        Random random = new Random();
        int number = random.nextInt(999999);

        return String.format("%6d", number);
    }

    public void addWaiter(Waiter waiter) {
        waiters.add(waiter);
        String username = "" + waiter.hashCode();
        String password = getRandomNum();

        LoginManager.createAcc(username, password);
    }

    public void addChef(Chef chef) {
        chefs.add(chef);
        String username = "" + chef.hashCode();
        String password = getRandomNum();

        LoginManager.createAcc(username, password);
    }

    public void addTable(Table tableToAdd) {
        if (tables.size() < numberOfTables) {
            tables.add(tableToAdd);
        } else {
            throw new IndexOutOfBoundsException("You have maximum number of tables");
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public int getNumberOfTables() {
        return numberOfTables;
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
}
