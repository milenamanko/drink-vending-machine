package products;

import java.math.BigDecimal;

public enum ProductNamePrice {

    SPRITE(new BigDecimal("2.9")),
    COLA(new BigDecimal("2.9")),
    FANTA(new BigDecimal("2.9")),
    STILL_WATER(new BigDecimal("1.8")),
    SPRINKLED_WATER(new BigDecimal("1.9")),
    ORANGE_JUICE(new BigDecimal("4"));

    private final BigDecimal price;

    ProductNamePrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
