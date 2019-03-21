package com.self.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FindFirstNumber {
	
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		final AtomicInteger count = new AtomicInteger(1);
		
		System.out.println("1~8에서 3보다 큰수 중에 곱하기 2한 값이 가장 작은 값을 출력해라.");
		
		System.out.println("Stream 활용  : " +
			numbers.stream().filter(i -> {
								count.getAndAdd(1);
								return i > 3;
							})
						    .map(i -> {
						    	count.getAndAdd(1);
						    	return i * 2;
						    })
						    .filter(i -> {
						    	count.getAndAdd(1);
						    	return i > 10;
						    })
						    .findFirst()
	    );
		System.out.println("Stream 활용  count 수 : "+count);
		
		count.set(1);	//초기화
		
		System.out.println();
		int result=0;
		for(int i : numbers) {
			count.getAndAdd(1);
			if(i > 3) {
				i = i*2;
				if(i > 10) {
					result = i;
					break;
				}
			}
		}
		System.out.println("기존 for, if 활용 : "+result);
		System.out.println("기존 for, if 활용  count 수 : "+count);
	}
}
