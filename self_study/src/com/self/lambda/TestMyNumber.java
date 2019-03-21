package com.self.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestMyNumber {
	
	
	//람다식은 메서드 이름이 없고  메서드를 실행하는데 필요한 매개변수와 매개변수를 활용한 실행한 것
	@FunctionalInterface //람다식 인터페이스는 하나의 메서드만들 가질 수 있는데 그것을 검증하기위한 어노테이션
	public interface MyNunber{
		int getMax(int num1, int num2);
//		int getMin(int num1, int num2);
	}
	
	public static int getMax2(int num1, int num2) {
		return num1 >= num2 ? num1 : num2;
	}

	public static void main(String[] args) {
		MyNunber max = (x, y) -> (x >= y ? x : y);
		System.out.println(max.getMax(100, 29));
		System.out.println(getMax2(100, 29));
		
		BiFunction<Integer , Integer, Integer> bf = (x, y) -> (x >= y)  ? x : y;
		System.out.println(bf.apply(100, 29));
		
		Function<String, Integer> f = (String s) -> Integer.parseInt(s);
		Function<String, Integer> f2 = Integer::parseInt;
		int a = f2.apply("22");
		System.out.println(f.apply("2") +" + " + (a+1));
	}
}
