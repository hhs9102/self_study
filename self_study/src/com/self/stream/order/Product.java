package com.self.stream.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {
	long id;
	String name;
	BigDecimal price;
}
