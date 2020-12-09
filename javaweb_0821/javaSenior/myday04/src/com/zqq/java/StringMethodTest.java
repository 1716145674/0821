package com.zqq.java;

import org.junit.Test;

public class StringMethodTest {
    @Test
    public void test1() {
        String s1 = "hellorworld";
        int i2 = s1.indexOf("or", 4);
        System.out.println(i2);
        int i = s1.lastIndexOf("or");
        System.out.println(i);
        int i1 = s1.lastIndexOf("or", 5);
        System.out.println(i1);
    }

    public String resverse(String str, int startIndex, int endIndex) {
        if (str != null && str.trim().length() != 0) {
            char[] arr = str.toCharArray();
            for (int i = startIndex, j = endIndex; i < j; i++, j--) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return new String(arr);
        }


        return str;
    }

    public String reverse(String str, int startIndex, int endIndex) {
        if (str != null && str.trim().length() != 0) {
            StringBuilder stringBuilder = new StringBuilder(str.length());
            stringBuilder.append(str.substring(0, startIndex));
//            StringBuilder stringBuilder1 = new StringBuilder(str.substring(startIndex, endIndex + 1));
//            stringBuilder1.reverse();
//            stringBuilder.append(stringBuilder1);
            for (int i = endIndex; i >= startIndex; i--) {
                stringBuilder.append(str.charAt(i));

            }
            stringBuilder.append(str.substring(endIndex + 1));
            return stringBuilder.toString();
        }


        return str;
    }

    public int acount(String longStr, String shortStr) {
        int acount = 0;
        int index = 0;

        if (longStr.length() >= shortStr.length() && shortStr != null && shortStr.trim().length() != 0) {


            while ((index = longStr.indexOf(shortStr, index)) != -1) {
                acount++;
                index += shortStr.length();
            }
            return acount;

        } else
            return acount;

    }

    public String getMaxString(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        for (int i = 0; i < str1Len; i++) {

            for (int j = 0, k = str2Len - i; k <= str2Len; j++, k++) {
                String substring = str2.substring(j, k);
                if (str1.contains(substring)) {
                    return substring;
                }
            }

        }
        return null;

    }

    @Test
    public void test2() {
//        String str="abcdefghijklmn";
//        String resverse = resverse(str, 5, 9);
//        System.out.println(resverse);
//        String reverse = reverse(str, 5, 9);
//        System.out.println(reverse);

//        String str1 = "afafdfdaffdfqeeqgafaf";
//        int acount = acount(str1, "af");
//        System.out.println(acount);

        String str1 = "afdgasgdaqefa";
        String str2 = "adgasg";
//        String substring = str2.substring(0, 6);
//        System.out.println(substring);
//
//        boolean contains = str1.contains("dgasg");

//        System.out.println(contains);
        String maxString = getMaxString(str1, str2);
        System.out.println(maxString);


    }

    @Test
    public void test3() {
        String str = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder);
        StringBuilder stringBuilder1 = new StringBuilder(str);
        System.out.println(stringBuilder1.length());
    }
}
