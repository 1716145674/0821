<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/11/6
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/requestParams" method="post">
    id <input type="text" name="id">
    name <input type="text" name="user">
    hobby <input type="checkbox" name="hobby" value="唱">唱
    <input type="checkbox" name="hobby" value="跳">跳
    <input type="checkbox" name="hobby" value="篮球">篮球
    carid <input type="text" name="car.id">
    carname<input type="text" name="car.name">
    <input type="submit"> 提交
</form>
</body>
</html>
