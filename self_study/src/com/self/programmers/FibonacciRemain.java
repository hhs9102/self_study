package com.self.programmers;

import java.math.BigInteger;

import org.junit.Test;

//100
public class FibonacciRemain {
	public int solution(int n){
		BigInteger[] result = new BigInteger[n+1];
		result[0] = BigInteger.ZERO;
		result[1] = BigInteger.ONE;
		for(int i=2; i<=n; i++){
			result[i] = result[i-2].add(result[i-1]);
		}
		return result[n].remainder(new BigInteger("1234567")).intValue();
		//return fib(n).remainder(new BigInteger("1234567")).intValue();
	}
	
	private BigInteger fib(int n){
		if(n == 0){
            return BigInteger.ZERO;
        }else if(n==1){
            return BigInteger.ONE;
        }else{
            return fib(n-1).add(fib(n-2));
        }
	}
	
	@Test
	public void test(){
		FibonacciRemain fr = new FibonacciRemain();
		System.out.println(fr.solution(5));
	}

}
