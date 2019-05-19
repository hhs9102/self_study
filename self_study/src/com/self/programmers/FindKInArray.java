package com.self.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

public class FindKInArray {
	public int[] solution(int[] array, int[][] commands) {
		int answer[] = new int[commands.length];
		
		List<Integer> list = new ArrayList<>();
		for(int i : array) {
			list.add(i);
		}
		
		for(int i=0; i<commands.length; i++) {
			List<Integer> subList = new ArrayList<Integer>();
			for(int j=0; j<subList.size(); j++) {
				subList.addAll(list.subList(commands[i][0]-1, commands[i][1]));
			}
			Collections.sort(subList);
			answer[i] = subList.get(commands[i][2]-1);
		}
		
		return answer;
	}
	

	public static void main(String[] args) {
		FindKInArray f = new FindKInArray();
		Assert.assertEquals(new int[] {5,6,3}, f.solution(new int[] {1,5,2,6,3,7,4}, new int[][]{{2,5,3},{4,4,1,},{1,7,3}}));
	}
}
