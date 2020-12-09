package com.zqq.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {
    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket(InetAddress.getByName("localhost"), 8866);
            os = socket.getOutputStream();
            os.write("你好。我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void server() {
//        try {
//            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8866);
//            InputStream is = socket.getInputStream();
//            byte[] data = new byte[1024];
//            int len;
//            while ( (len=is.read())!=-1){
//                System.out.println(new String(data,0,len));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//        }
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8866);
            socket = ss.accept();
            is = socket.getInputStream();
            //不建议
//        byte[] data = new byte[1024];
//        int len;
//        while ((len = is.read()) != -1) {
//            System.out.println(new String(data, 0, len));
//        }
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);

            }
            System.out.println(baos.toString());
            System.out.println(socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
