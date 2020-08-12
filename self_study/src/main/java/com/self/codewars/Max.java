package com.self.codewars;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Max {
  public static int sequence(int[] arr) {
    if(arr.length ==0){
      return 0;
    }
    
  
    IntStream stream = Arrays.stream(arr);
    OptionalInt a = stream.distinct().sorted().max();
    System.out.println(a);
    


    return 4;
  }
  
  public static void main(String[] args) {
	  Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
  }
}