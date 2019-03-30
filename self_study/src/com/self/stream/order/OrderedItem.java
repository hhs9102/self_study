package com.self.stream.order;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

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
