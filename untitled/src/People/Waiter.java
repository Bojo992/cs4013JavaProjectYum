package People;

public class Waiter extends Employee{
    public Waiter(String name, String title) {
        super(name, title);
    }
    public Waiter(String name,String phone, String title) {
        super(name,phone, title);
    }

    public void reserveTable() {
        //reserve table for walk-in customers
    }

    public void createOrder() {
        //create an order for a table, include a meal for each person sitting at the table
    }
}
