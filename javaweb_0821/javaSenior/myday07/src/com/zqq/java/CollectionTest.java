package com.zqq.java;

import org.junit.Test;

import java.util.*;

public class CollectionTest {
    @Test
    public void test1() {
        //1.contains()
        Collection coll = new ArrayList();
        coll.add(121);
        coll.add(122);
        coll.add(new String("aa"));
        System.out.println(coll.contains(new String("aa")));
        Person p = new Person("张三");
        coll.add(p);
        System.out.println(coll.contains(p));
        System.out.println(coll.contains(new Person("张三")));
        //2.containsAll(Collection coll1)
        Collection coll1 = Arrays.asList(121, 123);
        System.out.println(coll.containsAll(coll1));
        //remove(Object obj);
        //removeAll(Collection coll1);差集
        //retainAll(Collection coll1);求交集
        //equals(Object obj);判断当前集合和形参集合是否完全相同
        //hashCode();object中，重写
        //toArray();
    }
    @Test
    public  void test2(){
        List<int[]> list = Arrays.asList(new int[]{123, 125});
        List<Integer> list3 = Arrays.asList(new Integer[]{123, 125,126,});
        List<Integer> list4 = Arrays.asList(new Integer[]{123, 125,126});
        List list2 = Arrays.asList(123);
        System.out.println(list.size());
        System.out.println(list2.size());
        System.out.println(list3.size());
        list3.retainAll(list4);

    }
    @Test
    public  void test3(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add(124);
        coll.add("tom");
        Iterator iteratoro = coll.iterator();
//        while (coll.iterator().hasNexto()){

//            System.out.println(coll.iterator().next());
//        }
//        while (iterator.hasNext()){
//            System.out.println(coll.iterator().next());
//        }
//        while (coll.iterator().hasNext()){
//            System.out.println(iterator.next());
//        }

    }
}
