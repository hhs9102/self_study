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

		methodReference();
	}

	private static void methodReference() {
		Function<String, Integer> function = String::length;
		System.out.println(":::::::::::methodReference:::::::::::");
		System.out.println(function.apply("asdfasdfsa"));

		SubstringFunctional substringFunctional1 = String::substring;
		SubstringFunctional substringFunctional2 = (str, i) -> str.substring(i);
		System.out.println(substringFunctional1.apply("2192873",3));
		System.out.println(substringFunctional2.apply("2192873",3));
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
