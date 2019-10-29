package com.self.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

		lengthPrint();
	}

	public static void lengthPrint(){
		List<Integer> integers = map(
				Arrays.asList("lambdas", "in", "action")
				, (String s) -> s.length()
		);
		System.out.println(integers);
	}

	private static List<Integer> map(List<String> asList, Function<String, Integer> f) {
		List<Integer> integers = new ArrayList<>();
		asList.stream()
				.forEach(s -> {integers.add(f.apply(s));
				});
		return integers;
	}


}
