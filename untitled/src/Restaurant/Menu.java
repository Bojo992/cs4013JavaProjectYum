package Restaurant;

import java.security.PublicKey;
import java.util.ArrayList;

public class Menu {

    private ArrayList<Category> categories;

    public Menu() {
        categories = new ArrayList<>();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Food> getFoodFromCategory(Category category) {
        return category.getFood();
    }

    public void addFood(Food food, String categoryName) {
        for (Category category: categories) {
            if (category.name.equals(categoryName)) {
                category.addFood(food);
            }
        }

    }

    public void addCategory(String categoryName) {
        categories.add(new Category(categoryName));
    }

    @Override
    public String toString() {
        StringBuilder menu = new StringBuilder();

        int i = 1;

        for (Category category: categories) {
            menu.append(i + ") " + category.toString());
        }

        return menu.toString();
    }

    public class Category{
        String name;
        ArrayList<Food> food = new ArrayList<Food>();

        public Category(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Food> getFood() {
            return food;
        }

        public void setFood(ArrayList<Food> food) {
            this.food = food;
        }

        public void addFood(Food food) {
            this.food.add(food);
        }

        @Override
        public String toString() {
            StringBuilder category = new StringBuilder();

            category.append(name + "\n");

            int i = 1;

            for (Food food: this.food) {
                category.append("    " + i + ") " + food.toString() + "\n");
            }

            return category.toString();
        }
    }
}
