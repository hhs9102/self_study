package com.self.thread;

import java.util.concurrent.TimeUnit;

public class SyncronizedThreadTest {
    public static boolean stopRequested;

    //stopRequested가 동기화 되지 않아 코드가 종료되지 않음.
    /*public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!stopRequested){
                i++;
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }*/

    public static synchronized void requestStop(){
        stopRequested = true;
    }

    public static synchronized boolean stopRequested(){
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!stopRequested()){
                i++;
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}

