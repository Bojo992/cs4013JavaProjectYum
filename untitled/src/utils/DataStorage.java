package utils;

import People.*;
import Restaurant.*;
import org.w3c.dom.html.HTMLIsIndexElement;

import java.util.ArrayList;
import java.util.HashMap;

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

    //CSV SETUP AND BACKUP FUNCTIONS
    public static ArrayList<Restaurant> getAllRestaurants() {
        return allRestaurants;
    }

    public static void setAllRestaurants(ArrayList<Restaurant> input) {
        allRestaurants = input;
    }

    public static HashMap<Restaurant, ArrayList<Table>> getAllTables() {
        return allTables;
    }

    public static void setAllTables(HashMap<Restaurant, ArrayList<Table>> allTables) {
        allTables = allTables;
    }

    public static HashMap<Restaurant, ArrayList<Waiter>> getAllWaiters() {
        return allWaiters;
    }

    public static void setAllWaiters(HashMap<Restaurant, ArrayList<Waiter>> allWaiters) {
        allWaiters = allWaiters;
    }

    public static HashMap<Restaurant, ArrayList<Chef>> getAllChefs() {
        return allChefs;
    }

    public static void setAllChefs(HashMap<Restaurant, ArrayList<Chef>> allChefs) {
        allChefs = allChefs;
    }

    public static ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }

    public static void setAllCustomers(ArrayList<Customer> allCustomers) {
        allCustomers = allCustomers;
    }

    public static HashMap<Restaurant, ArrayList<Food>> getAllMenus() {
        return allMenus;
    }

    public static void setAllMenus(HashMap<Restaurant, ArrayList<Food>> allMenus) {
        DataStorage.allMenus = allMenus;
    }

<<<<<<< HEAD
=======
    public static ArrayList<Order> getAllOrders() {
        return allOrders;
    }

    public static void setAllOrders(ArrayList<Order> allOrders) {
        DataStorage.allOrders = allOrders;
    }

>>>>>>> ffbe52922593a2bb3d656eb8a3c64dca98e590f0
    public static void addRestaurant(Restaurant restaurant) {
        allRestaurants.add(restaurant);
    }
}
