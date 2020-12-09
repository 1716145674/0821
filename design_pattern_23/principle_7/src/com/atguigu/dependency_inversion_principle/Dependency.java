package com.atguigu.dependency_inversion_principle;

import sun.applet.Main;

import java.util.Iterator;

public class Dependency {

    public static void main(String[] args) {
        OpenAndClose openAndClose = new OpenAndClose(new XiongMaoTv());
        openAndClose.open();

    }

}
