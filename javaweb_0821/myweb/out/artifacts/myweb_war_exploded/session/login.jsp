<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/10/7
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="" prefix="c"%>
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
      <% Object userName = session.getAttribute("userName");
      if (userName==null){
          userName="";
      }
      %>

 <form action="<%=response.encodeURL("hello.jsp")%>" method="post">
<%--     userName:<input type="text"  name="userName" value="<%=request.getParameter("userName")==null?"":request.getParameter("userName")%>">--%>
     userName:<input type="text"  name="userName" value="<%=userName%>">
     <input type="submit">
 </form>

</body>
</html>
