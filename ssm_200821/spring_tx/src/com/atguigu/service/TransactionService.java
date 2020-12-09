package com.atguigu.service;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Autowired
    BookDao bookDao;

    @Autowired
    UserDao userDao;
    @Transactional ()//相当于切入点表达式
    public void multiUpdate(){
            bookDao.updateBook();
            int i =10/0;
            userDao.updateUser();

    }

}
