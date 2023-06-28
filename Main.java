import java.util.*;
import java.io.*;

public class Main {
    private static Map<String, Integer> inventory = new TreeMap<String, Integer>();
    private static List<CoffeeOrder> orders = new ArrayList<CoffeeOrder>();
    private static String logFile = "OrderLog.txt";

    private static String inventoryFile = "src\\Inventory.txt";

    public static void main(String[] args) {
        System.out.println("Welcome to Java Coffee Co.!");
        inventory = readInventory(inventoryFile);

        try (Scanner input = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\nMAIN MENU");
                System.out.println("1 - New Order");
                System.out.println("2 - Reload Inventory");
                System.out.println("3 - Update Inventory");
                System.out.println("4 - Update Order Log");
                System.out.println("5 - View Statistics");
                System.out.println("6 - Exit");

                int select = 0;
                while (select < 1 || select > 6) {
                    if (!input.hasNextInt()) {
                        System.out.println("Error. Invalid Number.");
                        input.nextLine();
                    } else {
                        select = input.nextInt();
                        if (select < 1 || select > 6) {
                            System.out.println("Error. Invalid option.");
                        }
                    }
                }

                input.nextLine();

                switch (select) {
                    case 1:
                        ;
                        CoffeeOrder order = buildOrder();
                        orders.add(order);
                        System.out.println(order.printOrder());
                        break;
                    case 2:
                        System.out.println("\nCurrent Inventory:");
                        System.out.println(inventory);
                        printInventory();
                        break;
                    case 3:
                        System.out.println("\nEnter ingredient:");
                        String ingredient = input.nextLine();
                        if (isInInventory(ingredient)) {
                            System.out.println("\nIngredient in inventory.");
                        } else {
                            System.out.println("\nIngredient not in inventory.");
                        }
                        writeInventory(inventoryFile);
                        System.out.println("\nInventory updated.");
                        break;
                    case 4:
                        writeOrderLog(logFile);
                        System.out.println("\nOrder log updated.");
                        break;
                    case 5:
                        System.out.println("\nStatistics:");
                        printStatistics();
                        break;
                    case 6:
                        System.out.println("Thank you for visiting Java Coffee Co.");
                        exit = true;
                        break;
                }
            }



        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        //if (!orders.size() > 0) {
        if (!orders.isEmpty()) {
            writeOrderLog(logFile);
        }
        writeInventory(inventoryFile);
    }


    private static CoffeeOrder buildOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your phone number for MyBeanRewards or ENTER to skip:");
        String memberID = scanner.nextLine();

        if (memberID.length() != 10 ) {
            System.out.println("No account found");
        } else {
            System.out.println("Welcome MEMBER " + memberID + "!");
        }

        CoffeeOrder order = new CoffeeOrder();
        order.getMemberID(memberID);
        try {
            Scanner input = new Scanner(System.in);
            boolean addCoffee = true;
            while (addCoffee) {
                // prompt user to select base coffee type
                System.out.println("Select coffee type:");
                System.out.println("\t1. Black Coffee");
                System.out.println("\t2. Espresso");
                Coffee coffee;

                int option = 0;
                while (option < 1 || option > 2) {
                    if (!input.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        input.nextLine();
                    } else {
                        option = input.nextInt();
                        if (option < 1 || option > 2) System.out.println("Please enter a valid option.");
                    }
                }
                input.nextLine(); // nextInt() doesn't consume newline
                if (option == 2) {
                    // Espresso is a specific case
                    coffee = new Espresso();
                } else {
                    if (!isInInventory("Black Coffee")) {
                        System.out.println("Sorry, no Black Coffee in stock.");
                        continue;
                    }
                    // make BlackCoffee the default case
                    coffee = new BlackCoffee();
                    inventory.put("Black Coffee", inventory.get("Black Coffee") - 1);
                }

                // prompt user for any customizations
                while (option != 0) {
                    System.out.println(String.format("Coffee brewing: %s.", coffee.printCoffee()));
                    System.out.println("Would you like to add anything to your coffee?");
                    System.out.println("\t1. Flavored Syrup");
                    System.out.println("\t2. Hot Water");
                    System.out.println("\t3. Milk Options");
                    System.out.println("\t4. Sugar Options");
                    System.out.println("\t5. Whipped Cream and Other Toppings");
                    System.out.println("\t0. NO - Finish Coffee");

                    while (!input.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        input.nextLine();
                    }
                    option = input.nextInt();
                    input.nextLine();
                    coffee = switch (option) {
                        case 1 -> {
                            System.out.println("Please select a flavor:");
                            for (WithFlavor.Syrup flavor : WithFlavor.Syrup.values()) {
                                System.out.println("\t" + String.format("%d. %s", flavor.ordinal() + 1, flavor));
                            }
                            int max = WithFlavor.Syrup.values().length;
                            option = 0;
                            while (option < 1 || option > max) {
                                if (!input.hasNextInt()) {
                                    System.out.println("Please enter a valid number.");
                                    input.nextLine();
                                } else {
                                    option = input.nextInt();
                                    if (option < 1 || option > max) System.out.println("Please enter a valid option.");
                                }
                            }
                            input.nextLine();
                            WithFlavor.Syrup flavor = WithFlavor.Syrup.values()[option - 1];
                            option = 1;
                            yield new WithFlavor(coffee, flavor);
                        }
                        case 2 -> new WithHotWater(coffee);
                        case 3 -> {
                        System.out.println("Please select a milk:");
                        for (WithMilk.Milk cream : WithMilk.Milk.values()) {
                            System.out.println("\t" + String.format("%d. %s", cream.ordinal() + 1, cream));
                        }
                        int max = WithMilk.Milk.values().length;
                        option = 0;
                        while (option < 1 || option > max) {
                            if (!input.hasNextInt()) {
                                System.out.println("Please enter a valid number.");
                                input.nextLine();
                            } else {
                                option = input.nextInt();
                                if (option < 1 || option > max) System.out.println("Please enter a valid option.");
                            }
                        }
                        input.nextLine();
                        WithMilk.Milk cream = WithMilk.Milk.values()[option - 1];
                        option = 1;
                        yield new WithMilk(coffee, cream);
                    }
                        case 4 -> {
                            System.out.println("Please select a sweetener:");
                            for (WithSugar.Sugar sweet : WithSugar.Sugar.values()) {
                                System.out.println("\t" + String.format("%d. %s", sweet.ordinal() + 1, sweet));
                            }
                            int max = WithSugar.Sugar.values().length;
                            option = 0;
                            while (option < 1 || option > max) {
                                if (!input.hasNextInt()) {
                                    System.out.println("Please enter a valid number.");
                                    input.nextLine();
                                } else {
                                    option = input.nextInt();
                                    if (option < 1 || option > max) System.out.println("Please enter a valid option.");
                                }
                            }
                            input.nextLine();
                            WithSugar.Sugar sweet = WithSugar.Sugar.values()[option - 1];
                            option = 1;
                            yield new WithSugar(coffee, sweet);
                        }
                        case 5 -> {
                            System.out.println("Please select a topping:");
                            for (WithWhippedCream.WhipCream topper : WithWhippedCream.WhipCream.values()) {
                                System.out.println("\t" + String.format("%d. %s", topper.ordinal() + 1, topper));
                            }
                            int max = WithWhippedCream.WhipCream.values().length;
                            option = 0;
                            while (option < 1 || option > max) {
                                if (!input.hasNextInt()) {
                                    System.out.println("Please enter a valid number.");
                                    input.nextLine();
                                } else {
                                    option = input.nextInt();
                                    if (option < 1 || option > max) System.out.println("Please enter a valid option.");
                                }
                            }
                            input.nextLine();
                            WithWhippedCream.WhipCream topper = WithWhippedCream.WhipCream.values()[option - 1];
                            option = 1;
                            yield new WithWhippedCream(coffee, topper);
                        }
                        default -> {
                            if (option != 0) System.out.println("Please enter valid option.");
                            yield coffee;
                        }
                    };
                }
                order.addCoffee(coffee);

                System.out.println("Would you like to order another coffee (Y or N)?");
                String yn = input.nextLine();
                while (!(yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y"))) {
                    System.out.println("Please enter Y or N.");
                    yn = input.nextLine();
                }
                addCoffee = !yn.equalsIgnoreCase("N");
            }
        } catch (Exception e) {
            System.out.println("Error building order: " + e.getMessage());
        }

        if (memberID != null && !memberID.isEmpty()) {
            order.calcMyBeanPoints();
        }
        return order;
    }

    private static Map<String, Integer> readInventory(String inventoryFile) {
        Map<String, Integer> inventory = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inventoryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] part = line.split("=");
                if (part.length == 2) {
                    String ingredient = part[0].trim();
                    int quantity = Integer.parseInt(part[1].trim());
                    inventory.put(ingredient, quantity);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return inventory;
    }

    private static void writeInventory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, Integer> SELECT : inventory.entrySet()) {
                String ingredient = SELECT.getKey();
                int quantity = SELECT.getValue();
                writer.write(ingredient + " = " + quantity);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printInventory() {
        for (Map.Entry<String, Integer> SELECT : inventory.entrySet()) {
            String ingredient = SELECT.getKey();
            int quantity = SELECT.getValue();
            System.out.println(ingredient + " = " + quantity);
        }
    }

    private static void writeOrderLog(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (CoffeeOrder order : orders) {
                writer.write(order.printOrder());
                writer.newLine();
            }
            orders.clear();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean isInInventory(String ingredient) {
        return inventory.containsKey(ingredient) && inventory.get(ingredient) > 0;
    }

    private static void updateOrderLog() {
        writeOrderLog(logFile);
        System.out.println("Order log updated.");
    }

    private static void MyBeanRewards( ) {
        System.out.println("Enter your phone number:");
        Scanner scanner = new Scanner(System.in);
        String memberID = scanner.nextLine();


        int MyBeanPoints = getPoints(memberID);
        System.out.println("Your points: " + MyBeanPoints);
    }

    private static int getPoints(String MyBeanPoints) {
        return MyBeanPoints.length();
    }

    private static void printStatistics() {
        Statistics statistics = new Statistics(orders);

        double totalSales = statistics.getTotal();

        System.out.println("Total sales: $" + totalSales);
        System.out.println("Average cost per order: $" + statistics.getAvgCost());

    }
}
