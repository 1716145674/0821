package com.zqq.exer2;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class StreamTest {
    @Test
    public void test() {
        File file = new File("hello.txt");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(file);
            fw = new FileWriter(file);
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }

    @Test
    public void test1() {
        File srcfile = new File("屏幕截图(510).png");
        File desfile = new File("屏幕截图(510)1.png");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(desfile);
            byte[] data = new byte[10];
            int len;
            while ((len = fis.read(data)) != -1) {

                fos.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void test2() throws Exception {
        FileInputStream fis = new FileInputStream("hello.txt");
        FileOutputStream fos = new FileOutputStream("hello2.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        Scanner scanner = new Scanner(System.in);
        scanner.next();

    }
}
