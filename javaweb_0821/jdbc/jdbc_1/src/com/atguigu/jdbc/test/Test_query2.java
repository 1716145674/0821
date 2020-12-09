package com.atguigu.jdbc.test;

import java.sql.*;

public class Test_query2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        //2.1 url 数据库的地址 连接本机可以省略主机端口号 但是必须是三个斜杆 ///
        String url = "jdbc:mysql:///student";
        //String url="jdbc:mysql://localhost:3306/student";
        //2.2 user 用户名
        String user = "root";
        //2.3 password 密码
        String password = "root";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.创建命令发送器
        Statement statement = conn.createStatement();
        //4. 准备sql
        String sql = "select *  from student  ";
        //5. 执行sql 获得结果集
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        //6.处理结果
        while (resultSet.next()){
            for (int i = 0; i <columnCount ; i++) {
                Object o = resultSet.getObject(i+1);
                System.out.print(o+"=>");
            }
            System.out.println();

        }

        //7.关闭资源
        if (statement != null) {
            statement.close();
        }
        if (conn != null) {
            conn.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}
