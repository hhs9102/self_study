package com.self.lambda.unknown;



public class Executor {
    public void execute(Runnable runnable){
        runnable.run();
    }
    public void execute(Action action){
        action.act();
    }
}
