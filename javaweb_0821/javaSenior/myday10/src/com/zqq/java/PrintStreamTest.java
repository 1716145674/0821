package com.zqq.java;

import org.junit.Test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest  {
    @Test
    public void test() throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("hello.txt"));
        PrintStream ps = new PrintStream(fos,true);
        if (ps!=null) {
            System.setOut(ps);
        }
        for (int i = 0; i < 255; i++) {
            System.out.print((char) i);
            if (i % 50 == 0) {
                System.out.println();
            }
        }
    }
    @Test
    public void test1() throws Exception {
        DataOutputStream dos =new DataOutputStream(new FileOutputStream("int.txt"));
        dos.writeUTF("欧皓辰");
        dos.writeInt(12);
        dos.flush();
        dos.close();

    }

    public static void main(String[] args) {
    }
}
