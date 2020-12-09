package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

public class ReflectTest1 {
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getConstructor(String.class,int.class);
        Person p1 = cons.newInstance("zhangsan", 10);
        p1.setAge(20);
        System.out.println(p1.toString());
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"aaa");
        System.out.println(p1.toString());
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"sfag");


    }
    @Test
    public void test2(){
        int i = new Random().nextInt(2);
        String classpath="";
        switch (i){
            case 0:
                classpath="java.util.Date";
                break;
            case 1:
                classpath="java.lang.Object";

                break;

        }
        Object instance = getInstance(classpath);
        System.out.println(instance);


    }
    public Object getInstance(String classpath){
        Object o=null;
        try {
            Class<?> clazz = Class.forName(classpath);
             o = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }
        return o;


    }
}
