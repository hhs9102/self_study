package com.self.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import junit.framework.Assert;

//100
public class OneTwoFourCountry {
	public String solution(int n){
		String[] expression = {"4","1","2"};
		
		List<String> resultStr = new ArrayList<>();
		while(n>0){
			resultStr.add(expression[n%3]);
			if(n%3 == 0){
				n = n-1;
			}
			n = n/3;
		}
		
		Collections.reverse(resultStr);
		return resultStr.stream().collect(Collectors.joining(""));	
	}
	
	@Test
	public void test(){
		OneTwoFourCountry o = new OneTwoFourCountry();
		Assert.assertEquals("1", o.solution(1));
		Assert.assertEquals("2", o.solution(2));
		Assert.assertEquals("4", o.solution(3));
		Assert.assertEquals("11", o.solution(4));
		Assert.assertEquals("421", o.solution(34));
		Assert.assertEquals("224", o.solution(27));
	}

}
