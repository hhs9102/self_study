package com.self.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import junit.framework.Assert;

public class BinaryGap {

	@Test
	public void test() {
		Assert.assertEquals(5, solution(1041));
		Assert.assertEquals(0, solution(15));
		Assert.assertEquals(0, solution(32));
	}
		
	
	public static int solution(int n) {
		String binaryStr = getBinaryStr(n);
		String[] splitedStr = binaryStr.split("1");
		if(splitedStr.length < 3) {
			return 0;
		}
		
		return Arrays.asList(splitedStr).stream()
								.map(i -> i.length())
								.max(Comparator.comparing(Integer::valueOf))
								.get();
    }
    
    private static String getBinaryStr(int n){
        List<Integer> binary = new ArrayList<>();
		while(n>0) {
			binary.add(n%2);
			n=n/2;
			if(n==1) {
				binary.add(1);
				n=0;
			}
		}
		return binary.stream()
        		     .map(i -> String.valueOf(i))
        			 .collect(Collectors.joining());
    }
}
