package com.atguigu.mapper;


public abstract class BaseDao<T> {
    public abstract void saveEntity(T t);
}
