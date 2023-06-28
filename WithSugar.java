import java.util.List;

public class WithSugar extends CoffeeDecorator {
    private Sugar sweet;

    public enum Sugar {
        Sugar,
        Cane,
        Splenda,
        Brown,
    }
    public WithSugar(Coffee c, Sugar s) {
        super(c);
        sweet = s;
    }

    @Override
    public double getCost() {
       return super.getCost() + 0.15;

    }

    @Override
    public List<String> getIngredients() {
        List<String> getingredients = super.getIngredients();
        getingredients.add(sweet.toString());
        return getingredients;

    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with " + sweet.toString();
    }
}