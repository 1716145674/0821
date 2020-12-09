package com.zqq.java;




    /**
     * 一道面试题
     * @author shkstart
     * @create 2019 上午 11:32
     */
    public class FaceWorkForString {

        String str = new String("good");
        char[] ch = { 't', 'e', 's', 't' };

        public void change(String str, char ch[],FaceWorkForString ex) {
            str = "test ok";
            System.out.println(str);
            System.out.println(ex.str);
            ex.str=new String("fggg");
            ch[0] = 'b';
        }
        public static void main(String[] args) {
            FaceWorkForString ex = new FaceWorkForString();
            ex.str="aff";
            ex.change(ex.str, ex.ch, ex);
            System.out.println(ex.str);//good
            System.out.println(ex.ch);//best
        }
    }



