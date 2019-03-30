package com.self.stream.order;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
	long id;
	String orderName;
	List<OrderedItem> orderedItems;
	
	public BigDecimal getTotalPrice() {
		return orderedItems.stream()
						   .map(item -> item.getItemTotal())
						   .reduce(BigDecimal.ZERO, (orderedItem1, orderedItem2) -> orderedItem1.add(orderedItem2));
	}
}
