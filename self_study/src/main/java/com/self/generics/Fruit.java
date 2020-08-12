package com.self.generics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit implements Eatable{
	private String name;
	
	public boolean isEatble() {
		return true;
	}
}
