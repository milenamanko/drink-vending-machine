package products;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
public class ProductProvider {

    private static final List<Product> products = new ArrayList<>();

    public static List<Product> getProducts() {
        return products;
    }

    public static void initializeProducts() {

        Random random = new Random();

        Arrays.stream(ProductNamePrice.values()).forEach(productNamePrice -> {
            for (int i = 0; i < random.nextInt(21); i++) {
                products.add(new Product(productNamePrice.name(), productNamePrice.getPrice()));
            }
        });
    }

    public static Product getProductByName (String drinkName) {

        for (Product product: products) {
            if (product.getName().replaceAll("_", " ").equalsIgnoreCase(drinkName))
                return product;
        }
        return new Product();
    }
}
