package com.zqq.algorithms;

import org.junit.Test;

/*
快速匹配
 */
public class StringTest {
    @Test
    public void test1(){
        String longStr="硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String shortStr="尚硅谷你尚硅你";
//        longStr.contains(shortStr);
        System.out.println(longStr.indexOf("fa",longStr.length()));
        char[] longChars = longStr.toCharArray();
        char[] shortChars = shortStr.toCharArray();
        for (int i = 0; i <longChars.length ; i++) {
            boolean flag=true;
            if(shortChars[0]==longChars[i]){

                for(int j=1,k=i+1;j<shortChars.length;j++,k++){
                      if(shortChars[j]!=longChars[k]){
                          flag=false;
                          break;
                      }
                }
                if(flag==true) {
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}
