import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductProvider {

    private static final List<Product> products = new ArrayList<>();

    public static List<Product> getProducts() {
        return products;
    }

    public static void initializeProducts() {

        Random random = new Random();

        products.add(new Product("Sprite", random.nextInt(21), 20, new BigDecimal("2.9")));
        products.add(new Product("Cola", random.nextInt(21), 20, new BigDecimal("2.9")));
        products.add(new Product("Fanta", random.nextInt(21), 20, new BigDecimal("2.9")));
        products.add(new Product("Still Water", random.nextInt(11), 10, new BigDecimal("1.8")));
        products.add(new Product("Sprinkled Water", random.nextInt(11), 10, new BigDecimal("1.7")));
        products.add(new Product("Orange Juice", random.nextInt(16), 15, new BigDecimal("4")));

    }
}
