package com.zqq.prototype;

/**
 * 原型模式 ：就是将一个对象的属性方法完全复制过来成为一个新的对象，两者的hashcode不同不是同一个对象
 * 步骤是1.将需要克隆的对象实现clonealbe接口 实现clone方法 ，调用super.clone 方法返回一个当前对象。
 *       使用时通过当前对象调用clone方法即可。
 */
public class Sheep implements Cloneable{
    private String name;
    private Integer age;
    private String color;

    @Override
    protected Sheep clone()  {
        Sheep clone=null;
        try {
            clone = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Sheep(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Sheep() {
    }
}
