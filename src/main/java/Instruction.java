import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Instruction {

    public static void checkAvailableProducts() {

        List<Product> products = ProductProvider.getProducts();

        for (Product product : products) {
            if (product.getCurrentAmount() != 0) {
                System.out.println(product.getName() + " - price: " + product.getPrice());
            }
        }
    }

    public static void buyDrink(String drinkName) {

        Product drink = ProductProvider.getProductByName(drinkName);

        if (drink.getName() == null) {
            System.out.println("Please specify correct drink name");
        } else if (drink.getCurrentAmount() < 1) {
            System.out.println("Drink is currently not available");
        } else {
            System.out.println("Chosen drink: " + drink.getName() + " - please insert " + drink.getPrice());


            Scanner scanner = new Scanner(System.in);
            BigDecimal value = new BigDecimal(0);

            while (drink.getPrice().compareTo(value) > 0) {

                String input = scanner.nextLine();
                value = value.add(new BigDecimal(input));
                System.out.println("Money inserted: " + value);
                if (drink.getPrice().compareTo(value) < 0) {
                    System.out.println("The machine doesn't give change. Please pay with exact change.");
                    value = BigDecimal.valueOf(0);
                }
                if (drink.getPrice().equals(value)) {
                    System.out.println("Drink bought: " + drink.getName());
                    drink.setCurrentAmount(drink.getCurrentAmount() - 1);
                }
            }
        }
    }
}
