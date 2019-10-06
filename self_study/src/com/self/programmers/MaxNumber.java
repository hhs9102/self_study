package com.self.programmers;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//100
public class MaxNumber {
	public String solution(int[] numbers){
		List<String> strList = Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.toList());
		
		Collections.sort(strList, (s1, s2)->{
			String o1 = s1.toString();
			String o2 = s2.toString();
			return new BigInteger(o2.concat(o1)).subtract(new BigInteger(o1.concat(o2))).intValue();
		});
				
		String anwser = strList.stream().collect(Collectors.joining(""));
		return String.valueOf(new BigInteger(anwser));
	}

	@Test
	public void test(){
		MaxNumber m = new MaxNumber();
		Assert.assertEquals("6210", m.solution(new int[]{6,10,2}));
		Assert.assertEquals("9534330", m.solution(new int[]{3,30,34,5,9}));
		
		Assert.assertEquals("0", m.solution(new int[]{0, 0, 0, 0}));
		Assert.assertEquals("1000000", m.solution(new int[]{0, 1000, 0, 0}));
		Assert.assertEquals("12121", m.solution(new int[]{12, 121}));
		Assert.assertEquals("21221", m.solution(new int[]{21, 212}));
		
		Assert.assertEquals("303030", m.solution(new int[]{30, 3030}));
		Assert.assertEquals("11211", m.solution(new int[]{11, 112}));
		Assert.assertEquals("211", m.solution(new int[]{11, 2}));
		Assert.assertEquals("534534211", m.solution(new int[]{11, 2,34,345,5}));
		Assert.assertEquals("5000", m.solution(new int[]{5,0,0,0}));
		
		Assert.assertEquals("1000000", m.solution(new int[]{1000,0,0,0}));
		Assert.assertEquals("1000000", m.solution(new int[]{0,0,0,1000}));
		Assert.assertEquals("10001000000", m.solution(new int[]{1000,0,0,0,1000}));
		
		Assert.assertEquals("1111", m.solution(new int[]{1,1,1,1}));
		Assert.assertEquals("1111", m.solution(new int[]{1,1,11}));
		Assert.assertEquals("1111", m.solution(new int[]{1,111}));
		
		
		
		
		
	}
}
