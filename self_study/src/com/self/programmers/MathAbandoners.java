package com.self.programmers;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

//100 수포자
public class MathAbandoners {
	public int[] solution(int[] answers) {
		Map<Integer, Integer> abandonerMap = new HashMap<>();
		
		Map<Integer, List<Integer>> abandonerSheet = new HashMap<>();
		abandonerSheet.put(0, Arrays.asList(1,2,3,4,5));
		abandonerSheet.put(1, Arrays.asList(2,1,2,3,2,4,2,5));
		abandonerSheet.put(2, Arrays.asList(3,3,1,1,2,2,4,4,5,5));
		
		int answerNumber;
		int targetNumber;
		for(int i=0; i<answers.length ;i++) {	//answers 수만큼 반복
			answerNumber = answers[i];
			for(Integer entry : abandonerSheet.keySet()) {	//수포자 3명 반복
				List<Integer> sheet = abandonerSheet.get(entry);
				targetNumber = abandonerSheet.get(entry).get(i%sheet.size());
				if(answerNumber == targetNumber) {	//정답 비교
					abandonerMap.merge(entry, 1, (oldValue,newValue)->oldValue+1);	//수포자 key , 정답수 count
				}
			}
		}
		
		if(abandonerMap.isEmpty()) {	//모두 틀렸을 때
			return new int[] {1,2,3};
		}
		
		int max=0;
		for(Entry<Integer, Integer> entry : abandonerMap.entrySet()) {	//수포자중 최대 값 find
			if(entry.getValue() > max) {
				max = entry.getValue();
			}
		}
		
		List<Integer> maxPeople = new ArrayList<Integer>();
		for(Entry<Integer, Integer> entry : abandonerMap.entrySet()) {
			if(entry.getValue() ==  max) {
				maxPeople.add(entry.getKey());
			}
		}
		return maxPeople.stream().mapToInt(i->i+1).toArray();	//0,1,2 -> 1,2,3번째 수포자
	}

	
	@Test
	public void test() {
		MathAbandoners m = new MathAbandoners();
//		assertTrue(Arrays.equals(new int[] {1}, m.solution(new int[] {1,2,3,4,5})));
//		assertTrue(Arrays.equals(new int[] {1,2,3}, m.solution(new int[] {1,3,2,4,2})));
//		assertTrue(Arrays.equals(new int[] {1,2,3}, m.solution(new int[] {0,0,0,0,0})));
//		assertTrue(Arrays.equals(new int[] {3}, m.solution(new int[] {1,1,1,1,1})));
		assertTrue(Arrays.equals(new int[] {2}, m.solution(new int[] {2,2,2,2,2,2,2,2,2,2,2,2})));
	}
	
//	@Test
	public void test1() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<10; i++) {
			map.merge(0, 1, (oldValue,newValue)->oldValue+1);
		}
		System.out.println(map);
	}
}
