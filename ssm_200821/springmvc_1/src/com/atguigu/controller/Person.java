package com.atguigu.controller;

public class Person {
    private  Integer id;
    private  String name;
    private Car car;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person(Integer id, String name, Car car) {
        this.id = id;
        this.name = name;
        this.car = car;
    }

    public Person() {
    }
}
