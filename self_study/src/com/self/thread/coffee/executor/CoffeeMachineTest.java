package com.self.thread.coffee.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoffeeMachineTest {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new CoffeeReceive(coffeeMachine, "employee" + i));
        }

        if (executorService.isTerminated()) {
            executorService.shutdown();
        }
    }

}
