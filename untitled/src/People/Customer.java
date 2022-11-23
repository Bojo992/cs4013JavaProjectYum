package People;
import Restaurant.Food;
import Restaurant.Table;

import java.time.LocalDate;

public class Customer extends Person {
    private int noOfCustomer;
    private LocalDate date = LocalDate.now();
    private Table table;

    public Customer(String name) {
        super(name);
    }

    public Customer(String name, String phone) {
        super(name, phone);
    }

    public void makeOrder(Table table, Food food){

    }

    /*------------------
       Getters/Setters
      ------------------*/

    public Table getTable() {
        return table;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
