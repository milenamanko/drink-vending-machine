package payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Payment {

    static List<Coin> coins = MoneyInitializer.getCoins();
    static List<Coin> changeCoins = new ArrayList<>();
    static BigDecimal change;
    static List<CoinType> coinTypes = CoinType.getAllSortedCoinTypes();


    public static void giveChange(BigDecimal drinkPrice, BigDecimal value) {
        change = value.subtract(drinkPrice);

        for (CoinType cT : coinTypes) {
            getChangeCoins(cT);
        }

        System.out.println("Change: ");

        for (Coin c : changeCoins) {
            System.out.println(c.getCoinType().getValue());
        }
        changeCoins.clear();
    }

    private static void getChangeCoins(CoinType coinType) {

        int multiplier;

        if (change.compareTo(coinType.getValue()) >= 0) {
            multiplier = change.divideToIntegralValue(coinType.getValue()).intValue();
            for (int i = 0; i < multiplier; i++) {
                coins.stream()
                        .filter(coin -> coin.getCoinType() == coinType)
                        .findAny()
                        .ifPresent(coin -> {
                            coins.remove(coin);
                            changeCoins.add(new Coin(coinType));
                            change = change.subtract(coinType.getValue());
                        });
            }
        }
    }
}

