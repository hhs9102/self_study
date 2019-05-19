package com.self.programmers;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import junit.framework.Assert;

public class PairString {
	
	public int solution(String s){
		LinkedList<String> linkedList = new LinkedList<>();
		
		linkedList.addAll(Arrays.asList(s.split("")));
		
		int index = 0;
		while(index < linkedList.size()){
			if(index == linkedList.size()-1){
				return 0;
			}
			String current = linkedList.get(index);
			String next = linkedList.get(index+1);
			
			if(current.equals(next)){
				linkedList.remove(index);
				linkedList.remove(index);
				index= 0;
			}else{
				index++;
			}
		}
		return linkedList.size()==0 ? 1 : 0;
	}
	
	@Test
	public void test(){
		PairString ps= new PairString();
		//Assert.assertEquals(1, ps.solution("baabaa"));
		Assert.assertEquals(0, ps.solution("cdcd"));
	}

}
