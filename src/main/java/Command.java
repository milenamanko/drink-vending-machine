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
}
