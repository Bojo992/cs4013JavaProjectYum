import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
}
