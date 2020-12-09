package com.zqq.exam.domain;

import java.util.Arrays;

public class Item {
    String question;
    String[] options;
    char answer;

    public Item(String question, String[] options, char answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public Item() {
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Item{" +
                "question='" + question + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answer=" + answer +
                '}';
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }
}
