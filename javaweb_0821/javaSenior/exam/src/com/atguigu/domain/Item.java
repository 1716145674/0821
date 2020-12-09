package com.atguigu.domain;

import java.util.Arrays;
import java.util.Objects;

public class Item {
    private String title;
    private String[] chose;
    private char answer;

    public Item() {
    }

    public Item(String title, String[] chose, char answer) {
        this.title = title;
        this.chose = chose;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getChose() {
        return chose;
    }

    public void setChose(String[] chose) {
        this.chose = chose;
    }

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return answer == item.answer &&
                Objects.equals(title, item.title) &&
                Arrays.equals(chose, item.chose);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(title, answer);
        result = 31 * result + Arrays.hashCode(chose);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", chose=" + Arrays.toString(chose) +
                ", answer=" + answer +
                '}';
    }
}
