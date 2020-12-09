package com.zqq.exam.service;


import com.zqq.exam.domain.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    Item[] items;
    private final String SRC_FIlENAME = "myproject04//Items.txt";
    private final String DESC_FIleNAME = "myproject04//answer.dat";
    private final int LINES_PER_ITEM = 6;
    public final int TOTAL_ITEMS;

    public ItemService() {

        List<String> values = readTestFile(SRC_FIlENAME);
        TOTAL_ITEMS = values.size() / LINES_PER_ITEM;
        items = new Item[TOTAL_ITEMS];
        for (int i = 0; i < TOTAL_ITEMS; i++) {

            String question = values.get(i * LINES_PER_ITEM);
            String[] options = new String[]{
                    values.get(i * LINES_PER_ITEM + 1),
                    values.get(i * LINES_PER_ITEM + 2),
                    values.get(i * LINES_PER_ITEM + 3),
                    values.get(i * LINES_PER_ITEM + 4)
            };
            char answer = values.get(i * LINES_PER_ITEM + 5).charAt(0);
            items[i] = new Item(question, options, answer);
        }
    }

    public Item getItem(int no) {
        if (no > 0 && no <= TOTAL_ITEMS) {
            return items[no - 1];
        }

        throw new RuntimeException("题目定位出错");

    }

    private List<String> readTestFile(String fileName) {
        List<String> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String str;
            while ((str = br.readLine()) != null) {
                if (str.length() != 0)
                    list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public void saveAnswer(char[] answer) throws IOException {
        File file = new File("myproject04//answer.dat");
        if (file.exists()){
            file.delete();
            file.createNewFile();
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(answer);


    }
}
