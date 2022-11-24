package Restaurant;

import java.util.ArrayList;

/**
 * Food class
 */
public class Food {
    private String name;
    private double price;
    private ArrayList<Food> food;

    /**
     * Constructs a Food object with specific name and price
     * @param name
     * @param price
     */
    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * @param food
     * Adds a Food object to an ArrayList of food
     */
    public void addFood(Food food){
        food.addFood(food);
    }

    /**
     * Getter for a Food price
     * @return price of the food
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter for a Food name
     * @return name of the food
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the Food arraylist
     * @return food arraylist
     */
    public ArrayList<Food> getFood() {
        return food;
    }

    @Override
    public String toString() {
        return name + " " + "$" + price;
    }

    /** toString method for formatting the CSV file
     * @return (food name), (food price)
     */
    public String toCSV() {
        return name + ", " + price + "\r\n";
    }
}
