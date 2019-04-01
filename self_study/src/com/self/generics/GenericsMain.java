package com.self.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericsMain {
	
	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(new Apple("apple1"), new Apple("apple2"));
		List<Grape> grapes = Arrays.asList(new Grape("grape1"), new Grape("grape2"));
		List<Icecream> icecreams = Arrays.asList(new Icecream("icecream1"), new Icecream("icecream2"));
		List<Chair> chairs = Arrays.asList(new Chair("chair1"), new Chair("chair1"));
		List<Chicken> chickens = Arrays.asList(new Chicken("chicken1"));
		List<Fruit> fruits = apples.stream()
								   .map(apple -> (Fruit)apple)
								   .filter(i -> i.isEatble())
								   .collect(Collectors.toList());
		grapes.stream()
			  .forEach(grape -> {
				  fruits.add((Fruit)grape);
			  });
		
		//fruits.add(chairs.get(0));  The method add(Fruit) in the type List<Fruit> is not applicable for the arguments (Chair)
		System.out.println("Fruits에 담긴 list : ");
		System.out.println(fruits);
		System.out.println();
		
		Box<Fruit> fruitBox = new Box<Fruit>("fruitBox");
		fruits.stream()
			  .forEach(fruit -> {
				  fruitBox.addBox(fruit);
			  });
		
		System.out.println("fruitBox에 담긴 list : ");
		System.out.println(fruitBox.getList());
		
		Box<Chicken> chickenBox = new Box<Chicken>("chickenBox");
		chickens.stream()
				.forEach(chicken -> chickenBox.addBox(chicken));

		List<Box<? super Fruit>> fruitBoxes = new ArrayList<Box<? super Fruit>>();
		List<Box<? extends Chicken>> foodBoxes = new ArrayList<Box<? extends Chicken>>();
		Truck truck = new Truck(fruitBoxes, foodBoxes);
		truck.addFruitBox(fruitBox);
		truck.addFoodBox(chickenBox);
		
		System.out.println("fruitBoxes List : ");
		System.out.println(truck.getFruitBoxes());
		System.out.println("foodBoxes List : ");
		System.out.println(truck.getFoodBoxes());
	}

}
