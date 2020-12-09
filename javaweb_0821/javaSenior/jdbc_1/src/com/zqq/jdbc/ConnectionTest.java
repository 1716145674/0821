package com.zqq.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    @Test
    public void test2() throws Exception {
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    @Test
    public void test3() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        Connection connection = DriverManager.getConnection(url, info);
        System.out.println(connection);
    }

    @Test
    public void test4() throws Exception {
        //1.获得连接所要的信息
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        //2.加载驱动
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver=(Driver)aClass.newInstance();
//        DriverManager.registerDriver(driver);
        //3.获得连接
        Connection connection = DriverManager.getConnection(url, info);
        System.out.println(connection);
    }

    @Test
    public void finalTest() throws IOException, ClassNotFoundException, SQLException {
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        //2.获得驱动
        Class.forName(driverClass);
        //3.连接
        DriverManager.getConnection(url, user, password);

    }

    @Test
    public void completeTest() {
        //1.获取连接需要的四个基本数据。classdriver，url，user，password
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);
            String driverClass = pros.getProperty("driverClass");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");

            //2.加载driver
            Class.forName(driverClass);
            //3.连接
            connection = DriverManager.getConnection(url, user, password);
            //4.获得sql
            String sql = "insert into customers(name,email,birth) values (?,?,?)";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, "哪吒");
            preparedStatement.setString(2, "13313@qq.com");
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1997-10-1");
            preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
            preparedStatement.execute();
            System.out.println("chenggong");
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(preparedStatement!=null){

                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }


    }

}
