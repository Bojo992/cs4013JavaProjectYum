package Restaurant;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Menu class
 */
public class Menu {

    private ArrayList<Category> categories;

    /**
     * Constructor for the Menu object
     */
    public Menu() {
        categories = new ArrayList<>();
    }

    /**
     * Getter for categories arraylist
     *
     * @return categories arraylist
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    /**
     * Getter for food from a category arraylist,
     *
     * @param category the category
     * @return Food from a specific category
     */
    public ArrayList<Food> getFoodFromCategory(Category category) {
        return category.getFood();
    }

    /**
     * Add food.
     *
     * @param food         the food
     * @param categoryName the category name
     */
    public void addFood(Food food, String categoryName) {
        for (Category category: categories) {
            if (category.name.equals(categoryName)) {
                category.addFood(food);
            }
        }

    }

    /**
     * Add category.
     *
     * @param categoryName the category name
     */
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

    /**
     * The type Category.
     */
    public class Category{
        /**
         * The Name.
         */
        String name;
        /**
         * The Food.
         */
        ArrayList<Food> food = new ArrayList<Food>();

        /**
         * Instantiates a new Category.
         *
         * @param name the name
         */
        public Category(String name) {
            this.name = name;
        }

        /**
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets food.
         *
         * @return the food
         */
        public ArrayList<Food> getFood() {
            return food;
        }

        /**
         * Sets food.
         *
         * @param food the food
         */
        public void setFood(ArrayList<Food> food) {
            this.food = food;
        }

        /**
         * Add food.
         *
         * @param food the food
         */
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
