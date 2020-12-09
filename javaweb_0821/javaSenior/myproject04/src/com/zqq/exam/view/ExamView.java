package com.zqq.exam.view;

import com.zqq.exam.domain.Item;
import com.zqq.exam.service.ItemService;

import java.io.IOException;
import java.util.Scanner;

public class ExamView {
    ItemService itemService = new ItemService();
    char[] answers = new char[itemService.TOTAL_ITEMS];

    public ExamView() {
    }

    //读取用户键盘输入每次只读取一个字母
    public char getUserAction() {
        Scanner sc = new Scanner(System.in);
        char[] canChoseAnswers = {'A', 'B', 'C', 'D', 'N', 'P',};
        String answer = null;
        char key = 0;
        boolean flag = false;
        while (!flag) {
            answer = sc.next();
            key = answer.toUpperCase().charAt(0);
            for (char a : canChoseAnswers) {
                if (a == key) {
                    flag = true;
                    return key;
                }
            }
        }
        return key;

    }

    //显示所想要看到的题目
    public void displayItem(int no) {
        Item item = itemService.getItem(no);
        String question = item.getQuestion();
        String[] options = item.getOptions();
        char answer = item.getAnswer();
        System.out.println();
        System.out.println(question);
        for (String str : options) {
            System.out.println(str);
        }
    }

    public void testExam() {
        int count = 1;
        while (true) {
            displayItem(count);
            char answer = getUserAction();
            switch (answer) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                    answers[count-1] = answer;
//                    break;
                case 'N':
                    if (count<itemService.TOTAL_ITEMS){
                        ++count;
                    }else {
                        System.out.println("已经到达最后一题");
                    } 
                     break;
                case 'P':
                    if (count>1){
                        --count;
                    }else {
                        System.out.println("已经到达第一题");
                    }
                    break;
                case'F':
                    if(confirmEnd("确认退出/Y,否则/N")){
                        try {
                            itemService.saveAnswer(answers);
                            displayResults(answer);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    

            }
        }
    }

    private void displayResults(char answer) {
    }

    /**
     * 是否确认考试结束
     * @param msg
     * @return
     */
    private boolean confirmEnd(String msg) {
        System.out.println();
        System.out.print(msg);

        while (true) {
            char key = getUserAction();
            if (key != 'N' && key != 'Y')
                continue;
            return (key == 'Y');
        }
    }
}
