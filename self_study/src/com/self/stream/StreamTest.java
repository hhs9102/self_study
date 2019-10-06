package com.self.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;

public class StreamTest {

    @Test
    public void intStreamTest() {
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(System.out::println);

        System.out.println(IntStream.range(1, 10)
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

        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
    }

    @Test
    public void testStreamAnyMatch(){
        IntStream is = IntStream.range(1,100);
        boolean isExists  = is.map(i -> i/5)
                            .filter(i -> i>5)
                            .anyMatch(i -> i==20);
        System.out.println(isExists);

        is = IntStream.range(1,100);
        boolean  isNotExists = is.map(i -> i/5)
                .filter(i -> i>5)
                .noneMatch(i -> i==20);
        System.out.println(isNotExists);
    }

    @Test
    public void testStream(){
        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        l.add("one");
        l.add("ten");
        String s = sl.collect(joining(" "));
        System.out.println(s);

        System.out.println(l.stream()
        .reduce("", String::concat));
        System.out.println(l.stream()
        .reduce("", String::concat));


        for(String element : l.stream().collect(Collectors.toList())){
            System.out.println(element);
        }

        System.out.println(l.stream().map(str -> str.toUpperCase()).collect(Collectors.joining(",")));

        System.out.println(l.stream().map(str -> str.substring(0,1)).collect(Collectors.groupingBy(str ->str, counting())));

        String findAnyStr = l.stream()
                .filter(str -> s.startsWith("e"))
                .findAny()
                .orElse("none");
        System.out.println(findAnyStr);

        String findAnyStr2 = l.stream()
                .filter(str -> s.startsWith("o"))
                .findAny()
                .orElse("none");
        System.out.println(findAnyStr2);

    }
}


