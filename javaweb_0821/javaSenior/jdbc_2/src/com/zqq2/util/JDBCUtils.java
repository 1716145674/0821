package com.zqq2.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    /**
     * 使用C3P0获得连接
     * @return
     * @throws SQLException
     */
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("myC3P0");
    public static Connection getConnection1() throws SQLException {
        Connection conn = cpds.getConnection();
        return conn;
    }
    /**
     * 使用druid获得连接
     * @return
     * @throws SQLException
     */
    private static DataSource dataSource=null;
    static {
        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbcForDruid.properties");
            pros.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static  Connection getConnection2() throws SQLException {
        Connection conn = dataSource.getConnection();
        return conn;
    }

    public static void closeResouse(Connection conn, PreparedStatement pros) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (pros != null) {
                try {
                    pros.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }

        }
    }

    /**
     * @param conn
     * @param pros
     */
    public static void closeResouse(Connection conn, PreparedStatement pros, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if (pros != null) {
            try {
                pros.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }
}
