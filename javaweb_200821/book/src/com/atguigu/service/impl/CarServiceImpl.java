package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Car;
import com.atguigu.pojo.CarItem;
import com.atguigu.service.CarService;

public class CarServiceImpl implements CarService {
    BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook2CarById(Car car, Integer bookId) {
        car.addItem(getCarItemByBookId(bookId));
    }

    private CarItem getCarItemByBookId(Integer bookId){
        Book book = bookDao.queryBookById(bookId);
       return new CarItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
    }
}
