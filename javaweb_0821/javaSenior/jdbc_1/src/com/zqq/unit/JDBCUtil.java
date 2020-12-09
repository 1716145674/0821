package com.zqq.unit;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtil {

    public  static Connection getConnection(){
        Connection conn = null;
        try {
            //获取连接所需的数据
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);
            String driverClass = pros.getProperty("driverClass");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            //注册驱动
            Class.forName(driverClass);
            //获得连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     *
     * @param conn
     */
    public  static void   closeResouse(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    /**
     *
     * @param conn
     * @param pros
     */
    public  static void   closeResouse(Connection conn, PreparedStatement pros, ResultSet rs){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if(pros!=null){
            try {
                pros.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }
    public static <T> List<T> getInstance(Class<T> clazz, String sql, Object...args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //获得连接
            conn = getConnection();

            //获得PreparedStatement
            ps= conn.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1, args[i]);
            }
            //获得结果集
            rs = ps.executeQuery();
            //获得结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获得元数据中列的个数
            int columnCount = rsmd.getColumnCount();
            //获得数据库对应的对象ORM（Object relationship mapping）
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i <columnCount ; i++) {
                    //获得结果集中列的数据
                    Object columnValue = rs.getObject(i + 1);
                    //获得元数据中列的名称
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    //通过反射给对象赋属性
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }  finally {
            JDBCUtil.closeResouse(conn,ps,rs);
        }
        return null;
    }
}
