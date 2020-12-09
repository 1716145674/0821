package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtils {

    //通过静态代码块实现jdbcUtil类加载时就创建数据库连接池的操作
    //并且可以支持事务操作 通过ThreadLocal<Connection> threadLocal实现
    private static ThreadLocal<Connection> threadLocal;
    private static DruidDataSource dataSource;

    static {
        threadLocal = new ThreadLocal<>();
        try {
            Properties properties = new Properties();
            InputStream is = jdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过jdbc工具类 获得德鲁伊连接池中的一个连接对象
     *
     * @return 德鲁伊连接池中的一个连接对象
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            if (threadLocal.get()==null) {
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("连接失败！！1");
        }


        return threadLocal.get();
    }

    ;

    /**
     * 通过jdbc工具类 关闭德鲁伊连接池中的一个连接对象
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                threadLocal.remove();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    ;
}
