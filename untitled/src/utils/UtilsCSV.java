package utils;

import People.Chef;
import People.Customer;
import People.Waiter;
import Restaurant.*;
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

/**
 * The Utils csv class
 */
public class UtilsCSV {
    /**
     * Read food from csv list.
     * @param filename the filename
     * @return the list
     */
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

    /**
     * Read restaurants array list.
     * @return the array list
     * @throws FileNotFoundException the file not found exception
     */
    public ArrayList<Restaurant> readRestaurants() throws FileNotFoundException {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        File restaurantsCSV = new File("restaurant.csv");

        if (!restaurantsCSV.exists()) {
            return null;
        }

        Scanner in = new Scanner(restaurantsCSV);
        String line = "";

        if (!in.hasNextLine()) {
            return null;
        }

        while (in.hasNextLine()) {
            if (!line.contains("restaurant, ")) {
                line = in.nextLine();
            }
            String restaurantId = line.split(", ")[1];
            int numberOfTables = Integer.parseInt(line.split(", ")[2]);

            Restaurant restaurant = new Restaurant(numberOfTables);
            restaurant.setId(restaurantId);

            line = in.nextLine();
            line = in.nextLine();

            while (!line.equals("waiters")) {
                String[] lineArray = line.split(", ");
                String tableSignature = lineArray[0] + ", " + lineArray[1];
                line = in.nextLine();

                Table temp = new Table(Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1]));

                restaurant.addTable(temp);
            }

            line = in.nextLine();

            while (!line.equals("chef")) {
                String[] lineArray = line.split(", ");

                var waiter = new Waiter(lineArray[0], lineArray[1], lineArray[2]);

                restaurant.addEmployee(waiter, lineArray[4]);

                waiter.setId(lineArray[3]);

                line = in.nextLine();
            }

            line = in.nextLine();

            while (!line.equals("orders")) {
                String[] lineArray = line.split(", ");

                var chef = new Chef(lineArray[0], lineArray[1], lineArray[2]);

                restaurant.addEmployee(chef, lineArray[4]);

                chef.setId(lineArray[3]);

                line = in.nextLine();
            }

            line = in.nextLine();

            while (!line.equals("menu")) {
                String[] lineArray = line.split(", ");
                int tableNumber = Integer.parseInt(lineArray[1]);
                String orderSignature = lineArray[0] + ", " + lineArray[1];

                Table table = new Table(0, 0);
                for (Table t: restaurant.getTables()) {
                    if (t.getTableNo() == tableNumber) {
                        table = t;
                        break;
                    }
                }

                Order order = new Order(table);
                order.setStatus(lineArray[0]);

                while (line.contains(orderSignature)) {
                    lineArray = line.split(", ");

                    Food food = new Food(lineArray[2], Double.parseDouble(lineArray[3]));

                    order.addFood(food);
                    line = in.nextLine();
                }

                restaurant.addOrder(order);
            }

            line = in.nextLine();
            Menu menu = new Menu();

            while(in.hasNextLine() && !line.contains("restaurant, ")) {
                String[] lineArray = line.split(", ");
                String category = lineArray[1];

                menu.addCategory(category);

                line = in.nextLine();


                while (!line.split(", ")[0].equals("category") && !line.split(", ")[0].equals("restaurant")) {
                    lineArray = line.split(", ");
                    Food food = new Food(lineArray[0], Double.parseDouble(lineArray[1]));
                    menu.addFood(food, category);

                    if (!in.hasNextLine()) {
                        break;
                    }

                    line = in.nextLine();
                }
            }

            restaurant.setMenu(menu);

            restaurants.add(restaurant);
        }


        return restaurants;
    }

    /**
     * Read customers array list.
     * @return the array list
     * @throws FileNotFoundException the file not found exception
     */
    public ArrayList<Customer> readCustomers() throws FileNotFoundException {
        ArrayList<Customer> customers = new ArrayList<>();

        File customerCSV = new File("customers.csv");

        if (!customerCSV.exists()) {
            return null;
        }

        Scanner in = new Scanner(customerCSV);
        String line = "";

        if (!in.hasNextLine()) {
            return null;
        }

        line = in.nextLine();

        do {
            String[] lineArray = line.split(", ");
            String customerSignature = lineArray[0] + ", " +
                    lineArray[1] + ", " +
                    lineArray[2] + ", " +
                    lineArray[3] + ", ";

            Customer customer;

            if (lineArray[1].equals("null")) {
                customer = new Customer(lineArray[0]);
            } else {
                customer = new Customer(lineArray[0], lineArray[1]);
            }

            customer.setId(lineArray[2]);
            customer.setPassword(lineArray[3]);

            customers.add(customer);

            while (line.contains(customerSignature) && in.hasNextLine()) {
                if (!lineArray[4].equals("null")) {
                    Restaurant restaurant = DataStorage.getAllRestaurants().get(Integer.parseInt(lineArray[6]));

                    Reservation reservation = new Reservation(customer,
                            lineArray[4],
                            restaurant.getTables().get(Integer.parseInt(lineArray[5])),
                            restaurant,
                            Integer.parseInt(lineArray[7]));

                    customer.addReservation(reservation);
                }
                line = in.nextLine();
                lineArray = line.split(", ");
            }

            if (!in.hasNextLine()) {
                if (lineArray[1].equals("null")) {
                    customer = new Customer(lineArray[0]);
                } else {
                    customer = new Customer(lineArray[0], lineArray[1]);
                }

                customer.setId(lineArray[2]);
                customer.setPassword(lineArray[3]);
                customers.add(customer);

                if (!lineArray[4].equals("null")) {
                    Restaurant restaurant = DataStorage.getAllRestaurants().get(Integer.parseInt(lineArray[6]));

                    Reservation reservation = new Reservation(customer,
                            lineArray[4],
                            restaurant.getTables().get(Integer.parseInt(lineArray[5])),
                            restaurant,
                            Integer.parseInt(lineArray[7]));

                    customer.addReservation(reservation);
                }
            }
        } while (in.hasNextLine());

        return customers;
    }

    /**
     * Wright customers.
     * @param allCustomers the all customers
     */
    public void wrightCustomers(ArrayList<Customer> allCustomers) {
        File clear = new File("customers.csv");
        try {
            FileWriter writer = new FileWriter(clear);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Customer customer: allCustomers) {
            try {
                writeCustomer(customer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Write restaurants.
     * @param allRestaurants the all restaurants
     */
    public void writeRestaurants(ArrayList<Restaurant> allRestaurants) {
        File clear = new File("restaurant.csv");
        try {
            FileWriter writer = new FileWriter(clear);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Restaurant restaurant: allRestaurants) {
            try {
                writeRestaurant(restaurant);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeRestaurant(Restaurant restaurant) throws IOException {
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

            restaurantString.append(tableCSV + "\r\n");
        }

        restaurantString.append("waiters\r\n");

        for (Waiter waiter : restaurant.getWaiters()) {
            restaurantString.append(waiter.toCSV());
        }

        restaurantString.append("chef\r\n");

        for (Chef chef : restaurant.getChefs()) {
            restaurantString.append(chef.toCSV());
        }

        restaurantString.append("orders\r\n");

        for (Order order: restaurant.getOrders()) {
            String orderSignature = order.getStatus() + ", " + order.getTableOrder().getTableNo() + ", ";

            for (Food food: order.getTableFood()) {
                restaurantString.append(orderSignature + food.toCSV());
            }
        }

        restaurantString.append("menu\r\n");

        for (var category: restaurant.getMenu().getCategories()) {
            restaurantString.append("category, " + category.getName() + "\r\n");

            for (Food food: category.getFood()) {
                restaurantString.append(food.toCSV());
            }
        }


        writer.write(restaurantString.toString());

        writer.close();
    }

    private void writeCustomer(Customer customer) throws IOException {
        File customerCSV = new File("customers.csv");
        FileWriter writer;

        if (customerCSV.exists() && customerCSV.canWrite()) {
            writer = new FileWriter(customerCSV, true);
        } else {
            writer = new FileWriter(customerCSV);
        }

        StringBuilder customerString = new StringBuilder();
        String customerSignature = customer.getName() + ", " +
                customer.getPhone() + ", " +
                customer.getId() + ", " +
                customer.getPassword() + ", ";

        if (customer.getReservations().isEmpty()) {
            customerString.append(customerSignature + "null\r\n");
        }

        for (Reservation reservation: customer.getReservations()) {
            customerString.append(customerSignature + reservation.toCSV() + "\r\n");
        }

        writer.write(customerString.toString());
        writer.close();
    }
}
