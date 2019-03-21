package com.self.thread;

public class CoffeeMachine{
	String employee1;
	String employee2;
	boolean isEmpty1;
	boolean isEmpty2;
	
	public CoffeeMachine() {
		isEmpty1 = true;
		isEmpty2 = true;
	}
	
	public synchronized void use(String employee) throws InterruptedException {
		while((isEmpty1 == false) && (isEmpty2 == false)) {
			wait();
		}
		if(isEmpty1 == true) {
			isEmpty1 = false;
			employee1 = employee;
			System.out.println(employee + "님이 1번 머신에서 아메리카노를 받습니다.");
		}else if(isEmpty2 == true) {
			isEmpty2 = false;
			employee2 = employee;
			System.out.println(employee + "님이 2번 머신에서 아메리카노를 받습니다.");
		}
	}
	
	public synchronized void done(String employee) throws InterruptedException {
		if(employee.equals(employee1)) {
			isEmpty1 = true;
			employee1 = null;
			System.out.println("1번 머신이 비었습니다.");
		}else if(employee.equals(employee2)) {
			isEmpty2 = true;
			employee2 = null;
			System.out.println("2번 머신이 비었습니다.");
		}
		notifyAll();
	}
	
}
