package com.self.collection;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompareArrayListToLinkedList {
    @Test
    public void test(){
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("==================100,000 add==================");

        taskTime(()->{
            for(int i=0; i<100000; i++){
                arrayList.add(i);
            }
        },"arrayList");

        taskTime(()->{
            for(int i=0; i<100000; i++) {
                linkedList.add(i);
            }
        },"linkedList");

        System.out.println("==================100 remove(index first)==================");

        taskTime(()->{
            for(int i=0; i<100; i++) {
                arrayList.remove(0);
            }
        },"arrayList");

        taskTime(()->{
            for(int i=0; i<100; i++) {
                linkedList.remove(0);
            }
        },"linkedList");

        System.out.println("==================100 remove(index last)==================");

        taskTime(()->{
            for(int i=0; i<100; i++) {
                arrayList.remove(arrayList.size()-1);
            }
        },"arrayList");

        taskTime(()->{
            for(int i=0; i<100; i++) {
                linkedList.remove(linkedList.size()-1);
            }
        },"linkedList");


        System.out.println("==================100 remove(index mid)==================");
        taskTime(()->{
            for(int i=0; i<100; i++) {
                arrayList.remove(arrayList.size()/2);
            }
        },"arrayList");

        taskTime(()->{
            for(int i=0; i<100; i++) {
                linkedList.remove(linkedList.size()/2);
            }
        },"linkedList");

    }

    private void taskTime(Runner runner, String target){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        runner.run();
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeNanos()+"ns"+String.format(" [%s]",target));
    }

    @FunctionalInterface
    public interface Runner{
        void run();
    }
}
