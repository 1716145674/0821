package com.zqq.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("www.baidu.com");
        InetAddress inet2 = InetAddress.getByName("localhost");
        System.out.println(inet2);
        System.out.println(inet1.getHostName());
        System.out.println(inet1.getHostAddress());

    }
}
