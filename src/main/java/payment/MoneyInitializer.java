package payment;

import lombok.Getter;

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
