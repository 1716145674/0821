<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/9/3
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--
    1.导入 JQurey 库
    2.获取name=username 的节点： username
    3.1为username添加change响应函数
    3.2获取username的value属性值，去除前后空格且不为空，准备发送Ajaxqingqiu
    3.3发送Ajax请求检验username是否可用
    3.4 在服务端返回一个HTML片段
    3.5 在客户端浏览器把其直接添加到#messagede html中

    -->
</head>
<body>
    <form action="" method="post">
        userName:<input type="text" name="username"/>
      <br>
<%--        <div id="message"> <font color="red"> 该用户已经存在！</font></div>--%>
        <div id="message"></div>
            <br>

        <input type="submit" value="submit"/>
    </form>

</body>
</html>
