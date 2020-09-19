package payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import products.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
public class MoneyInitializer {

    private static final List<Coin> coins = new ArrayList<>();

    public static List<Coin> getCoins() {
        return coins;
    }

    public static void initializeMoney() {

        Random random = new Random();

        Arrays.stream(CoinType.values()).forEach(coinType -> {
            for (int i = 0; i < random.nextInt(16); i++) {
                coins.add(new Coin(coinType));
            }
        });
    }
}
