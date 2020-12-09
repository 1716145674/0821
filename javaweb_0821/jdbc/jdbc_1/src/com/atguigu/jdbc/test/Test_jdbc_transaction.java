package com.atguigu.jdbc.test;

import java.sql.*;

public class Test_jdbc_transaction {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection =null;
        PreparedStatement pst1=null;
        PreparedStatement pst2=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///student", "root", "root");
            connection.setAutoCommit(false);
            pst1 = connection.prepareStatement("sql1");
            pst2 = connection.prepareStatement("sql2");


            connection.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
            connection.rollback();
        } finally {
            if (connection!=null){

                connection.setAutoCommit(true);

                connection.close();
            }
        }

    }
}
