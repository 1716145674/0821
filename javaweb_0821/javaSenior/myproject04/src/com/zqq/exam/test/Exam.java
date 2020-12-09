package com.zqq.exam.test;

import com.zqq.exam.view.ExamView;
import org.junit.Test;

import java.io.IOException;

public class Exam {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExamView examView = new ExamView();
//        while (true) {
//            char c = examView.getUserAction();
//            System.out.println("你输入的答案是" + c);
//        }
        examView.testExam();
    }

    @Test
    //测试输入答案
    public void testInsertAnswet() {
        ExamView examView = new ExamView();
        examView.displayItem(3);
    }
}
