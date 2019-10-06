package com.self.programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Average {

	public double solution(int[] arr) {
	      IntStream is = Arrays.stream(arr);
	      return ((double)is.sum())/arr.length;
	}
	
	@Test
	public void test(){
		Average a = new Average();
		Assert.assertEquals(2.5, a.solution(new int[]{1,2,3,4}));
	}
}
