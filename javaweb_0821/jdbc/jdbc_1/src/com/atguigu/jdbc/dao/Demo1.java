package com.atguigu.jdbc.dao;

import com.atguigu.jdbc.utils.JDBCDruidUtils;

import java.sql.Connection;

public class Demo1 {
    public static void main(String[] args) {
        Connection connection = JDBCDruidUtils.getConnection();
        
    }
}
