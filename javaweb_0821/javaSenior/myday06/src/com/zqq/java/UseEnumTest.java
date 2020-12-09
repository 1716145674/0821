package com.zqq.java;

import java.util.Arrays;

public class UseEnumTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
//        System.out.println(spring.getClass().getSuperclass());
        Season[] values = Season.values();
        System.out.println(Arrays.toString(values));
        Thread.State.values();
    }
}

enum Person1 {
    MAN('男'),
    WOMAN('女');
    private final char sex;

    private Person1(char sex) {
        this.sex = sex;
    }

    public char getSex() {
        return sex;
    }


}
interface  info{
    void show();

}
enum Season implements info{
    SPRING("春天"){
        @Override
        public void show() {

        }
    },
    SUMMER("夏天"){
        @Override
        public void show() {

        }
    },
    AUTOME("秋天"){
        @Override
        public void show() {

        }
    },

    WINTER("冬天"){
        @Override
        public void show() {

        }
    };
    private final String seasonName;

    Season(String seasonName) {
        this.seasonName = seasonName;
    }


}

