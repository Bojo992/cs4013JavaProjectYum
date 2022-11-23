package Restaurant;

import java.util.ArrayList;

public class Order {
    private ArrayList<Food> tableOrder;

    public Order() {
        this.tableOrder = new ArrayList<>();
    }

    public ArrayList<Food> getTableOrder() {
        return tableOrder;
    }

    public void setTableOrder(ArrayList<Food> tableOrder) {
        this.tableOrder = tableOrder;
    }
}
