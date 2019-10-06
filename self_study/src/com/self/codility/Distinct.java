package com.self.codility;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//lesson 6 8p
public class Distinct {
	public int solution(int[] A) {
        Map<Integer, Boolean> distinctMap = new HashMap<>();
        
        for(int i : A) {
        	if(distinctMap.containsKey(i)) {
        		distinctMap.put(i, false);
        	}else {
        		distinctMap.put(i, true);
        	}
        }
        
        List<Integer> distinctList = new ArrayList<>();
        for(Entry<Integer, Boolean> entry : distinctMap.entrySet()) {
        	if(entry.getValue()) {
        		distinctList.add(entry.getKey());
        	}
        }
        
        if(distinctList.size()==1) {
        	return distinctList.get(0);
        }else {
        	return 0;
        }
    }
	
	@Test
	public void test() {
		Distinct d = new Distinct();
		Assert.assertEquals(3, d.solution(new int[] {2,1,1,2,3,1}));
		Assert.assertEquals(4, d.solution(new int[] {2,1,1,2,3,3,4,1}));
		Assert.assertEquals(-5, d.solution(new int[] {2,1,1,2,-5,3,3,4,4,1}));
//		Assert.assertEquals(3, d.solution(new int[] {2,1}));
	}
}
