<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.webapp.beans.Customer" %><%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/10/2
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>

    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var content =$(this).parent().parent().find("td:eq(1)").text();
                var flag=confirm("确定删除"+content+"吗");
                return flag;
            })

        })

    </script>
</head>
<body>

<form action="query.do" method="post">
    <table align="center" border="1" cellpadding="2" cellspacing="0">
        <tr>
            <td><label>CustomerName:</label></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><label>Address:</label></td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td><label>Phone:</label></td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td  align="center"> <input type="submit" value="query"></td>
            <td align="center"><a href="newCustomer.jsp" style="text-decoration: none">Add New Customer </a> </td>
        </tr>
    </table>
    <br>
    <hr>
    <br>
    <div id="customers">
        <table border="1" cellspacing="0" cellpadding="10 " align="center">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>地址</th>
                <th>电话</th>
                <th>UPDATE/DELETE</th>
            </tr>
            <% List<Customer> customers = (List<Customer>) request.getAttribute("customers");
                if (customers != null&&customers.size()>0) {
                for (int i = 0; i < customers.size(); i++) {
            %>
            <tr>
                <td><%= customers.get(i).getId()%>
                </td>
                <td><%= customers.get(i).getName()%>
                </td>
                <td><%= customers.get(i).getAddress()%>
                </td>
                <td><%= customers.get(i).getPhone()%>
                </td>
                <td>
                    <a href="showOldCustomer.do?id=<%=customers.get(i).getId()%>">UPDATE</a>
                    <a class="delete" href="delete.do?id=<%=customers.get(i).getId()%>">DELETE</a>
                </td>
            </tr>
            <%
                    }
                }

            %>

        </table>

    </div>
</form>

</body>
</html>
