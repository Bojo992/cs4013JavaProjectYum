package People;

/**
 * Super class for all the users of the restaurant.
 * @author italo
 */
public class Person {
    private String name;
    private String phone;

    /**
     * Constructor with a specific name.
     * @param name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Constructor with a specific name and phone number.
     * @param name
     */
    public Person(String name, String phone) {
        this(name);
        this.phone = phone;
    }

    /**
     * Getter for name data field.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for phone data field.
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets a new name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets a new phone
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
