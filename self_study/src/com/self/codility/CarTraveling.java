package com.self.codility;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CarTraveling {
	private final int MAX = 1000000000;
	
	public int solution(int[] A){
		Map<Integer, Integer> map = new HashMap<>();
		
		int mapIndex = 0;
		int mapCount = 0;
		
		for(int i=A.length; i>0; i--){
			if(A[i-1] == 1){
				mapCount++;
			}else{
				map.put(mapIndex++, mapCount);
			}
		}
		
		int sum=0;
		for(Map.Entry<Integer, Integer> ent : map.entrySet()){
			sum += ent.getValue();
			if(sum > MAX){
				return -1;
			}
		}
		return sum;
	}
	
	@Test
	public void test(){
		Assert.assertEquals(5, solution(new int[]{0,1,0,1,1}));
	}

}
