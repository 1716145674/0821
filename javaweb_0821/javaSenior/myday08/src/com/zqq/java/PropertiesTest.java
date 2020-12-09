package com.zqq.java;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        FileInputStream jdbc = new FileInputStream("jdbc.properties");
        pros.load(jdbc);
        String key = pros.getProperty("name");
        String value = pros.getProperty("pasword");
        System.out.println(key+"==="+value);
    }
//    @Test
//    public  void test()  {
//        Properties pros = new Properties();
//        FileInputStream jdbc = new FileInputStream("jdbc.properties");
//        pros.load(jdbc);
//        String key = pros.getProperty("name");
//        String value = pros.getProperty("pasword");
//        System.out.println(key+"==="+value);
//
//
//
//
//
//
//    }
}
