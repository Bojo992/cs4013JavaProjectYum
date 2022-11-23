package Restaurant;

import CLI.LoginManager;
import People.*;
import utils.DataStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class implements the Restaurant and
 * its data fields and methods
 *
 * @author italo
 */
public class Restaurant {
    private Menu menu;
    private ArrayList<Table> tables;
    private ArrayList<Waiter> waiters;
    private ArrayList<Chef> chefs;
    private ArrayList<Customer> customers;
    private int numberOfTables;
    private String id;

    /**
     * Construct a Restaurant with a specific amount of tables.
     * @param numberOfTables
     */
    public Restaurant(int numberOfTables) {
        this.menu = new Menu();
        this.tables = new ArrayList<>();
        this.waiters = new ArrayList<>();
        this.chefs = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.numberOfTables = numberOfTables;
        int id = DataStorage.getAllRestaurants().size();

        this.id = id + "";
    }

    /**
     * This method generates a 6 digit random number
     * from 0 to 999999
     * @return a random number as a string using String.format
     */
    private String getRandomNum() {
        Random random = new Random();
        int number = random.nextInt(999999);

        return String.format("%6d", number);
    }

    /**
     * This method adds the waiter passed in the parameter to the waiters arraylist in the data fields.
     *  It creates a username string with an empty string and a hash code of the parameter.
     *  It also creates a password using the getRandomNum() method.
     *  After creating those two strings it passes them to createAcc() method from the
     *  LoginManager class.
     * @param waiter
     */
    public void addWaiter(Waiter waiter, String password) {
        waiters.add(waiter);
        String username = "" + waiter.hashCode();

        while (DataStorage.getAllUsernamesAndPasswords().containsKey(username)) {
            username = "" + getRandomNum();
        }

        waiter.setId(username);
        waiter.setPassword(password);

        LoginManager.createAcc(username, waiter);
    }

    /**
     * This method adds the chef passed in the parameter to the chefs arraylist in the data fields.
     *  It creates a username string with an empty string and a hash code of the parameter.
     *  It also creates a password using the getRandomNum() method.
     *  After creating those two strings it passes them to createAcc() method from the
     *  LoginManager class.
     * @param chef
     */
    public void addChef(Chef chef, String paswor) {
        chefs.add(chef);
        String username = "" + chef.hashCode();

        while (DataStorage.getAllUsernamesAndPasswords().containsKey(username)) {
            username = id + "c" + getRandomNum();
        }

        LoginManager.createAcc(username, chef);
    }

    /**
     * This method adds the table passed in the parameter to the tables arraylist in the data fields.
     *  Before adding it, the method checks if the tables arraylist is less than the number of tables in the restaurant.
     *  If it adds them to the arraylist, else it throws an IndexOutOfBoundsException returning a string
     *  saying that the number of tables have been reached already.
     * @param tableToAdd
     */
    public void addTable(Table tableToAdd) {
        if (tables.size() < numberOfTables) {
            tables.add(tableToAdd);
        } else {
            throw new IndexOutOfBoundsException("You have maximum number of tables");
        }
    }

    /**
     * Getter for menu data field.
     * @return menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Getter for tables data field.
     * @return tables
     */
    public ArrayList<Table> getTables() {
        return tables;
    }

    /**
     * Getter for numberOfTables data field.
     * @return numberOfTables
     */
    public int getNumberOfTables() {
        return numberOfTables;
    }

    /**
     * Getter for waiters data field.
     * @return waiters
     */
    public ArrayList<Waiter> getWaiters() {
        return waiters;
    }

    /**
     * Getter for chefs data field.
     * @return chefs
     */
    public ArrayList<Chef> getChefs() {
        return chefs;
    }

    /**
     * Getter for customer data field.
     * @return customers
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    /**
     * Getter for id data field.
     * @return id
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void addMenu(Menu menu) {
        this.menu = menu;
    }
}
