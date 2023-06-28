import java.util.ArrayList;
import java.util.List;

public class Espresso implements Coffee {
    @Override
    public double getCost() {
        return 1.75;

    }

    @Override
    public List<String> getIngredients() {
        List<String> getingredients = new ArrayList<>();
        getingredients.add("Espresso");
        return getingredients;
    }

    @Override
    public String printCoffee() {
        return "An espresso";

    }
}
