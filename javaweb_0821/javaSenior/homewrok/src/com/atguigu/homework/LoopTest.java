package com.atguigu.homework;

import org.junit.Test;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class LoopTest {
    @Test
    public void homework1Test() {
        int m = 0, n = 3;
        if (m > 0)


//            if (n > 2)
//                System.out.println("A");
//            else if(n==0)
//                System.out.println("B");
//            else
//                System.out.println("c");


            System.out.println("aaa");
        System.out.println("aaa");
    }

    @Test
    public void homework2Test() {
        int x1 = 15;
        int x2 = 13;
        int x3 = 16;
        if (x1 > x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        } else if (x1 > x3) {
            int temp = x1;
            x1 = x3;
            x3 = temp;
        } else if (x2 > x3) {
            int temp = x2;
            x2 = x3;
            x3 = temp;
        }
        System.out.println(x1 + "," + x2 + "," + x3);
    }


    public static  void homework3Test() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入数字");
            int num = scanner.nextInt();
            if (num > 0 && num <= 7) {
                if (num == 7)
                    System.out.println("今天星期日");
                else
                    System.out.println("今天星期" + num);
            } else {
                System.out.println("输入的数字非法");
                break;
            }
        }

    }

    //用来计算当日是当年的第几天
    public  static void  demo1(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 10);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2020, 1, 1);
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis1 = calendar1.getTimeInMillis();
        long l = timeInMillis / (1000*60 * 60 * 24);
        long l1 = timeInMillis1 / (1000*60 * 60 * 24);
        System.out.println(l-l1+1);

    }
    public static  void homework4Test() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份");
        int year = scanner.nextInt();
        System.out.print("请输入月份");
        int month = scanner.nextInt();
        System.out.print("请输入几号");
        int day = scanner.nextInt();

        int sum = day;
        for (int i = 0; i < month - 1; i++) {
            if (i+1==1||i + 1 == 3 || i + 1 == 5 || i + 1 == 7 || i + 1 == 8 || i + 1 == 10) {
                sum += 31;
            } else if (i + 1 == 2) {
                sum += 28;
            } else
                sum += 30;

        }
//        switch (month){
//            case :
//        }
        if (month>2&&(year % 400 == 0 || year % 4 == 0 && year % 100 != 0)) {
            sum += 1;
        }
        System.out.println("这一天是当年的第" + sum + "天");
    }
    public static  void homework5Test() {
        Scanner scanner = new Scanner(System.in);
        int price= (int) ((Math.random() * 90) + 10);
        System.out.println(price);
        System.out.print("请输入你的数字");
        int num = scanner.nextInt();
        if(num==price){
            System.out.println("获得奖励10000");
        }else if ((price/10+price%10*10)==num){
            System.out.println("获得奖励3000");
        }else if ((num%10==price%10)||(num/10==price/10)){
            System.out.println("获得奖励1000");
        }else if (num%10==price/10||num/10==price%10){
            System.out.println("获得奖励500");
        }else
            System.out.println("彩票作废");


    }
    @Test
    public void homework6Test(){
        for (int i = 0; i <3; i++) {
            System.out.println(i);
        }
//        System.out.println(i);
    }
    @Test
    public void homework7Test(){
        int sum=0;
        for (int i=0;i<1000;i++){
            if(i%2==0){
                sum+=i;
            }
        }
        System.out.println(sum);

    }
    @Test
    public void homework8Test(){
        int hight=4;
        for (int i = 0; i <hight ; i++) {
            for (int j = 0; j <i+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    @Test
    public void homework9Test(){
        int hight=4;
        for (int i = 0; i <hight ; i++) {
            for (int j = 4; j >i ; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    @Test
    public void homework10Test(){

        for (int i =1;i<=9;i++){
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+"*"+i+"="+(i*j) + "\t");
            }
            System.out.println();
        }

    }
    @Test
    public void homework11Test(){

        for (int i =9;i>=1;i--){
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+"*"+i+"="+(i*j) + "\t");
            }
            System.out.println();
        }

    }
    @Test
    public void homework12Test(){

//        double i=3000;
        int day=0;
//        while (true){
//            i/=2;
//            day++;
//            if(i<5)
//                break;
//        }
//        System.out.println(day);
        for (int i = 3000; i >=5 ; i/=2) {
            day++;
        }
        System.out.println(day);
    }
    @Test
    public void homework13Test(){
        for (int i = 1; i <=100 ; i++) {
            if (i%13==0){
                continue;
            }
            System.out.println(i);
        }

    }
    @Test
    public void homework14Test(){
        int sum=0;
        for (int i = 1; i <=99 ; i+=2) {
           sum+=i;
        }
        System.out.println(sum);

    }

    public static  void homework15Test(){
        Random random = new Random();
        int num = random.nextInt(100);
        Scanner scanner= new Scanner(System.in);
        int count=0;
        System.out.println("请猜测一次");
        while (true) {
            int i = scanner.nextInt();
            count++;
            if (i==num){
                System.out.println("猜对了");
                break;
            }
            if (i>num){
                System.out.println("大了");
            }else  if (i<num){
                System.out.println("小了");
            }

        }
        System.out.println("一共猜了"+count+"次");
    }
    @Test
    public void homework16Test(){
        for (int i = 1; i <1000 ; i++) {
            int sum=0;
            for (int j = 1; j <=i/2+1 ; j++) {
                if(i%j==0){
                    sum+=j;
                }
            }
            if (i==sum){
                System.out.println(i);
            }
        }

    }

    public static  void homework17Test(){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入月份：");
//        int month = sc.nextInt();
        int month =5;
        System.out.println("请输入日期：");
//        int day = sc.nextInt();
        int day = 15;
        int tempDay=day;
        for(int i =1;i<month;i++){
            if(month==1||month==3||month==5||month==7||month==8||month==10){
                tempDay+=31;
            }else if(month==4||month==6||month==9||month==11){
                tempDay+=30;
            }else{
                tempDay+=28;
            }
        }
        System.out.println(tempDay);

        String[] xq={"星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
        System.out.println("2019年"+month+"月"+day+"是"+xq[tempDay%7]);

    }

    public static void main(String[] args) {
            homework17Test();


    }

}
