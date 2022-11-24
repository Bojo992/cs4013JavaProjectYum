package People;

/**
 * Waiter class that extends Employee
 */
public class Waiter extends Employee{
    /**
     * Constructor that specifies a name and title
     * @param name
     * @param title
     */
    public Waiter(String name, String title) {
        super(name, title);
    }

    /**
     * Constructor that specifies a name, phone and title
     * @param name
     * @param phone
     * @param title
     */
    public Waiter(String name,String phone, String title) {
        super(name,phone, title);
    }

}
