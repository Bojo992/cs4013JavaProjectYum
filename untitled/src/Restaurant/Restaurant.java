package Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Food> menu;

    public Restaurant() {
        menu = new ArrayList<>();
    }

    public List<Food> getMenu() {
        return menu;
    }
}
