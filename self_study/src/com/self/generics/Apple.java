package com.self.generics;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Apple extends Fruit{
	private final String name;
	
	@Override
	public boolean isEatble() {
		return true;
	}
}
