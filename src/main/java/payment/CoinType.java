package payment;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CoinType {

    C10(new BigDecimal("0.1")),
    C20(new BigDecimal("0.2")),
    C50(new BigDecimal("0.5")),
    C1(new BigDecimal("1.0")),
    C2(new BigDecimal("2.0")),
    C5(new BigDecimal("5.0"));

    private final BigDecimal value;

    CoinType(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static List<CoinType> getAllSortedCoinTypes() {
        return Arrays.stream(CoinType.values())
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());
    }

    public static CoinType getCoinTypeByValue(BigDecimal input) {
        return Arrays.stream(CoinType.values())
                .filter(coinType -> input.equals(coinType.getValue()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Please pay with existing value"));
    }
}
