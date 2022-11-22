package People;

public class Person {
    private String name;
    private String phone;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String phone) {
        this(name);

        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
