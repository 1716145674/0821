package com.zqq.java;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
        //t1.run();
        for (int i = 0; i <1000 ; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i+"**********");
            }
        }

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }

}