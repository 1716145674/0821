package com.zqq.transaction;

import com.zqq.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;

public class ConnectionTest {
    @Test
    public void connectionTest() throws Exception {
        Connection conn = JDBCUtil.getConnection();
        System.out.println(conn);

    }
}
