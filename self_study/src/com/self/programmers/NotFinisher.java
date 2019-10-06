package com.self.programmers;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

//100
public class NotFinisher {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> pMap = new HashMap<>();
		Map<String, Integer> cMap = new HashMap<>();
		
		for(String pName : participant) {
			pMap.merge(pName, 1, (k,v) -> v+1);
		}
		for(String cName : completion) {
			cMap.merge(cName, 1, (k,v) -> v+1);
		}
		System.out.println(pMap);
		System.out.println(cMap);
		
		for(String entry : pMap.keySet()) {
			if(!pMap.get(entry).equals(cMap.get(entry)) || !cMap.containsKey(entry)) {
				return entry;
			}
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		NotFinisher nf = new NotFinisher();
		Assert.assertEquals("mislav", nf.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
		Assert.assertEquals("vinko", nf.solution(new String[] {"mislav", "josipa", "nikola", "vinko", "filipa"}, new String[] {"mislav", "josipa", "nikola", "filipa"}));
	}

}
