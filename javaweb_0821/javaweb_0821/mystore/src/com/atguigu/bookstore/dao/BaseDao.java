package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BaseDao {
    QueryRunner runner = new QueryRunner();

    public <T> List<T> QueryAll(Class clazz, String sql, Object... args) {
        try {
            return (List<T>) runner.query(JdbcUtils.getConnection(), sql, new BeanListHandler(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public <T> T Query(Class clazz, String sql, Object... args) {
        try {
            return (T) runner.query(JdbcUtils.getConnection(), sql, new BeanHandler<>(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Map<String, Object>> QueryNoEntity(String sql, Object... args) {
        try {
            return runner.query(JdbcUtils.getConnection(), sql, new MapListHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean Update(String sql, Object... args) {
        int i = 0;
        try {
            i = runner.update(JdbcUtils.getConnection(), sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (i > 0) {
            return true;
        }else
            return false;
    }
}
