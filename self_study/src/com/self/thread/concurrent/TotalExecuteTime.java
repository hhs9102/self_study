package com.self.thread.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class TotalExecuteTime {
    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException{
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for(int i=0; i<concurrency ; i++){
            executor.execute(()->{
                ready.countDown();
                try{
                    start.await();
                    action.run();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }finally {
                    done.countDown();
                }
            });
        }

        ready.await();
        long startNanos = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) throws InterruptedException {

        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                String currentThreadName = Thread.currentThread().getName();
                for(int i=0; i<5; i++){
                    System.out.println(command.toString());
                    System.out.println(currentThreadName + i);
                }
            }
        };

        System.out.println("totalTime : "+
            time(executor, 2, () -> {
                System.out.println("@2");
            })
        );
    }
}
