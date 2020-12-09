package com.zqq.exer;

public class TicketTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}

class Window implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            synchronized(Window.class) {
                if (tickets > 0) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                    System.out.println(Thread.currentThread().getName() + "售出一张票" + tickets--);

                } else
                    break;
            }
        }
    }
}
