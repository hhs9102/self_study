package com.self.lambda;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		
		Function<String, Integer> toInt = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				// TODO Auto-generated method stub
				return Integer.parseInt(t);
			}
		};
		
		Integer number = toInt.apply("100");
		System.out.println(number);
		
		Function<String, Integer> toInt2 = (final String value) -> {
			return Integer.parseInt(value);
		};
		System.out.println(toInt2.apply("200"));
		
		
		Function<String, Integer> toInt3 = (value) -> Integer.parseInt(value);
		System.out.println(toInt3.apply("300"));
		
		Function<Integer, Integer> identity = t -> t;
		System.out.println(identity.apply(999));
	}

}
