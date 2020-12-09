package com.atguigu.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonTest {
    @Test
    public void bean() {
        Car car = new Car("宝马", "a3");
        Car car1 = new Car("奔驰", "a4");
        Car car2 = new Car("奥迪", "a5");
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        List<Car> cars1 = new ArrayList<>();
        cars1.add(car);
        List<Car> cars2 = new ArrayList<>();
        cars2.add(car1);

        List<Car> cars3 = new ArrayList<>();
        cars3.add(car2);

        Map<String, List<Car>> carMap = new HashMap<>();
        carMap.put("BBA之宝马", cars1);
        carMap.put("BBA之奔驰", cars2);
        carMap.put("BBA之奥迪", cars3);

        Person person = new Person("张三", 18, car, cars, carMap);
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(person);
        System.out.println(jsonPerson);
        Person person1 = gson.fromJson(jsonPerson, person.getClass());
        System.out.println(person1);

    }

    @Test
    public void list() {
        Car car = new Car("宝马", "a3");
        Car car1 = new Car("奔驰", "a4");
        Car car2 = new Car("奥迪", "a5");
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(cars);
        System.out.println(jsonStr);
        List<Car> o = gson.fromJson(jsonStr, new TypeToken<List<Car>>() {}.getType());
        System.out.println(o.get(1));
    }

}
