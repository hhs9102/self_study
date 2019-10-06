package com.self.programmers;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//100
public class Lifeboat {
	public int soltution(int[] people, int limit){
		int result=people.length;
		
		List<Integer> peopleList = new ArrayList<>();
		for(int i : people){
			peopleList.add(i);
		}
		Collections.sort(peopleList);
		
		int left = 0;
		int right = peopleList.size()-1;
		while(left < right){
			if(peopleList.get(left) + peopleList.get(right) <= limit){
				result--;
				left++;
			}
			right--;
		}
		
		return result;
	}
	
	@Test
	public void test(){
		Lifeboat l = new Lifeboat();
		Assert.assertEquals(3, l.soltution(new int[]{70,50,30,80}, 100));
		Assert.assertEquals(3, l.soltution(new int[]{70,80,50}, 100));
		Assert.assertEquals(2, l.soltution(new int[]{50,50,50,50}, 100));
	}
}
