package com.self.stream.order1006;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Optional;

@Builder
public class Item {
    private long id;
    private String name;
    private BigDecimal price;
    private int quantity;

    public BigDecimal getTotalPrice(){
//        return Optional.ofNullable(price.multiply(new BigDecimal(quantity))).orElse(BigDecimal.ZERO);
        return Optional.ofNullable(price).orElseThrow(()-> new IllegalArgumentException("Price가 없다. 그럼 안되지.")).multiply(new BigDecimal(quantity));
    }
}
