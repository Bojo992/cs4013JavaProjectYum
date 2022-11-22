package utils;

import People.*;
import Restaurant.*;

import java.util.ArrayList;
import java.util.HashMap;

public class dataStorage {
    private static HashMap<String, Restaurant> allRestaurants = new HashMap<>();
    private static HashMap<Restaurant, ArrayList<Table>> allTables = new HashMap<>();
    private static HashMap<Restaurant, Waiter> allWaiters = new HashMap<>(); 
    private static HashMap<Restaurant, Chef> allChefs = new HashMap<>(); 
    private static HashMap<Restaurant, Customer> allCustomers = new HashMap<>();

    public static HashMap<String, Restaurant> getAllRestaurants() {
        return allRestaurants;
    }

    public static void setAllRestaurants(HashMap<String, Restaurant> allRestaurants) {
        dataStorage.allRestaurants = allRestaurants;
    }

    public static HashMap<Restaurant, Table> getAllTables() {
        return allTables;
    }

    public static void setAllTables(HashMap<Restaurant, Table> allTables) {
        dataStorage.allTables = allTables;
    }

    public static HashMap<Restaurant, Waiter> getAllWaiters() {
        return allWaiters;
    }

    public static void setAllWaiters(HashMap<Restaurant, Waiter> allWaiters) {
        dataStorage.allWaiters = allWaiters;
    }

    public static HashMap<Restaurant, Chef> getAllChefs() {
        return allChefs;
    }

    public static void setAllChefs(HashMap<Restaurant, Chef> allChefs) {
        dataStorage.allChefs = allChefs;
    }

    public static HashMap<Restaurant, Customer> getAllCustomers() {
        return allCustomers;
    }

    public static void setAllCustomers(HashMap<Restaurant, Customer> allCustomers) {
        dataStorage.allCustomers = allCustomers;
    }

    public ArrayList
}
