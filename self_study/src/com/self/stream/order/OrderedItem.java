package com.self.stream.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderedItem {
	long id;
	Product product;
	int quantity;
	
	public BigDecimal getItemTotal() {
		return product.getPrice().multiply(new BigDecimal(quantity));
	}
}
