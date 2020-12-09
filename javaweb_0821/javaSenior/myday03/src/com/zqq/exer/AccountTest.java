package com.zqq.exer;

import java.util.concurrent.locks.ReentrantLock;

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.setName("客户1");
        c2.setName("客户2");
        c1.start();
        c2.start();
    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //    public synchronized void deposite(double amt) {
//
//            if (amt > 0) {
//                balance += amt;
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(Thread.currentThread().getName() + "存钱成功，账户余额： " + balance);
//
//
//
//    }
//    public  void deposite(double amt) {
//        synchronized (this) {
//            if (amt > 0) {
//                balance += amt;
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(Thread.currentThread().getName() + "存钱成功，账户余额： " + balance);
//        }
//
//
//    }
    ReentrantLock lock = new ReentrantLock(true);

    public void deposite(double amt) {
        try {

            lock.lock();
            if (amt > 0) {
                balance += amt;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，账户余额： " + balance);
        } finally {
            lock.unlock();
        }


    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposite(1000);

        }
    }
}
