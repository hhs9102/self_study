package com.self.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

//flatMap
//스트림의 각 값을 다른 스크림으로 만든 다음에 모든 스트림을 하나의 스트림으로 연결하는 기능을 수행.
public class PythagoreanTriples {
    //a,b,c 1~100 피타고라스 정리를 만족하는 int array를 구해라
    @Test
    public void test(){
        Stream<int []>  stream = IntStream
                .rangeClosed(1,100)
                .boxed()
                .flatMap(a ->
                     IntStream.rangeClosed(a, 100)
                            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                            .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        stream.limit(1).forEach(arr -> {
            Assert.assertArrayEquals(new int[]{3,4,5}, arr);
        });
    }
}
