package com.self.thread.coffee.reentrant;

import com.self.thread.coffee.CoffeeMachine;
import com.self.thread.coffee.CoffeeReceive;

public class CoffeeMachineTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new CoffeeReceive(coffeeMachine, "직원" + i));
            t.start();
        }
    }

}
