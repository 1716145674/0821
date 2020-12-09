package com.zqq2.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

public class C3P0Test {
    @Test
    public  void C3P0Test1() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("myC3P0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);

    }
}
