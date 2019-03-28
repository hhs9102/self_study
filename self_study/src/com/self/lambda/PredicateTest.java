package com.self.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(-3,-2,-1,0,1,2,3,4,5,6,7);
		Predicate<Integer> isPositive = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t > 0;
			}
		};
		Predicate<Integer> isNagative = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t < 0;
			}
		};
		System.out.println("Positivie Numbers : "+ isPositive.test(3));	//true
		System.out.println("Nagative Numbers : "+ isNagative.test(3));	//false
		
		
		System.out.println("===============================");
		List<Integer> greaterThan3List = new ArrayList<Integer>();
		for(Integer i : numbers) {
			if(i>3) {
				greaterThan3List.add(i);
			}
		}
		System.out.println("greater than 3");
		System.out.println(greaterThan3List);	//[4, 5, 6, 7]
		
		List<Integer> lessThan3List = new ArrayList<Integer>();
		for(Integer i : numbers) {
			if(i<3) {
				lessThan3List.add(i);			//[-3, -2, -1, 0, 1, 2]
			}
		}
		System.out.println("less than 3");
		System.out.println(lessThan3List);
		
		System.out.println("JAVA8==========================");
		System.out.println("greater than 3");
		System.out.println(filter(numbers, i -> i > 3));	//[4, 5, 6, 7]
		System.out.println("less than 3");
		System.out.println(filter(numbers, i -> i < 3));	//[-3, -2, -1, 0, 1, 2]
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> filter){
		List<T> result = new ArrayList<T>();
		for(T input : list) {
			if(filter.test(input)) {
				result.add(input);
			}
		}
		return result;
	}

}
