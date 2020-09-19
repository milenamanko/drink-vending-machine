package products;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Product {

    private String name;
    private BigDecimal price;

}
