import java.util.List;

public class Command {

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
        }
    }
}
