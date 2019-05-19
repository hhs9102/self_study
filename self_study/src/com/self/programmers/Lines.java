package com.self.programmers;

import org.junit.Test;

import junit.framework.Assert;
/*
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2] -->5
[3, 2, 1]
 */
//Fail
public class Lines {

	public int[] solution(int n, long k) {
		int[] answer = new int[n];
		
		int first = factorial(n-1);
		System.out.println(first);
		
		int[] input = new int[n];
		for(int i=0; i<n; i++) {
			input[i] = i+1;
		}
		
		int index =0;
		int x = n;
		int remain = (int)k;
		for(int i=0; i<n; i++) {
			--x;
			int f = factorial(x);
			int num = (int) (remain/f);
			remain = (int) (remain%f);
			answer[index++] = input[num];
		}
		
		return answer;
	}
	
	private int factorial(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return n * factorial(n-1);
	}
	
	@Test
	public void test() {
		Lines l = new Lines();
		Assert.assertEquals(new int[]{3,1,2}, l.solution(3, 5));
	}
	public static void main(String[] args) {
		
		Lines l = new Lines();
		Assert.assertEquals(new int[]{3,1,2}, l.solution(3, 5));
	}
}
