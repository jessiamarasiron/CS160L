import java.util.List;
public class WithFlavor extends CoffeeDecorator{
    private Syrup flavor;

    public enum Syrup {
        Caramel,
        Mocha,
        Vanilla,
        Hazelnut,
        Peppermint,
        IrishCreme,
        Pumpkin,
    }

    public WithFlavor(Coffee c, Syrup s) {
        super(c);
        flavor = s;
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.35;

    }

    @Override
    public List<String> getIngredients() {
        List<String> getingredients = super.getIngredients();
        getingredients.add(flavor.toString() + " Syrup");
        return getingredients;
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with " + flavor.toString() + " flavor";

    }
}

