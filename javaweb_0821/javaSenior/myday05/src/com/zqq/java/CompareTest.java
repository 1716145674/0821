package com.zqq.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

//使用两个接口中的任何一个comparable comparator
public class CompareTest {
    @Test
    public void test1(){
        String[] arr ={"a","c","b"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1= (String) o1;
                    String s2= (String) o2;
                    return -s1.compareTo(s2);
                }
                throw  new RuntimeException("输入类型异常");

            }
        });
        System.out.println(Arrays.toString(arr));
    }

}
