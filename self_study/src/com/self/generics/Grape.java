package com.self.generics;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Grape extends Fruit{
	private final String name;
}
