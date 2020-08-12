package com.self.codility;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class FrogJump {

	public int solution(int X, int[] A){
		Set<Integer> set = new HashSet<>();
		
		BigInteger total = total(X);
		
		int aValue;
		BigInteger sum = BigInteger.ZERO;
		for(int i=0; i<A.length; i++){
			aValue = A[i];
			if(set.contains(aValue)){
				continue;
			}else{
				set.add(aValue);
				sum = sum.add(BigInteger.valueOf(aValue));
				
				if(total.equals(sum)){
					return i;
				}
			}
		}
		return -1;
	}
	
	public BigInteger total(int length){
		if(length%2 == 0){
			return BigInteger.valueOf(length/2 * (1 + length));
		}else{
			return BigInteger.valueOf(length/2 * (1 + length-1) + length);
		}
		
	}
	
	@Test
	public void test(){
		Assert.assertEquals(6, solution(5, new int[]{1,3,1,4,2,3,5,4}));
	}
}
