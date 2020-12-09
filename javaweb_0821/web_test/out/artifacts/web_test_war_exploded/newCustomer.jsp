<%@ page import="com.atguigu.webapp.beans.Customer" %><%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/10/4
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCustomer</title>
</head>
<body>
<% Object message = request.getAttribute("message");
    if (message != null) {
%>
<br>
<span style="color: #ff0000"><%=message%> </span>;
<br>
<br>
<hr>
<%
    }
%>

<form action="addCustomer.do" method="post">
    <table align="center" border="1" cellpadding="2" cellspacing="0">
        <tr>
            <td><label>CustomerName:</label></td>
            <td><input type="text" name="name" value="<%= request.getParameter("name")==null?"":request.getParameter("name")%>"></td>
        </tr>
        <tr>
            <td><label>Address:</label></td>
            <td><input type="text" name="address" value="<%= request.getParameter("address")==null?"":request.getParameter("address")%>"></td>
        </tr>
        <tr>
            <td><label>Phone:</label></td>
            <td><input type="text" name="phone" value="<%= request.getParameter("phone")==null?"":request.getParameter("phone")%>"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit"></td>
        </tr>

    </table>
</form>
</body>
</html>
