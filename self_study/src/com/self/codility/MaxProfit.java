package com.self.codility;

import org.junit.Test;

import junit.framework.Assert;

public class MaxProfit {
	
	public int solution(int[] a) {
		int max = 0;
		int x=0;
		int y=0;
		for(int i=a.length-1 ; i>0 ; i--) {
			x = a[i];
			for(int j=i-1 ; j>=0; j--) {
				y = a[j];
				if(x-y > max) {
					max = x-y;
				}
			}
		}
		return max;
	}
	
	@Test
	public void test() {
		MaxProfit sl = new MaxProfit();
		Assert.assertEquals(356, sl.solution(new int[] {23171, 21011, 21123, 21366,21013, 21367}));
	}

}
