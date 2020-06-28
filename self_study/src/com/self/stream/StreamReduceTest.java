package com.self.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

//reduce 스트림의 모든 요소를 반복적으로 처리
public class StreamReduceTest {

    @Test
    public void sumTest(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        assertEquals(Integer.valueOf(55), list.stream()
                .reduce(0, (a,b) -> a+b));

        //초기값 없이 reduce를 처리할 경우 스트림에 아무도 없을 가능성이 있으니, optional을 반환한다.
        assertEquals(Integer.valueOf(55), list.stream()
                .reduce((a,b) -> a+b).get());
    }

    @Test
    public void minTest(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        assertEquals(Integer.valueOf(1), list.stream()
            .reduce((a,b)-> a>b ? b : a).get());
        assertEquals(Integer.valueOf(1), list.stream()
            .reduce(Integer::min).get());
    }
}
