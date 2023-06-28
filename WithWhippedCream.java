import java.util.List;
public class WithWhippedCream extends CoffeeDecorator {

    private WhipCream topper;

    public enum WhipCream {
        ColdFoam,
        Sprinkles,
        WhippedCream,
        Drizzle,
        Cookies,
        CocoaPowder,
        CinnaPowder,
    }

    public WithWhippedCream(Coffee c, WhipCream w) {
        super(c);
        topper = w;
    }


    @Override
    public double getCost() {
        return super.getCost() + 0.25;

    }

    @Override
    public List<String> getIngredients() {
        List<String> getingredients = super.getIngredients();
        getingredients.add(topper.toString());
        return getingredients;
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with " + topper.toString();
    }
}

