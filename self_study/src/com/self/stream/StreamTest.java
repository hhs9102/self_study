package com.self.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void intStreamTest(){
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(System.out::println);

        System.out.println(IntStream.range(1,10)
                                    .sum());

        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        String[] names = {"Al", "Ankit", "Kushal", "Brent"};
        Arrays.stream(names)
                .filter(str -> str.startsWith("K"))
                .sorted()
                .forEach(System.out::println);

        Arrays.stream(new int[]{2,4,6,8,10})
                .map(x -> x*x)
                .average()
                .ifPresent(System.out::println);
    }

}
