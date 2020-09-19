package payment;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Payment {

    public static BigDecimal pay() {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<BigDecimal> coinsList = Arrays.stream(input.split(","))
                .map(BigDecimal::new)
                .collect(Collectors.toList());

        BigDecimal value = new BigDecimal(0);

        for (BigDecimal coin: coinsList) {
            value = value.add(coin);
        }
        return value;
    }
}
