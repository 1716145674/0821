package com.zqq2.connection;

import com.zqq2.util.Customer;
import com.zqq2.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtilTest {
    @Test
    public void testUpdate() {
        Connection conn=null;
        try {
            QueryRunner runner = new QueryRunner();
             conn = JDBCUtils.getConnection2();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            int insertCount = runner.update(conn, sql, "makaba", ",makaba@qq.con", "1998-6-6");
            System.out.println(insertCount);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResouse(conn,null);
        }
    }
    @Test
    public  void testQuery1()  {
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection2();
            QueryRunner runner = new QueryRunner();
            String sql="select * from customers where id=?";
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer cust = runner.query(conn, sql, handler, 10);
            System.out.println(cust);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResouse(conn,null);
        }
    }
    @Test
    public  void testQuery2()  {
        Connection conn=null;
        try {
            conn = JDBCUtils.getConnection2();
            QueryRunner runner = new QueryRunner();
            String sql="select count(*) from customers ";
            ScalarHandler handler = new ScalarHandler();
            long count = (long) runner.query(conn, sql, handler);

            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResouse(conn,null);
        }
    }
}
