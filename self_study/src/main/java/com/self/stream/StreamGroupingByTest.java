package com.self.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamGroupingByTest {
	
	public static void main(String[] args) {
		 List<String> items =
	                Arrays.asList("apple", "apple", "banana",
	                        "apple", "orange", "banana", "papaya", "a");

	        Map<String, Long> groupingByFirstCharCount =
	                items.stream()
	                	 .map(s -> s.toString())
	                	 .collect(Collectors.groupingBy(
	                                	s -> s.substring(0,1), Collectors.counting()
	                			  ));
	        System.out.println(groupingByFirstCharCount);
	        //{p=1, a=4, b=2, o=1}
	       
	        Map<Object, List<String>> groupingByFirstCharList =
	                items.stream().collect(
	                        Collectors.groupingBy(
	                                s -> s.toString().substring(0,1)
	                        ));
	        System.out.println(groupingByFirstCharList);
	        //{p=[papaya], a=[apple, apple, apple, a], b=[banana, banana], o=[orange]}
	        
	        Map<Object, List<String>> groupingByItems =
	        		items.stream().collect(
	        				Collectors.groupingBy(
	        						s -> s.toString()
	        						));
	        System.out.println(groupingByItems);
	        //{papaya=[papaya], orange=[orange], banana=[banana, banana], a=[a], apple=[apple, apple, apple]}
	        
	        Map<String, Long> groupByUpperCount = 
	        		items.stream().collect(
	        				Collectors.groupingBy(String::toUpperCase, Collectors.counting()
	        						));
	        System.out.println(groupByUpperCount);
	        //{A=1, APPLE=3, PAPAYA=1, BANANA=2, ORANGE=1}
	}

}
