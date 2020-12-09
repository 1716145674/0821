package com.zqq.exer;

import org.junit.Test;

public class YunSuanFuTest {
    @Test
    public void main() {
        boolean x=true;
        boolean y=false;
        short z=42;
        //if(y == true)
        System.out.println(y=true);
        if((z++==42)&&(y=true)){
            System. out.println("z="+z);
            z++;
            System. out.println("z="+z);

        }
        System.out.println(x=false);
        if((x=false) || (++z==45))  {
            System. out.println("z="+z);
            z++;

        }
        System. out.println("z="+z);

    }

}
