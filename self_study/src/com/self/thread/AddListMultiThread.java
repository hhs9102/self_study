package com.self.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AddListMultiThread {
	public static void main(String[] args) {
		Map<Integer, Integer> singleThreadMap = new HashMap<>();
		Map<Integer, Integer> multiThreadMap = new HashMap<>();
		Map<Integer, Integer> multiThreadConcurrentMap = new ConcurrentHashMap<>();
		
		new Thread(()->{
			for(int i=0; i<10000; i++){
				singleThreadMap.put(i, i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("singleThreadMap size : "+singleThreadMap.size());
			System.out.println("singleThreadMap 1000 : "+singleThreadMap.get(9999));
		}).start();
		System.out.println();
		new Thread(()->{
			for(int i=0; i<5000; i++){
				multiThreadMap.put(i, i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("multiThreadMap size : "+multiThreadMap.size());
			System.out.println("multiThreadMap 5000 : "+multiThreadMap.get(4999));
		}).start();
		System.out.println();
		new Thread(()->{
			for(int i=5000; i<10000; i++){
				multiThreadMap.put(i, i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("multiThreadMap size : "+multiThreadMap.size());
			System.out.println("multiThreadMap 10000 : "+multiThreadMap.get(9999));
		}).start();
		new Thread(()->{
			for(int i=0; i<5000; i++){
				multiThreadConcurrentMap.put(i, i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("multiThreadConcurrentMap size : "+multiThreadConcurrentMap.size());
			System.out.println("multiThreadConcurrentMap 5000 : "+multiThreadConcurrentMap.get(4999));
		}).start();
		System.out.println();
		new Thread(()->{
			for(int i=5000; i<10000; i++){
				multiThreadConcurrentMap.put(i, i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("multiThreadConcurrentMap size : "+multiThreadConcurrentMap.size());
			System.out.println("multiThreadConcurrentMap 10000 : "+multiThreadConcurrentMap.get(9999));
		}).start();
	}
}
