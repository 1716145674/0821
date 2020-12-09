package com.atguigu.dao;

import com.atguigu.utils.JDBCDruidUtils;


import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao {
    /**
     * jdbc通用增删改操作 通过ThreadLocal 尽心事务操作 set（）get（） remove（）
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object... args) {
        Connection connection = JDBCDruidUtils.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sql);
            if (args != null && args.length != 0) {
                for (int i = 0; i < args.length; i++) {
                    pst.setObject(i + 1, args[i]);

                }
            }
            int i = pst.executeUpdate();
            if (i > 0) {
                return i;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCDruidUtils.closeRecourse(connection, pst, null);
        }
        return 0;
    }

    /**
     * 通用的查询无实体类对应结果集
     *
     * @param sql
     * @param args
     * @return
     */
    public List<Map<String, Object>> getBeansNoEntity(String sql, Object... args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Connection connection = JDBCDruidUtils.getConnection();
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            pst = connection.prepareStatement(sql);
            if (args != null && args.length != 0) {
                for (int i = 0; i < args.length; i++) {
                    pst.setObject(i + 1, args[i]);
                }
            }
            ResultSetMetaData metaData = pst.getMetaData();
            int columnCount = metaData.getColumnCount();
            resultSet = pst.executeQuery();
            Map<String, Object> map = null;
            while (resultSet.next()) {
                map = new HashMap<>();
                for (int i = 0; i < columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Object value = resultSet.getObject(i + 1);
                    map.put(columnLabel, value);
                }
            }
            list.add(map);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCDruidUtils.closeRecourse(connection, pst, resultSet);
        }
        return list;

    }

    /**
     * 获得单行数据
     *
     * @param sql
     * @param args
     * @return
     */
    public Object getValue(String sql, Object... args) {
        Connection connection = JDBCDruidUtils.getConnection();
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            pst = connection.prepareStatement(sql);

            if (args != null && args.length != 0) {
                for (int i = 0; i < args.length; i++) {
                    pst.setObject(i + 1, args[i]);
                }
            }
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return resultSet.getObject(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCDruidUtils.closeRecourse(connection, pst, resultSet);
        }
        return null;
    }

    /**
     * 通用的查询有实体类对应结果集的单个数据
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T getBean(Class clazz, String sql, Object... args) {
        List<Object> beans = getBeans(clazz, sql, args);
        if (beans != null) {
            return (T) beans.get(0);
        } else
            return null;
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
    public <T> List<T> getBeans(Class clazz, String sql, Object... args) {
        //创建要存放数据的容器
        List<T> list = new ArrayList<>();
        //获取连接
        Connection connection = JDBCDruidUtils.getConnection();
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            //获得命令发送器
            pst = connection.prepareStatement(sql);
            //循环填充占位符
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    pst.setObject(i + 1, args[i]);
                }
            }
            //执行sql 获得结果集
            resultSet = pst.executeQuery();
            //拿到结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //得到元数据的col数量
            int columnCount = metaData.getColumnCount();
            //遍历结果集
            while (resultSet.next()) {
                //生成数据映射对象
                T t = (T) clazz.newInstance();
                //循环给对象赋属性值
                for (int i = 0; i < columnCount; i++) {
                    //获得对象名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //获得属性Field
                    Field field = clazz.getDeclaredField(columnLabel);
                    //接触属性的封装限制
                    field.setAccessible(true);
                    //获得属性在数据库中的值
                    Object fieldValue = resultSet.getObject(i + 1);
                    //给属性赋值
                    field.set(t, fieldValue);
                }
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCDruidUtils.closeRecourse(connection, pst, resultSet);
        }

        return list;

    }
}
