package com.atguigu.webapp.dao;

import com.atguigu.webapp.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BaseDao<T> {
    QueryRunner runner = new QueryRunner();
    private Class clazz;
    public BaseDao(){
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof ParameterizedType){
            ParameterizedType parameterizedType= (ParameterizedType) superclass;
            Type[] typeArgs = parameterizedType.getActualTypeArguments();
            if (typeArgs!=null&&typeArgs.length>0){
                if (typeArgs[0] instanceof Class){
                    clazz= (Class<T>) typeArgs[0];
                }
            }
        }
    }

    public  List<T> getAll( String sql, Object... args) {
        Connection connection=null;
        try {
            connection = JdbcUtils.getConnection();
            return (List<T>) runner.query(connection, sql, new BeanListHandler(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.closeResouce(connection,null,null);
        }
        return null;
    }

    public T get( String sql, Object... args) {
        Connection connection=null;
        try {
            connection = JdbcUtils.getConnection();
            return (T) runner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.closeResouce(connection,null,null);
        }
        return null;
    }

    public List<Map<String, Object>> getNoEntity(String sql, Object... args) {
        Connection connection=null;
        try {
            connection = JdbcUtils.getConnection();

            return runner.query(connection, sql, new MapListHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.closeResouce(connection,null,null);
        }
        return null;
    }

    public boolean update(String sql, Object... args) {
        Connection connection=null;
        int i = 0;
        try {
            connection = JdbcUtils.getConnection();
            i = runner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.closeResouce(connection,null,null);
        }
        if (i > 0) {
            return true;
        }else
            return false;
    }
    public  <E> E getValues(String sql,Object... args){
        Connection connection=null;
        try {
            connection=JdbcUtils.getConnection();
            return (E) runner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.closeResouce(connection,null,null);
        }

        return  null;
    }
}
