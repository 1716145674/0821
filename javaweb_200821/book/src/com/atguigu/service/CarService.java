package com.atguigu.service;

import com.atguigu.pojo.Car;

public interface CarService {

    /**
     * 根据图示id把图书添加到购物车中
     * @param car
     * @param bookId
     */
    void addBook2CarById(Car car, Integer bookId);
}
