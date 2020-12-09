package com.atguigu.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//添加 abstract 表示此类是抽象类不能实例化只用来让子类继承
public abstract class BaseDao<T> {
    QueryRunner runner= new QueryRunner();
    private Class clazz;
    //在创建对象是会得到父类的泛型类型的Class
    public BaseDao(){
        Type superclass = this.getClass().getGenericSuperclass();
        if (superclass instanceof ParameterizedType){
            ParameterizedType parameterizedType= (ParameterizedType) superclass;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            if (typeArguments!=null&&typeArguments.length>0){
                if (typeArguments[0] instanceof Class){
                    clazz= (Class) typeArguments[0];
                }
            }
        }
    }

    /**
     * 根据sql去数据库中增删改数据
     * @param sql sql语句
     * @param args 占位符参数数组
     * @return 执行的条数
     */
    protected int update(String sql,Object... args){
        Connection connection = jdbcUtils.getConnection();
        try {
             return runner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("执行"+sql+"时出现异常 ，sql参数是："+ Arrays.asList(args)+e);
        }finally {
            jdbcUtils.closeConnection(connection);
        }
    }

    /**
     * 根据sql去数据库中查询单条数据
     * @param sql sql语句
     * @param args 占位符参数数组
     * @return 查询到的单个数据
     */
    protected T queryOne(String sql, Object... args){
        Connection connection = jdbcUtils.getConnection();
        try {
             return runner.query(connection,sql, new BeanHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("执行"+sql+"时出现异常 ，sql参数是："+ Arrays.asList(args)+e);
        }finally {
            jdbcUtils.closeConnection(connection);
        }
    }
    /**
     * 根据sql去数据库中查询数据的集合
     * @param sql sql语句
     * @param args 占位符参数数组
     * @return 查询到的数据的集合
     */
    protected List<T> queryList(String sql, Object... args){
        Connection connection = jdbcUtils.getConnection();
        try {
             return (List<T>) runner.query(connection,sql,new BeanListHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("执行"+sql+"时出现异常 ，sql参数是："+ Arrays.asList(args)+e);

        }finally {
            jdbcUtils.closeConnection(connection);
        }
    }
    /**
     * 根据sql去数据库中查询单行单列的值
     * @param sql sql语句
     * @param args 占位符参数数组
     * @return 查询单行单列的值
     */
    protected Object queryForSingleOne(String sql, Object... args){
        Connection connection = jdbcUtils.getConnection();
        try {
            return  runner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("执行"+sql+"时出现异常 ，sql参数是："+ Arrays.asList(args)+e);

        }finally {
            jdbcUtils.closeConnection(connection);
        }
    }
    /**
     * 根据sql去数据库中查询没有javabean对应的list的集合
     * @param sql sql语句
     * @param args 占位符参数数组
     * @return 一个存储map<字段名，值>的list
     */
    protected List<Map<String,Object>> queryListNoEntity(String sql, Object... args){
        Connection connection = jdbcUtils.getConnection();
        try {
            return runner.query(connection, sql, new MapListHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("执行"+sql+"时出现异常 ，sql参数是："+ Arrays.asList(args)+e);
        }finally {
            jdbcUtils.closeConnection(connection);
        }
    }
}

