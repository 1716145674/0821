package com.atguigu.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///student", "root", "root");
        Statement statement = conn.createStatement();
        int i = statement.executeUpdate("update sc set score=0 where sid='09' and cid='01' ");
        if (i!=0){
            System.out.println("YES");
        }else
            System.out.println("NO");

    }
}
