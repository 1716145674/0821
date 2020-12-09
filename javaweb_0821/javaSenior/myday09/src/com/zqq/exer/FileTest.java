package com.zqq.exer;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File srcFile = new File("D:\\KuGou");
        System.out.println(getAllFilesName(srcFile));

    }

    public static long getAllFilesName(File file){
        File[] subiles = file.listFiles();
        long size=0;
        for (File f:subiles) {
            if (f.isDirectory()) {
                size+=getAllFilesName(f);
            }else {
                System.out.println(f.getAbsolutePath());
                size=f.length();
            }
        }
        return size;
    }
}
