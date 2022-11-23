package Restaurant;

import People.Chef;
import People.Waiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.WildcardType;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UtilsCSV {
    public List<Food> readFoodFromCSV(String filename){
        List<Food> foods = new ArrayList<>();
        try{
            Path filePath = Paths.get(filename);
            try(Scanner dataSource = new Scanner(filename)) {
                while (dataSource.hasNextLine()){
                    String line = dataSource.nextLine();
                    String[] lineSplit = line.split(",");
                    Food food = createFood(lineSplit);
                    foods.add(food);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return foods;
    }

    private Food createFood(String[] metadata){
        String name = metadata[0];
        double price = Double.parseDouble(metadata[1]);

        return new Food(name,price);
    }

    public void writeRestaurant(Restaurant restaurant) throws IOException {
        File restaurantsCSV = new File("restaurant.csv");
        FileWriter writer;
        Scanner in = new Scanner(restaurantsCSV);

        if (restaurantsCSV.exists() && restaurantsCSV.canWrite()) {
            writer = new FileWriter(restaurantsCSV, true);
        } else {
            writer = new FileWriter(restaurantsCSV);
        }

        StringBuilder restaurantString = new StringBuilder();

        restaurantString.append(String.format("restaurant, %s, %d\r\n", restaurant.getId(), restaurant.getNumberOfTables()));
        restaurantString.append("tables, " + "\r\n");

        for (Table table : restaurant.getTables()) {
            String tableCSV = table.getTableNo() + ", " + table.getSeats() + ", ";

            for (String date : table.getAvailability().keySet()) {
                restaurantString.append(tableCSV + date + ", " + table.getAvailability().get(date) + "\r\n");
            }
        }

        restaurantString.append("waiters\r\n");

        for (Waiter waiter : restaurant.getWaiters()) {
            restaurantString.append(waiter.toCSV());
        }

        restaurantString.append("chef\r\n");

        for (Chef chef : restaurant.getChefs()) {
            restaurantString.append(chef.toCSV());
        }

        restaurantString.append("menu\r\n");

        for (var category: restaurant.getMenu().getCategories()) {
            restaurantString.append(category + ", " + category.getName() + "\r\n");

            for (Food food: category.getFood()) {
                restaurantString.append(food.toCSV());
            }
        }


        writer.write(restaurantString.toString());

        writer.close();
    }
}
