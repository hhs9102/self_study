package com.self.generics;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Truck {

	private final List<Box<? super Fruit>> fruitBoxes;
	private final List<Box<? extends Chicken>> foodBoxes;
	
	public void addFruitBox(Box<? super Fruit> box) {
		fruitBoxes.add(box);
		System.out.println("Fruit Box에 넣었습니다.");
	}
	public void addFoodBox(Box<? extends Chicken> box) {
		foodBoxes.add(box);
		System.out.println("Food Box에 넣었습니다.");
	}
}
