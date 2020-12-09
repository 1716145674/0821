package com.zqq.exer;

public class HomeWork {
    public static void main(String[] args) {
        MyThread m = new MyThread();
        Thread t = new Thread(m);
        t.start();

//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        int j = m.i;
        System.out.println(Thread.currentThread().getName()+j);
    }
}
class MyThread implements Runnable{
    int i;
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i=100;
    }
}

