package com.self.stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.RunRules;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveIf {

    //Iterator와 Collection의 상태는 공유되지 않는다. -> removeIf로 문제해결할 수 있음.
    @Test(expected= ConcurrentModificationException.class)
    public void expectedConcurrentModificationException(){
        ArrayList<Integer> list = (ArrayList<Integer>) IntStream.iterate(1, i -> i+1).limit(10).boxed().collect(Collectors.toList());
        int index = 0;
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {

            Integer integer = it.next();
            if(integer.equals(2)){
                list.remove(integer);
            }
        }
    }

    @Test
    public void expectedRemoveIntegerObject(){
        ArrayList<Integer> list = (ArrayList<Integer>) IntStream.iterate(1, i -> i+1).limit(10).boxed().collect(Collectors.toList());

        list.remove(Integer.valueOf(4));
        Assert.assertEquals(false, list.stream().anyMatch(i-> i.equals(4)));
        Assert.assertEquals(true, list.stream().anyMatch(i-> i.equals(5)));
        System.out.println(list);
    }

    //동기화와 관계없이 Iterator의 remove메서드를 이용하여 삭제할 수 있다.
    @Test
    public void iteratorRemove(){
        ArrayList<Integer> list = (ArrayList<Integer>) IntStream.iterate(1, i -> i+1).limit(10).boxed().collect(Collectors.toList());

        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            Integer integer = it.next();
            if(integer.equals(2)){
                it.remove();
            }
        }

        Assert.assertEquals(false, list.stream().anyMatch(i->i.equals(2)));
        System.out.println(list);
    }

    @Test
    public void streamRemoveIfTest(){
        ArrayList<Integer> list = (ArrayList<Integer>) IntStream.iterate(1, i -> i+1).limit(10).boxed().collect(Collectors.toList());
        list.removeIf(i->i.equals(2));
        Assert.assertEquals(false, list.stream().anyMatch(i->i.equals(2)));
        System.out.println(list);
    }

    static int i = 5;
    @Test
    //modern java in action p.295
    //익명클래스의 this는 자기 자신을 가르키지만, lambda의 this는 람다를 감싸는 클래스를 가르킨다.
    public void testEtc(){
        int a=2;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int a = 3;
                System.out.println(a);
            }
        };
        runnable.run();

        Runnable runnable1 = () -> {
            //int a -> 불가.
            int b =4;
            this.i = 4;
            System.out.println(b);
        };
        runnable1.run();
    }
}
