import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class CoffeeOrder {
    private List<Coffee> coffees;
    private LocalDateTime orderDate;
    private int MyBeanPoints;
    private String memberID;

    public CoffeeOrder() {
        coffees = new ArrayList<Coffee>();
        orderDate = LocalDateTime.now();
        memberID = " ";
        MyBeanPoints = 0;
    }

    public CoffeeOrder(LocalDateTime orderDate) {
        coffees = new ArrayList<Coffee>();
        this.orderDate = orderDate;
        memberID = " ";
        MyBeanPoints = 0;
    }

    public void getMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberID() {
        return memberID;
    }

    public int getMyBeanPoints() {
        return MyBeanPoints;
    }

    public void addCoffee(Coffee c) {
        coffees.add(c);

    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

   public LocalDateTime getOrderDate() {
       return orderDate;
   }

    public void calcMyBeanPoints() {
        double totalCost = getTotal();
        MyBeanPoints = (int) Math.floor(totalCost);
    }

    public double getTotal() {
        double total = 0;
        for (Coffee coffee : coffees) {
            total += coffee.getCost();
        }
        return total;
    }


    public String printOrder() {
        StringBuilder order = new StringBuilder("ORDER RECEIPT\n");
        order.append(String.format("Timestamp: %s%n", orderDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mma"))));
        for (int i = 0; i < coffees.size(); i++) {
            Coffee coffee = coffees.get(i);
            order.append(String.format("Item %d: %s - %.2f%n", i + 1, coffee.printCoffee(), coffee.getCost()));
        }
        order.append(String.format("TOTAL = %.2f%n", getTotal()));
        if (memberID != null && !memberID.isEmpty()) {
            order.append(String.format("Member Number: %s%n", memberID));
        }

        if (MyBeanPoints != 0 ) {
            order.append(String.format("MyBeanPoints Earned: %d%n", MyBeanPoints));
        }

        System.out.println("Thank you for visiting Java Coffee Co.");

        return order.toString();
    }
}
