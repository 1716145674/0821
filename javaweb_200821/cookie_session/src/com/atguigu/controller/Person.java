package com.atguigu.controller;

import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private Integer age;
    private Car car;
    private List<Car> carList;
    private Map<String,List<Car>> carMap;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", carList=" + carList +
                ", carMap=" + carMap +
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Map<String, List<Car>> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<String, List<Car>> carMap) {
        this.carMap = carMap;
    }

    public Person() {
    }

    public Person(String name, Integer age, Car car, List<Car> carList, Map<String, List<Car>> carMap) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.carList = carList;
        this.carMap = carMap;
    }
}
