<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/11/9
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="${pageContext.request.contextPath}/book/1">查询单个</a>
    <a href="${pageContext.request.contextPath}/book">查询所有</a>
    <form action="${pageContext.request.contextPath}/book" method="post">
      <input type="submit" value="提交增加">
    </form>
    <form action="${pageContext.request.contextPath}/book/1" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" value="提交删除">
    </form>
    <form action="${pageContext.request.contextPath}/book/1" method="post">
      <input type="hidden" name="_method" value="put">
      <input type="submit" value="提交修改">
    </form>
  </body>
</html>
