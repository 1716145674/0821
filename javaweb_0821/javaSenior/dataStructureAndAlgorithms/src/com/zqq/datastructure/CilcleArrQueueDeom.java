package com.zqq.datastructure;

import org.junit.Test;

import java.util.Scanner;

public class CilcleArrQueueDeom {
    public static void main(String[] args) {
        System.out.println("*********测试环形队列*********");
        Scanner scanner = new Scanner(System.in);
        CilcleArrQueue queue = new CilcleArrQueue(10);
        char key = ' ';
        a:while (true) {
            System.out.println("a(add) 添加元素");
            System.out.println("g(get) 获得元素");
            System.out.println("s(show) 展示队列");
            System.out.println("h(head) 展示头部");

            System.out.println("e(exit) 退出");
            char c = scanner.next().toLowerCase().charAt(0);
            switch (c) {
                case 'a':
                    System.out.println("请输入要添加的元素");
                    int next = scanner.nextInt();
                    queue.addValue(next);
                    break;

                case 'g':
                    System.out.println("取得元素为："+queue.getValue());
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'h':
                    System.out.println("取得头部元素为："+queue.getHeadValue());
                    break;
                case 'e':
                    System.out.println("确认退出请输出y");
                    if('y'==(scanner.next().toLowerCase().charAt(0))){
                        return;
                    } else continue ;

            }
        }

    }

    @Test
    public void test() {
        int front = 1;
        int maxSize = 3;

        front = (front++) % maxSize;
        System.out.println(front);
        front = (++front) % maxSize;
        System.out.println(front);
        front = (front + 1) % maxSize;
        System.out.println(front);


    }
}

class CilcleArrQueue {
    private int maxSize;
    private int rear;
    private int front;
    private int[] arr;

    public CilcleArrQueue(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            rear = 0;
            front = 0;
        } else
            throw new RuntimeException("输入的参数有误，队列长度必须大于0");
    }

    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    private boolean isNull() {
        return rear == front;
    }

    public void addValue(int value) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法再添加元素");
        }
        arr[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    public int getValue() {
        if (isNull()) {
            throw new RuntimeException("队列为空，无法再获取元素");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public void showQueue() {
        if (isNull()) {
            throw new RuntimeException("队列为空，无法展示元素");
        }
        int t = 1;
        for (int i = front; i < front + getActualValue(); i++) {
            System.out.println("队列的第" + (t++) + "元素为：" + arr[i]);
        }
    }

    private int getActualValue() {
        return (rear - front + maxSize) % maxSize;
    }

    public int getHeadValue() {
        return arr[front];
    }

}