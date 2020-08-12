package com.self.lambda.unknown;

public class ExecutorMain {

    public static void main(String[] args) {
        Executor executor = new Executor();
        //executor.execute( () -> {});  //함수 디스크립터가 같으므로 무엇을 호출하는지 명확하지 않음.
        executor.execute((Action) () -> {
            System.out.println("Action");
        });
        executor.execute((Runnable) () -> {
            System.out.println("Runnable");
        });
    }
}
