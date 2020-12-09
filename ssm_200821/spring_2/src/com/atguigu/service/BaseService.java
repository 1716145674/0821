package com.atguigu.service;

import com.atguigu.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public  abstract class BaseService<T> {
    @Autowired
    BaseDao<T> baseDao;

    public void saveEntity(T entity){
        baseDao.saveEntity(entity);
    }
}
