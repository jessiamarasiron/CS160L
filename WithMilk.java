import java.util.List;

public class WithMilk extends CoffeeDecorator {

    private Milk cream;

    public enum Milk {
        Whole,
        Nonfat,
        Oat,
        Almond,
        Soy,
        HalfNHalf,
        TwoPercent,

    }

    public WithMilk(Coffee c, Milk m) {
        super(c);
        cream = m;

    }

    @Override
    public double getCost() {
        return super.getCost() +  0.55;

    }

    @Override
    public List<String> getIngredients() {
        List<String> getingredients = super.getIngredients();
        getingredients.add(cream.toString() + " Milk");
        return getingredients;
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with " + cream.toString()  + " milk";
    }
}

