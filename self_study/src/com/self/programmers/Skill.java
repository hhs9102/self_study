package com.self.programmers;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

//100
public class Skill {

	public int solution(String skill, String[] skill_trees) {
        Map<String, Integer> skillMap = new HashMap<>();
        int index=0;
        for(String s : skill.split("")){
        	skillMap.put(s, index++);
        }
        
        int count=0;
        for(String userSkill_tree : skill_trees){
        	int skill_index=0;
        	for(String userSkill : userSkill_tree.split("")){
        		if(skillMap.containsKey(userSkill)){
        			if(skillMap.get(userSkill) != skill_index++){
        				count--;
        				break;
        			}
        		}
        	}
        	count++;
        }
        return count;
    }
	
	public static void main(String[] args) {
		Skill s = new Skill();
		String skill ="CBD";
		String[] arr = {"BACDE", "CBADF", "AECB", "BDA"};	
		Assert.assertEquals(2, s.solution(skill, arr));
		
	}
}
