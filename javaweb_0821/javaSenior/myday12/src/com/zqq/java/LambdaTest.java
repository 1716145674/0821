package com.zqq.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        Comparator<String> con = (i1, i2) -> i1.compareTo(i2);
        test1();
    }

    @Test
    public void test1() {

        System.out.println(filterString(Arrays.asList("afd", "gaggwg", "wghh"), new Predicate<String>() {


            @Override
            public boolean test(String s) {
                return s.contains("a");
            }
        }));
        List<String> strings = filterString(Arrays.asList("afd", "gaggwg", "wghh"),s->s.contains("h"));
        System.out.println(strings);


    }

    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> list1 = new ArrayList<>();
        for (String str : list) {
            if(predicate.test(str)){
                list1.add(str);
            };
        }
        return list1;

    }

}
