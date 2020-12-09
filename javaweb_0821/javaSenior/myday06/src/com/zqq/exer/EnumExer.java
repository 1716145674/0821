package com.zqq.exer;

public class EnumExer {
}
enum Color implements ReflectColor{
    RED(255,0,0){
        @Override
        public String meaning() {
           return "我是红色，我反射红色的光";
        }
    },
    BLUE(0,0,255){
        @Override
        public String meaning() {
            return "我是蓝色，我反射蓝色的光";
        }
    },
    BLACK(0,0,0){
        @Override
        public String meaning() {
            return "我是黑色，我不反射光";
        }
    },
    YELLOW(255,255,0){
        @Override
        public String meaning() {
            return "我是黄色，我反射黄色的光";
        }
    },
    GREEN(0,255,0){
        @Override
        public String meaning() {
            return"我是绿色，我反绿色的光" ;
        }
    };

    private int redValue;
    private int greenValue;
    private int blueValue;


    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public String toString() {
        return "Color{" +
                "redValue=" + redValue +
                ", greenValue=" + greenValue +
                ", blueValue=" + blueValue +
                '}';
    }
}
interface ReflectColor{
    String meaning();
}

class Works{
    public static void main(String[] args) {
        System.out.println(Color.RED.meaning());

    }
}
