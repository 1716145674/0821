package com.atguigu.homework;

import org.junit.Test;

import java.util.Arrays;

public class SortAlgorithms {
    @Test
    public void  testInsertSort(){
        int [] arr= new int[]{17,3,23,45,6};
        int length=arr.length;
        for (int i = 1; i <length ; i++) {
            if(arr[i]<arr[i-1]){
                int temp=arr[i];
                int j=i-1;
                for(;j>=0&&arr[j]>temp;j--){
                    arr[j+1]=arr[j];
                }
                arr[j+1]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
