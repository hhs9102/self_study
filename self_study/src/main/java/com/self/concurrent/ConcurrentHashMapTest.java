package com.self.concurrent;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ConcurrentHashMapTest {

    @Test
    public void concurrentTest() throws InterruptedException {
        Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        CountDownLatch countDownLatch = new CountDownLatch(10);
        int fixedThreadCount = 10;
        int mapKey = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(fixedThreadCount);

        for(int i=0 ; i< 10; i++){
            executorService.submit(() -> {
                concurrentHashMap.compute(mapKey, (key, value) -> {
                    return value == null ? 1 : value*2;
                });
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(concurrentHashMap.get(mapKey));
        assertEquals(java.util.Optional.of(512), java.util.Optional.of(concurrentHashMap.get(mapKey)));
    }


    @Test
    public void mapTest() throws InterruptedException {
        Map<Integer, Integer> hashMap = new HashMap<>();

        CountDownLatch countDownLatch = new CountDownLatch(10);
        int fixedThreadCount = 10;
        int mapKey = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(fixedThreadCount);

        for(int i=0 ; i< 10; i++){
            executorService.submit(() -> {
                hashMap.compute(mapKey, (key, value) -> {
                    return value == null ? 1 : value*2;
                });
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(hashMap.get(mapKey));
        assertNotEquals(java.util.Optional.of(512), java.util.Optional.of(hashMap.get(mapKey)));
    }
}
