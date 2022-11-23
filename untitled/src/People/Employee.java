package People;

/**
 * Employee class which extends Person class
 * @author italo
 */
public class Employee extends Person{
    private String title; //distinguish from chef and waiter

    /**
     * Constructor with specific name, phone and title
     * @param name
     * @param phone
     * @param title
     */
    public Employee(String name, String phone, String title) {
        super(name, phone);
        this.title = title;
    }

    /**
     * Getter for title data field.
     * @return title
     */
    public String getTitle() {
        return title;
    }
}
