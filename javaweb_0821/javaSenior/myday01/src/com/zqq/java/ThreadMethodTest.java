package com.zqq.java;

/**
 * start()
 * run()
 * currentThread()
 * getName()
 * setName()
 * yield()
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("111");
            }



        }.start();
    }
}
