package com.self.enumtest;

public class EnumTest {

	public static void main(String[] args) {
		double three = BasicOperation.PLUS.apply(1.3, 2.2);
		System.out.println("3.5 :: " + three);
		
		BasicOperation b = BasicOperation.getBasicOperationByCode("M");
		double four = b.apply(6.0, 2.0);
		System.out.println("4.0 :: "+four);
	}

}
