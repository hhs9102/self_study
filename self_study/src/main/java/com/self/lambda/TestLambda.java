package com.self.lambda;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {
	
	@FunctionalInterface
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
	
	@Test
	public void testLambda() {
		List<String> strList = Arrays.asList("abcd","efghij","klmno");
		
		Collections.sort(strList, (s1, s2)-> Integer.compare(s1.length(), s2.length()));

		List<String> expectedList = Arrays.asList("abcd","klmno", "efghij");
		for(int i=0; i<3; i++) {
			Assert.assertEquals(expectedList.get(i), strList.get(i));
		}
	}
}
