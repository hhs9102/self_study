package com.self.thread;

public class CoffeeMachineTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CoffeeMachine coffeeMachine = new CoffeeMachine();
		for(int i=0; i<10; i++) {
			Thread t = new Thread(new CoffeeReceive(coffeeMachine, "직원" + i));
			t.start();
		}
	}

}
