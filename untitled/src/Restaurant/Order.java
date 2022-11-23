package Restaurant;

import java.util.ArrayList;

public class Order {
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

        for (int i = 0; i < tableFood.length - 1; i++) {
            total += tableFood[i].get(i).getPrice(); //ToDo test, not sure if it's fully functional
        }

        return total;
    }

    public void addFood(Food food) {
        for (int i = 0; i < tableFood.length - 1; i++) {
            tableFood[i].get(i).addFood(food); //ToDo test, not sure if it's fully functional
        }
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
