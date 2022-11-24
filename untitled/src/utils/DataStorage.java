package utils;

import People.*;
import Restaurant.*;
import org.w3c.dom.html.HTMLIsIndexElement;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * DataStorage class will setup and backup data from the Restaurant to be written into the CSV files
 */
public class DataStorage {
    private static ArrayList<Restaurant> allRestaurants = new ArrayList<>();
    private static HashMap<Restaurant, ArrayList<Table>> allTables = new HashMap<>();
    private static HashMap<Restaurant, ArrayList<Waiter>> allWaiters = new HashMap<>();
    private static HashMap<Restaurant, ArrayList<Chef>> allChefs = new HashMap<>();
    private static ArrayList<Customer> allCustomers = new ArrayList<>();
    private static HashMap<Restaurant, ArrayList<Food>> allMenus = new HashMap<>();
    private static HashMap<String, Person> allUsernamesAndPasswords = new HashMap<>();
    private static ArrayList<Order> allOrders = new ArrayList<>();

    public static HashMap<String, Person> getAllUsernamesAndPasswords() {
        return allUsernamesAndPasswords;
    }

    public static void setAllUsernamesAndPasswords(HashMap<String, Person> allUsernamesAndPasswords) {
        DataStorage.allUsernamesAndPasswords = allUsernamesAndPasswords;
    }

    /**
     * Getter to return the ArrayList of allRestaurants
     * @return
     */
    //CSV SETUP AND BACKUP FUNCTIONS
    public static ArrayList<Restaurant> getAllRestaurants() {
        return allRestaurants;
    }

    /**
     * Setter for the ArrayList of allRestaurants
     * @param input
     */
    public static void setAllRestaurants(ArrayList<Restaurant> input) {
        allRestaurants = input;
    }

    /**
     * Getter to return HashMap of allTables
     * @return
     */
    public static HashMap<Restaurant, ArrayList<Table>> getAllTables() {
        return allTables;
    }

    /**
     * Setter for HashMap of allTables
     * @param allTables
     */
    public static void setAllTables(HashMap<Restaurant, ArrayList<Table>> allTables) {
        allTables = allTables;
    }

    /**
     * Getter for HashMap of allWaiters
     * @return
     */
    public static HashMap<Restaurant, ArrayList<Waiter>> getAllWaiters() {
        return allWaiters;
    }

    /**
     * Setter for HashMap of allWaiters
     * @param allWaiters
     */
    public static void setAllWaiters(HashMap<Restaurant, ArrayList<Waiter>> allWaiters) {
        allWaiters = allWaiters;
    }

    /**
     * Getter for HashMap of allChefs
     * @return
     */
    public static HashMap<Restaurant, ArrayList<Chef>> getAllChefs() {
        return allChefs;
    }

    /**
     * Setter for HashMap of allChefs
     * @param allChefs
     */
    public static void setAllChefs(HashMap<Restaurant, ArrayList<Chef>> allChefs) {
        allChefs = allChefs;
    }

    /**
     * Getter for ArrayList of allCustomers
     * @return
     */
    public static ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }

    /**
     * Setter for ArrayList of allCustomers
     * @param allCustomers
     */
    public static void setAllCustomers(ArrayList<Customer> allCustomers) {
        allCustomers = allCustomers;
    }

    /**
     * Getter for HashMap of allMenus
     * @return
     */
    public static HashMap<Restaurant, ArrayList<Food>> getAllMenus() {
        return allMenus;
    }

    /**
     * Setter for HashMap of allMenus
     * @param allMenus
     */
    public static void setAllMenus(HashMap<Restaurant, ArrayList<Food>> allMenus) {
        DataStorage.allMenus = allMenus;
    }

    /**
     * Getter for ArrayList of allOrders
     * @return
     */
    public static ArrayList<Order> getAllOrders() {
        return allOrders;
    }

    /**
     * Setter for ArrayList of allOrders
     * @param allOrders
     */
    public static void setAllOrders(ArrayList<Order> allOrders) {
        DataStorage.allOrders = allOrders;
    }

    /**
     * Adds Restaurant objects to an ArrayList of allRestaurants
     * @param restaurant
     */
    public static void addRestaurant(Restaurant restaurant) {
        allRestaurants.add(restaurant);
    }

    /**
     *  Adds Customer objects to an ArrayList of allCustomers
     * @param customer
     */
    public static void addCustomer(Customer customer) {
        allCustomers.add(customer);
    }
}
