package com.atguigu.service;

import com.atguigu.domain.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    //改进前的读数据方法
//    public  void  readTextFile(String filename) throws IOException {
//        File file = new File(filename);
//        FileReader fileReader=new FileReader(file);
//        BufferedReader bufferedReader=new BufferedReader(fileReader);
//        //读取文件
//        String data=null;
//        while ((data=bufferedReader.readLine())!=null) {
//            if (data.length()!=0) {
//                System.out.println(data);
//            }
//        }
//
//
//    }
    //改进后的读数据的方法
    private List<String> readTextFile(String filename) throws IOException {
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //读取文件
        List<String> files = new ArrayList<>();
        String data = null;
        while ((data = bufferedReader.readLine()) != null) {
            if (data.length() != 0) {
                files.add(data);
            }
        }
        return files;
    }

    public static final int LINES_PER_ITEM = 6;
    private  int total;
    private Item[] items;

    public ItemService() throws IOException {
        List<String> values = readTextFile("src//Items.txt");
        //计算总共的题数
        total = values.size() / LINES_PER_ITEM;
        items = new Item[total];
        String title = null;
        String[] chose = new String[4];
        char answer = 0;

        for (int j = 0; j < values.size(); j++) {
            if (j % 6 == 0) {
                title = values.get(j);
            } else if (j % 6 == 5) {
                answer = values.get(j).charAt(0);
            } else
                chose[j % 6 - 1] = values.get(j);
            if ((j + 1) % 6 == 0) {
                items[j / 6] = new Item(title, chose, answer);
            }
        }

    }
    public Item getItem(int no){
        if (no<0||no>total){
            throw  new RuntimeException("角标越界，不存在此元素");
        }
        return items[no-1];
    }

    public Item[] getItems() {
        return items;
    }
}
