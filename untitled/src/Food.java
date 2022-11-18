import java.util.ArrayList;

public class Food {
    private String name;
    private double price;

    private ArrayList<Food> food;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void addFood(Food food){
        food.addFood(food);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    @Override
    public String toString() {
        return name + " " + "$" + price;
    }
}
