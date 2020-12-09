<%@ page import="com.atguigu.webapp.beans.Customer" %>
<%@ page import="java.util.concurrent.locks.ReentrantLock" %><%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/10/4
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Object message = request.getAttribute("message");
    if (message != null) {
%>
<br>
<span style="color: red"><%= message%></span>
<br>
<br>
<hr>
<%
    }
%>
<%  Customer customer = (Customer) request.getAttribute("oldCustomer");
    Customer newCustomer = (Customer) request.getAttribute("newCustomer");
    if (newCustomer != null) {
        customer = newCustomer;
    }%>
<form action="updateCustomer.do" method="post">
    <input type="hidden" name="id" value="<%=customer.getId()%>">
    <input type="hidden" name="oldName" value="<%=customer.getName()%>">
    <table align="center" border="1" cellpadding="2" cellspacing="0">
        <tr>
            <td><label>CustomerName:</label></td>
            <td><input type="text" name="name" value="<%=customer.getName()%>"></td>
        </tr>
        <tr>
            <td><label>Address:</label></td>
            <td><input type="text" name="address" value="<%= customer.getAddress()%>"></td>
        </tr>
        <tr>
            <td><label>Phone:</label></td>
            <td><input type="text" name="phone" value="<%= customer.getPhone()%>"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="update"></td>
        </tr>

    </table>
</form>
</body>
</html>
