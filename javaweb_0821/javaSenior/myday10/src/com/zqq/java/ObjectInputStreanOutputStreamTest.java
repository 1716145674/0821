package com.zqq.java;

import org.junit.Test;

import java.io.*;

public class ObjectInputStreanOutputStreamTest {
    @Test
    public void test() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("sb"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test1() {
        ObjectInputStream ois = null;
        Object o = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            o = ois.readObject();
            System.out.println(o.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }



    }
}

}
