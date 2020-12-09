package com.zqq.transaction;

import com.zqq.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {
    @Test
    public void transactionTest1() {
        Connection conn = null;
        try {
            //1.自定义连接
            conn = JDBCUtil.getConnection();

            System.out.println("autoCommite: " + conn.getAutoCommit());
            //2.设置自动提交为false
            conn.setAutoCommit(false);
            //3.事务操作
            String sql1 = "update  user_table  set balance=balance-500 where user=?";
            update(conn, sql1, "AA");
            System.out.println(10/0);
            String sql2 = "update  user_table  set balance=balance+500 where user=?";
            update(conn, sql2, "BB");
            System.out.println("操作成功");
            //4.提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //5.出现异常时回滚
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtil.closeResouse(conn, null, null);

        }
    }

    public int update(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResouse(null, ps);
        }
        return 0;
    }

}
