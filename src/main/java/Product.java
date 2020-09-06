
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Product {

    private String name;
    private int currentAmount;
    private int maxAmount;
    private BigDecimal price;
}
