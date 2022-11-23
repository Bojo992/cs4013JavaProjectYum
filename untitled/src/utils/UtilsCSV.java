package utils;

import People.Chef;
import People.Waiter;
import Restaurant.Food;
import Restaurant.Restaurant;

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

    public ArrayList<Restaurant> readRestaurants() throws FileNotFoundException {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        File restaurantsCSV = new File("restaurant.csv");

        if (!restaurantsCSV.exists()) {
            return null;
        }

        boolean skip = true;

        Scanner in = new Scanner(restaurantsCSV);

        while (in.hasNextLine()) {
            String line = in. nextLine();
            String restaurantId = line.split(", ")[1];
            int numberOfTables = Integer.parseInt(line.split(", ")[2]);

            Restaurant restaurant = new Restaurant(numberOfTables);
            restaurant.setId(restaurantId);

            line = in.nextLine();
            line = in.nextLine();

            while (!line.equals("waiters")) {
                String[] lineArray = line.split(", ");
                String tableSignature = lineArray[0] + ", " + lineArray[1];

                HashMap<String, Boolean> reservations = new HashMap<>();

                while (line.contains(tableSignature)) {
                    lineArray = line.split(", ");

                    reservations.put(lineArray[2], (lineArray[3].equals("true") ? true : false));

                    line = in.nextLine();
                }

                lineArray = tableSignature.split(", ");

                Table temp = new Table(Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1]));

                temp.setAvailability(reservations);

                restaurant.addTable(temp);

                line = in.nextLine();
            }

            line = in.nextLine();

            while (!line.equals("chef")) {
                String[] lineArray = line.split(", ");

                var waiter = new Waiter(lineArray[0], lineArray[1], lineArray[2]);

                restaurant.addWaiter(waiter, lineArray[4]);

                waiter.setId(lineArray[3]);

                line = in.nextLine();
            }

            line = in.nextLine();

            while (!line.equals("menu")) {
                String[] lineArray = line.split(", ");

                var chef = new Chef(lineArray[0], lineArray[1], lineArray[2]);

                restaurant.addChef(chef, lineArray[4]);

                chef.setId(lineArray[3]);

                line = in.nextLine();
            }

            if (in.hasNextLine()) {
                line = in.nextLine();
            } else {
                skip = false;
            }

            Menu menu = new Menu();

            while(in.hasNextLine() && !line.contains("restaurant, ") && skip) {
                String[] lineArray = line.split(", ");
                String category = lineArray[1];

                menu.addCategory(category);

                while (!line.contains("category, ")) {
                    line = in.nextLine();
                    lineArray = line.split(", ");
                    Food food = new Food(lineArray[0], Double.parseDouble(lineArray[1]));

                    menu.addFood(food, category);
                }

                line = in.nextLine();
            }

            restaurant.setMenu(menu);

            restaurants.add(restaurant);
        }


        return restaurants;
    }
}
