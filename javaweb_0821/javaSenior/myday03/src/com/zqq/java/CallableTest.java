package com.zqq.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        Number1 number = new Number1();
        FutureTask futureTask = new FutureTask(number);
        FutureTask futureTask1 = new FutureTask(number);

        Thread thread = new Thread(futureTask);
        Thread thread1 = new Thread(futureTask1);
        thread.start();
        thread1.start();

        Object o=null;
        try {
             o = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o+"");

    }
}

class  Number1 implements Callable{
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i <100; i++) {
            sum+=i;
        }
        return sum;
    }
}
