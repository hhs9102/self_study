package com.self.stream.order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderTest {

	public static void main(String[] args) {
		final List<Product> products = Arrays.asList(
				new Product(1L, "A", new BigDecimal("3000"))
				,new Product(2L, "B", new BigDecimal("750"))
				,new Product(3L, "C", new BigDecimal("13000"))
				,new Product(4L, "D", new BigDecimal("15000"))
				,new Product(5L, "E", new BigDecimal("1199900"))
				);
		
		//Product중에 10000원이 넘는 Product
		List<Product> greaterThan10000 = products.stream()
												  .filter(p -> p.getPrice()
												  .compareTo(new BigDecimal("10000"))>0)
												  .collect(Collectors.toList());
		System.out.println(greaterThan10000);
		System.out.println("greaterThan10000 Product Names : "
				+ greaterThan10000.stream()
								  .map(p -> p.getName())
								  .collect(Collectors.joining(","))
	    );
		System.out.println("===================================");
		
		OrderedItem orderedItem1 = new OrderedItem(1L, greaterThan10000.get(0), 14);
		OrderedItem orderedItem2 = new OrderedItem(1L, greaterThan10000.get(1), 5);
		OrderedItem orderedItem3 = new OrderedItem(1L, greaterThan10000.get(2), 1);
		
		Order order = new Order(1L, "order", Arrays.asList(orderedItem1, orderedItem2, orderedItem3));
		
		System.out.println("total Order Price : ");
		System.out.println(order.getTotalPrice());
	}

}
