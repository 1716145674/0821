package com.zqq.datastructure;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "林冲", "豹子头");
        HeroNode hero3 = new HeroNode(3, "武松", "行者");
        SingleLinkedList list = new SingleLinkedList();
//        list.add(hero1);
//        list.add(hero2);
//        list.add(hero3);
//        list.list();
        list.addByOrder(hero2);
        list.addByOrder(hero1);
        list.addByOrder(hero3);
        list.list();



    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");


    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null)
                break;
            if (temp.next.getNo() > heroNode.getNo())
                break;
            if (temp.next.getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("添加冲突，英雄已经存在");
        }
        heroNode.next=temp.next;
        temp.next=heroNode;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;

        while (true) {
            if (temp == null)
                break;
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private String aliName;//别名
    public HeroNode next;

    public HeroNode(int no, String name, String aliName) {
        this.no = no;
        this.name = name;
        this.aliName = aliName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliName() {
        return aliName;
    }

    public void setAliName(String aliName) {
        this.aliName = aliName;
    }

    @Override
    public String toString() {
        return "heroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", aliName='" + aliName +

                '}';
    }
}
