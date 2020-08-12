package com.self.thread.coffee.reentrant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CoffeeMachine {
    String employee1;
    String employee2;
    boolean isEmpty1;
    boolean isEmpty2;
    
    private final ReentrantLock locker = new ReentrantLock();
    private final Condition lockerCondition = locker.newCondition();
    
    public CoffeeMachine() {
        isEmpty1 = true;
        isEmpty2 = true;
    }

    public void use(String employee) throws InterruptedException {
        while ((isEmpty1 == false) && (isEmpty2 == false)) {
        	lockerCondition.await();
        }
        locker.lock();
    	if (isEmpty1 == true) {
    		isEmpty1 = false;
    		employee1 = employee;
    		System.out.println(employee + "님이 1번 머신에서 아메리카노를 받습니다.");
    	} else if (isEmpty2 == true) {
    		isEmpty2 = false;
    		employee2 = employee;
    		System.out.println(employee + "님이 2번 머신에서 아메리카노를 받습니다.");
    	}
		locker.unlock();
    }

    public void done(String employee) throws InterruptedException {
        if (employee.equals(employee1)) {
            isEmpty1 = true;
            employee1 = null;
            System.out.println("1번 머신이 비었습니다.");
        } else if (employee.equals(employee2)) {
            isEmpty2 = true;
            employee2 = null;
            System.out.println("2번 머신이 비었습니다.");
        }
        lockerCondition.signalAll();
    }

}
