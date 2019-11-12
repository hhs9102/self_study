package com.self.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapTest {

    @Test
    public void sameAgeCountTest(){
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> subList = Arrays.asList(23,24,25,33,22,34);
        list.add(subList);     //22 -> 1
        list.add(Arrays.asList(22,21,14,52,22,36));     //22 -> 2
        list.add(Arrays.asList(14,17,22,33,78,33));     //22 -> 1

        //flatMap -> 평탄화
        //List<List<Integer>>로 선언된 것을 마치 하나의 리스트 처럼 평탄화 시킨다.
        //23,24,25,33,22,34,22,21,14,52,22,36,14,17,22,33,78,33 중에 22와 같은 리스트 수
        long sameAgeCount = list.stream()
                .flatMap(array -> array.stream()
                        .filter(age -> age.equals(Integer.valueOf(22)))
                ).count();
        System.out.println("sameAgeCount : "+sameAgeCount);

    }
}
