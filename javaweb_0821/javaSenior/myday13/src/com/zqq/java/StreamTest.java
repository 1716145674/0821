package com.zqq.java;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public class StreamTest {
    @Test
    public void test1(){
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        Stream<Integer> stream = list.stream().map(i -> i * i);
//        stream.forEach(i-> {
//            if(i==(list.get(list.size()-1)*list.get(list.size()-1))){
//                System.out.println(i);
//
//            }else
//            System.out.print(i+",");
//        });
//        long count = list.stream().count();
//        System.out.println(count);
//        Integer reduce = list.stream().reduce(0,(x,y)->x+y );
//        System.out.println(reduce);
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);

    }
    @Test
    public void test2(){

        try {
            Class<?> clazz = Class.forName("java.io.File");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor c:constructors){
                System.out.println(c.toString());
            }
//            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
//            File  instance1 = (File) constructor.newInstance("mynew.txt");
//            instance1.createNewFile();

            File instance = (File) clazz.newInstance();
            
//            instance.createNewFile();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        } finally {
        }

    }
}
