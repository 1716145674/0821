package com.atguigu.dao;

import com.atguigu.utils.JDBCDruidUtils;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDaoByDbutils {
/**
     * jdbc通用增删改操作 通过ThreadLocal 尽心事务操作 set（）get（） remove（）
     * @param sql
     * @param args
     * @return
     */

    QueryRunner runner =new QueryRunner();
    public int update(String sql, Object... args) throws SQLException {
         return runner.update(JDBCDruidUtils.getConnection(),sql,args);
    }

/*
*
     * 通用的查询无实体类对应结果集
     *
     * @param sql
     * @param args
     * @return
*/


    public List<Map<String, Object>> getBeansNoEntity(String sql, Object... args) throws SQLException {
        return  runner.query(JDBCDruidUtils.getConnection(),sql, new MapListHandler(),args);
    }

/*
*
     * 获得单行数据
     *
     * @param sql
     * @param args
     * @return
*/


    public Object getValue(String sql, Object... args) throws SQLException {
        return runner.query(JDBCDruidUtils.getConnection(),sql, new ScalarHandler(), args);
    }

/**
     * 通用的查询有实体类对应结果集的单个数据
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return*/


    public <T> T getBean(Class clazz, String sql, Object... args) throws SQLException {
        return (T) runner.query(JDBCDruidUtils.getConnection(),sql, new BeanHandler<>(clazz),args);
    }

/**
     * 通用的查询有实体类对应结果集的结果集合
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */

    public <T> List<T> getBeans(Class clazz, String sql, Object... args) throws SQLException {

        return (List<T>) runner.query(JDBCDruidUtils.getConnection(),sql,new BeanListHandler<>(clazz),args);
    }
}
