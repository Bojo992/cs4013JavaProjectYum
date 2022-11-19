package People;

public class Person {
    private String name;
    private String email;
    private String phone;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String email, String phone) {
        this(name);
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}