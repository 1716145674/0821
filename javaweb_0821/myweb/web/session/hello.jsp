<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/10/7
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
sessionId:<%= session.getId()%>
<br><br>
isNew:<%= session.isNew()%>
<br><br>
maxInactiveInterval:<%= session.getMaxInactiveInterval()%>
<br><br>
lastAccessedTime:<%= session.getLastAccessedTime()%>
<br><br>

hello<%=request.getParameter("userName")%>
<br><br>
<% session.setAttribute("userName",request.getParameter("userName"));%>
<a href="<%=response.encodeURL("login.jsp")%>">重新登录</a>
<a href="<%=response.encodeURL("logout.jsp")%>">注销</a>
</body>
</html>
