package com.zqq.java;

public class EnumTest {
    public static void main(String[] args) {
        Person man = Person.man;
        System.out.println(man);
    }
}

class  Person {
    private final char sex;
    private Person(char sex){
        this.sex=sex;
    }
    public  static final Person man =new Person('男');
    public  static final Person woman=new Person('女');

    public char getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "sex=" + sex +
                '}';
    }
}
