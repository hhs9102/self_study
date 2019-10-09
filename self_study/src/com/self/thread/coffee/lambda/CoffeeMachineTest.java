package com.self.thread.coffee.lambda;

import java.util.concurrent.atomic.AtomicInteger;

public class CoffeeMachineTest {

	public static void main(String[] args) {

		final AtomicInteger count = new AtomicInteger(1);
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		for(int i=0; i<10; i++) {
			new Thread(() -> {
				try {
					int cnt = count.getAndAdd(1);
					String employee = "직원"+cnt;
					coffeeMachine.use(employee);
					Thread.sleep(3000);
					coffeeMachine.done(employee);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}).start();
		}
	}

}
