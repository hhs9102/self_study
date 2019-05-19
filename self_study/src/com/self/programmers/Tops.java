package com.self.programmers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class Tops {
	
	public int[] solution(int[] heights){
		int result[] = new int[heights.length];
		int index=heights.length-1;
		for(int i=heights.length-1; i>=0; i--){
			for(int j=i-1; j>=0; j--){
				if(heights[j] > heights[i]){
					result[index] = j+1; 	//1부터시작
					break;
				}
			}
			index--;
		}
		return result;
	}
	
	@Test
	public void test(){
		Tops t = new Tops();
		Assert.assertEquals(new int[]{0,0,2,2,4}, t.solution(new int[]{6,9,5,7,4}));
		Assert.assertEquals(new int[]{0,0,0,3,3,3,6}, t.solution(new int[]{3,9,9,3,5,7,2}));
	}
	
	public static void main(String[] args) {
		Tops t = new Tops();
		t.solution(new int[]{6,9,5,7,4});
		
	}

}
