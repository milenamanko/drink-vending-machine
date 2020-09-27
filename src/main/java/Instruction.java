import payment.Coin;
import payment.CoinType;
import payment.MoneyInitializer;
import payment.Payment;
import products.Product;
import products.ProductProvider;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Instruction {

    public static void checkAvailableProducts() {

        List<Product> products = ProductProvider.getProducts();

        products.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(product -> System.out.println(product.getName() + " - price: " + product.getPrice()));
    }

    public static void buyDrink(String drinkName) {

        Product drink = ProductProvider.getProductByName(drinkName);
        List<Product> products = ProductProvider.getProducts();
        List<Coin> coins = MoneyInitializer.getCoins();
        List<Coin> tempCoins = new ArrayList<>();

        if (drink.getName() == null) {
            System.out.println("Please specify correct drink name");
        } else if (!products.contains(drink)) {
            System.out.println("Drink is currently not available");
        } else {
            System.out.println("Chosen drink: " + drink.getName() + " - please insert " + drink.getPrice());

            Scanner scanner = new Scanner(System.in);
            BigDecimal value = new BigDecimal(0);

            while (drink.getPrice().compareTo(value) > 0) {

                String input = scanner.nextLine();

                value = value.add(new BigDecimal(input));

                tempCoins.add(new Coin(CoinType.getCoinTypeByValue(new BigDecimal(input))));

                System.out.println("Money inserted: " + value);
                if (coins.isEmpty()) {
                    if (drink.getPrice().compareTo(value) < 0) {
                        System.out.println("The machine currently doesn't have the change. Please pay with exact amount.");
                        tempCoins.clear();
                        value = BigDecimal.valueOf(0);
                    }
                }

                if (drink.getPrice().equals(value)) {
                    coins.addAll(tempCoins);
                    System.out.println("Drink bought: " + drink.getName());
                    products.remove(drink);
                }

                if (drink.getPrice().compareTo(value) < 0) {
                    Payment.giveChange(drink.getPrice(), value);

                    System.out.println("Drink bought: " + drink.getName());
                    products.remove(drink);
                }
            }
        }
    }
}
