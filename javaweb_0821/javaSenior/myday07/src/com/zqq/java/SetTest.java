package com.zqq.java;

public class SetTest implements Comparable<SetTest>{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SetTest() {
    }

    public SetTest(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(SetTest o) {
        return this.age-o.age;
    }
}
