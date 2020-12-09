package com.atguigu.test;

import com.atguigu.domain.Item;
import com.atguigu.service.ItemService;
import org.junit.Test;

import java.io.IOException;

public class TestForExam {
    @Test
    public void testItems() {
        ItemService itemService;

        {
            try {
                itemService = new ItemService();
//                Item[] items = itemService.getItems();
//                for (int i = 0; i < items.length; i++) {
//                    System.out.println(items[i]);
//                }
                Item item = itemService.getItem(1);
                System.out.println(item);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
