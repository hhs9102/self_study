package com.self.programmers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PhoneBook {

	public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> phoneList = new ArrayList<>();
        
        for(String s : phone_book) {
        	phoneList.add(s.trim());
        }
        
        for(String phoneNumber : phoneList) {
        	for(String targetNumber : phoneList) {
        		if(!phoneNumber.equals(targetNumber) && targetNumber.startsWith(phoneNumber)) {
        			return false;
        		}
        	}
        }
        
        return answer;
    }
	
	@Test
	public void test() {
		PhoneBook pb = new PhoneBook();
		System.out.println(pb.solution(new String[] {"119","119 33303 392"}));
	}
}
