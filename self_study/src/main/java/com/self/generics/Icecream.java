package com.self.generics;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Icecream implements Eatable {
	private final String name;
	@Override
	public boolean isEatble() {
		return true;
	}
}
