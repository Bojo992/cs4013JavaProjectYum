package Restaurant;

import java.util.ArrayList;

public class Order {
    //ToDo add items one by one
    private String status;
    private ArrayList<Food>[] tableFood;
    private Table table;

    public Order(Table table, Food food) {
        this.table = table;
        this.tableFood = new ArrayList[table.getNumberOfAllTable() + 1];
        tableFood[table.getTableNo()].add(food);
    }

    public int bill() {
        int total = 0;

        for (ArrayList<Food> value : tableFood) {
            //total += value.getPrice();
        }

        return total;
    }

    public void addFood(Food food) {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Table getTableOrder() {
        return table;
    }

    public void setTableOrder(Table tableOrder) {
        this.table = tableOrder;
    }
}
