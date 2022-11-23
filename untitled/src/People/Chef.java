package People;

import Restaurant.Order;

/**
 * Chef class which extends Employee class
 * @author italo
 */
public class Chef extends Employee{
    /**
     * Constructor with specific name, phone and title
     * @param name
     * @param phone
     * @param title
     */
    public Chef(String name, String phone, String title) {
        super(name, phone, title);
    }

    /**
     * This method allows the chef to change the status of an order to indicate that it is complete.
     */
    public void changeStatus(Order order, String status) {
        order.setStatus(status);
    }
}
