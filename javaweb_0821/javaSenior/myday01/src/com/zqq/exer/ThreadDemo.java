package com.zqq.exer;

public class ThreadDemo {
    public static void main(String[] args) {
//        Mythread1 m1 = new Mythread1();
//        Mythread2 m2 = new Mythread2();
//        m1.start();
//        m2.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

                }
            }
        }.start();
    }


}

class Mythread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

class Mythread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}
