package com.atguigu.bookstore.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
    public static void main(String[] args) {
        Connection connection = getConnection();
        System.out.println(connection);
    }
    private static DataSource dataSource;
    private  static ThreadLocal<Connection> local = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        try {
            if (local.get() == null) {
                Connection connection = dataSource.getConnection();
                local.set(connection);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return local.get();
    }
    public  static void closeResouce(Connection connection, Statement statement, ResultSet resultSet){
        if (connection!=null){
            try {
                local.remove();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement!=null){

            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }
}
