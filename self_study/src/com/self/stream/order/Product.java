package com.self.stream.order;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	long id;
	String name;
	BigDecimal price;
}
