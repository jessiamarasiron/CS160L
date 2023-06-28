import java.util.*;
public class BlackCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.00;

    }

    @Override
    public List<String> getIngredients() {
        List<String> getingredients = new ArrayList<>();
        getingredients.add("Coffee");
        return getingredients;
    }

    @Override
    public String printCoffee() {
        return "A black coffee";

    }
}



