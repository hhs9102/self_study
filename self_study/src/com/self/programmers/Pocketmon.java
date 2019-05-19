package com.self.programmers;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

//100
public class Pocketmon {
	public int solution(int[] nums){
		Set<Integer> ditinctPockenmon = new HashSet<>();
		
		for(int i : nums){
			ditinctPockenmon.add(i);
		}
		return ditinctPockenmon.size() > nums.length/2 ? nums.length/2 : ditinctPockenmon.size();
	}

	@Test
	public void test(){
		Pocketmon p = new Pocketmon();
		Assert.assertEquals(2, p.solution(new int[]{3,1,2,3}));
		Assert.assertEquals(3, p.solution(new int[]{3,3,3,2,2,4}));
		Assert.assertEquals(2, p.solution(new int[]{3,3,3,2,2,2}));
	}
}
