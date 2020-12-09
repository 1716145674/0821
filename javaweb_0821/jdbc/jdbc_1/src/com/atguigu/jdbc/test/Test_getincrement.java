package com.atguigu.jdbc.test;

import java.sql.*;

public class Test_getincrement {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("");
        PreparedStatement pst = connection.prepareStatement("", Statement.RETURN_GENERATED_KEYS);
        ResultSet keys = pst.getGeneratedKeys();
    }
}
