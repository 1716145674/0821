package com.zqq.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExectorsTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        System.out.println(service.getClass());
        ThreadPoolExecutor service1= (ThreadPoolExecutor) service;
        service1.setCorePoolSize(5);
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("******");
            }
        });
        service.shutdown();

    }
}
