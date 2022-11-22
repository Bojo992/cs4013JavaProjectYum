package utils;

import People.*;
import Restaurant.*;

import java.util.ArrayList;
import java.util.HashMap;

public class dataStorage {
    private static HashMap<String, Restaurant> allRestaurants = new HashMap<>();
    private static HashMap<Restaurant, ArrayList<Table>> allTables = new HashMap<>();
    private static HashMap<Restaurant, ArrayList<Waiter>> allWaiters = new HashMap<>();
    private static HashMap<Restaurant, ArrayList<Chef>> allChefs = new HashMap<>();
    private static ArrayList<Customer> allCustomers = new ArrayList<>();
    private static HashMap<Restaurant, ArrayList<Food>> allMenus = new HashMap<>();
    private static HashMap<String, String> allUsernamesAndPasswords = new HashMap<>();

    public static HashMap<String, String> getAllUsernamesAndPasswords() {
        return allUsernamesAndPasswords;
    }

    public static void setAllUsernamesAndPasswords(HashMap<String, String> allUsernamesAndPasswords) {
        dataStorage.allUsernamesAndPasswords = allUsernamesAndPasswords;
    }

    //CSV SETUP AND BACKUP FUNCTIONS
    public static HashMap<String, Restaurant> getAllRestaurants() {
        return allRestaurants;
    }

    public static void setAllRestaurants(HashMap<String, Restaurant> allRestaurants) {
        allRestaurants = allRestaurants;
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
        dataStorage.allMenus = allMenus;
    }


    //GETTERS FOR SPECIFIC RESTAURANT
    public static ArrayList<Table> getTablesForRestaurant(String restaurantId) {
        return allTables.get(allRestaurants.get(restaurantId));
    }

    public static ArrayList<Chef> getChefsForRestaurant(String restaurantId) {
        return allChefs.get(allRestaurants.get(restaurantId));
    }

    public static ArrayList<Waiter> getWaitersForRestaurant(String restaurantId) {
        return allWaiters.get(allRestaurants.get(restaurantId));
    }

    public static ArrayList<Food> getMenuForRestaurant(String restaurantId) {
        return allMenus.get(allRestaurants.get(restaurantId));
    }
}
