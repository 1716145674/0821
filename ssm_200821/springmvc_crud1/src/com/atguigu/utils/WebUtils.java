package com.atguigu.utils;

public class WebUtils {
    public static Integer parseString(String str){

        Integer integer=0;
        try {
            integer = Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }
        return integer;
    }
}
