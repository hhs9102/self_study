package com.self.thread.executor;

public class CoffeeReceive implements Runnable {
    CoffeeMachine coffeeMachine;
    String employee;

    public CoffeeReceive(CoffeeMachine coffeeMachine, String employee) {
        this.coffeeMachine = coffeeMachine;
        this.employee = employee;
    }

    @Override
    public void run() {
        try {
            coffeeMachine.use(employee);
            Thread.sleep(3000);
            coffeeMachine.done(employee);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
