package com.zqq.java;
//生产着消费者问题，线程通信

/**
 * 生产者线程，消费者线程
 * 共享数据：店员或者产品
 * 解决：同步机制（三种方法）
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Thread t1 = new Thread(producer);
        t1.setName("生产者");
        t1.start();

        Consumer consumer = new Consumer(clerk);
        Thread t2 = new Thread(consumer);
        t2.setName("消费者");
        t2.start();

    }

}
class  Clerk{
    private  int productCount=0;
    public synchronized void produceProduct(){
        if(productCount<20){

            productCount++;
            System.out.println(Thread.currentThread().getName()+"生产了第"+productCount+"个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void consumerProduct(){
        if(productCount>0){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+"消费了第"+productCount+"个产品");
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
class Producer implements  Runnable{
    private  Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+":开始生产产品");
        while (true){
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            clerk.produceProduct();
        }
    }
}

class  Consumer implements Runnable{
    private  Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始消费产品");
        while (true) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            clerk.consumerProduct();
        }
    }
}