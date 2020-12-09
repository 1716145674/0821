package com.atguigu.homework;

import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {
    @Test
    public  void homework1(){
        int[] arr =new int[30];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(int)(Math.random()*30+1);
            for (int j = 0; j <i ; j++) {
                if (arr[i]==arr[j]){
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public  void homework1SecondMethod(){
        int[] arr =new int[30];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(int)(Math.random()*30+1);
            boolean flag=false;
            while (true) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] == arr[j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    arr[i] = (int) (Math.random() * 30 + 1);
                    flag = false;
                    continue;
                }
                
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
