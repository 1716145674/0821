package com.zqq.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    @Test
    public void test1() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1001, "AA");
        map.put(1002, "BB");
        map.put(1003, "AA");

        Set<Object> set = map.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = map.get(key);
            System.out.println(key + "====" + value);
        }

        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Object, Object> next = iterator1.next();
            Object key = next.getKey();
            Object value = next.getValue();


        }


    }

    @Test
    public void test2() {
        int i = 1;
        if (i > 0) {
            System.out.println("11");
        } else if (i == 1) {
            System.out.println("22");
        } else
            System.out.println("333");
        ;
    }

    @Test
    public void test3() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("张");
        buffer.append("三");
        buffer.append("李");
        System.out.println(buffer.toString());
        StringBuffer delete = buffer.delete(0, buffer.length());
        System.out.println(delete);
    }

}
