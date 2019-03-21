package com.self.lambda;

public class TestLambda {
	
	interface PrintString{
		void showString(String str);
	}

	public static void main(String[] args) {
		
		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("Hello lambda_1");
		showMyString(lambdaStr);
		
		PrintString reStr = returnString();
		reStr.showString("Hello ");
	}
	
	public static void showMyString(PrintString p) {
		p.showString("Hello Lambda_2");
	}
	
	public static PrintString returnString() {
		return s -> System.out.println(s + "world");
	}
}
