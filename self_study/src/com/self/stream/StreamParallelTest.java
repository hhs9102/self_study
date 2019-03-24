package com.self.stream;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class StreamParallelTest {
	public static void main(String[] args) {
		
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
		long start1 = System.currentTimeMillis();
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).parallelStream().map(i -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return i;
		}).forEach(i -> System.out.println(i));
		System.out.println("settings parellel 4");
		System.out.println(System.currentTimeMillis() - start1);

		System.out.println("=======================================");
		
		long start2 = System.currentTimeMillis();
		ForkJoinPool forkjoinPool = new ForkJoinPool(4);
		try {
			forkjoinPool.submit(() -> {
				Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).parallelStream().forEach(index -> {
					System.out.println("Thread : " + Thread.currentThread().getName() + ", index");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				});
			}).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("use ForkJoinPool 4");
		System.out.println(System.currentTimeMillis() - start2);
	}
}
