package com.zqq.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void test1() throws IOException {
        Properties pros = new Properties();
        pros.load(new FileInputStream("jdbc.properties"));
        String user = pros.getProperty("user");
        String pass = pros.getProperty("passwords");
        System.out.println(user+pass);


    }
    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        ClassLoader classLoader = PropertiesTest.class.getClassLoader();
        InputStream is = ClassLoader.getSystemResourceAsStream("jdbc1.properties");
        pros.load(is);
        String user = pros.getProperty("user");
        String pass = pros.getProperty("passwords");
        System.out.println("uesr="+user+",passwords="+pass);


    }
}
