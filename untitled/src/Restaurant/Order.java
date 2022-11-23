package Restaurant;

import java.util.ArrayList;

public class Order {
    //ToDo return total price of food
    // loop thru the arraylist, total += food.getPrice()

    //ToDo add items one by one
    private int id;
    private ArrayList<Food>[] food;
    private ArrayList<Food> tableOrder;

    public Order(Table table) {
        this.tableOrder = new ArrayList<>();
        this.id = table.getTableNo();
    }

    public int bill() {
        int total = 0;

        for (int i = 0; i < tableOrder.size(); i++) {
            total += tableOrder.get(i).getPrice();
        }

        return total;
    }

    public ArrayList<Food> getTableOrder() {
        return tableOrder;
    }

    public void setTableOrder(ArrayList<Food> tableOrder) {
        this.tableOrder = tableOrder;
    }
}
