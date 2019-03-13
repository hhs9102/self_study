package effective.test;

import java.math.BigInteger;
import java.util.Random;

public class Item1 {
	public static void test() {
		Random r = new Random();
		System.out.println(new BigInteger(10,1, r));		
		System.out.println(BigInteger.probablePrime(10, r));
	}
}
