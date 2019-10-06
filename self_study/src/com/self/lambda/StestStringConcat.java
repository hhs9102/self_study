package com.self.lambda;

public class StestStringConcat {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "World";
		
		StringConcatImpl concat1 = new StringConcatImpl();
		concat1.makeString(s1, s2);
		
		StringConcat concat2 = (a1, a2) -> System.out.println(a1 + "," + a2);
		concat2.makeString(s1, s2);
		
		StringConcat concat3 = (t1, t2) -> {
			String temp = t1 +","+t2;
			System.out.println(temp);
		};
		concat3.makeString("bb","cc");
	}
}
