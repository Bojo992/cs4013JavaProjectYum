package Restaurant;

import java.util.ArrayList;
import java.util.TooManyListenersException;

/**
 * The type Order.
 */
public class Order {
    private String status;
    private ArrayList<Food> tableFood;
    private Table table;

    /**
     * Instantiates a new Order.
     * @param table the table
     */
    public Order(Table table) {
        this.table = table;
        this.tableFood = new ArrayList<Food>();
    }

    /**
     * Bill double.
     *
     * @return the double
     */
    public double bill() {
        double total = 0;

        for (Food food : tableFood) {
            total += food.getPrice();
        }

        return total;
    }

    /**
     * Add food.
     * @param food the food
     */
    public void addFood(Food food) {
        tableFood.add(food);
    }

    /**
     * Gets table food.
     * @return the table food
     */
    public ArrayList<Food> getTableFood() {
        return tableFood;
    }

    /**
     * Gets status.
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets table order.
     * @return the table order
     */
    public Table getTableOrder() {
        return table;
    }

    /**
     * Sets table order.
     * @param tableOrder the table order
     */
    public void setTableOrder(Table tableOrder) {
        this.table = tableOrder;
    }

    @Override
    public String toString() {
        return "Order status: " + status + ", Table number: " +  table.getTableNo();
    }
}
