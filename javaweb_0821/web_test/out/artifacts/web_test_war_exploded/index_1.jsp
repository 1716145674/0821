<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>

    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var content = $(this).parent().parent().find("td:eq(1)").text();
                var flag = confirm("确定删除" + content + "吗");
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
            <td align="center"><input type="submit" value="query"></td>
            <td align="center"><a href="newCustomer.jsp" style="text-decoration: none">Add New Customer </a></td>
        </tr>
    </table>
    <br>
    <hr>
    <br>
</form>
<c:if test="${requestScope.customers!=null}">
    <div id="customers">
        <table border="1" cellspacing="0" cellpadding="10 " align="center">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>地址</th>
                <th>电话</th>
                <th>UPDATE/DELETE</th>
            </tr>
            <c:forEach items="${requestScope.customers} " var="cust">
                <tr>
                    <td> ${cust.id}</td>
                    <td>${cust.name}
                    </td>
                    <td>${cust.address}
                    </td>
                    <td>${cust.phone}
                    </td>
                    <td>
                        <c:url value="/showOldCustomer_1.do" var="showCust">
                            <c:param name="id" value="${cust.id}"></c:param>
                        </c:url>
                        <a href=${showCust}>UPDATE</a>

                        <c:url value="/delete.do" var="deleteEdit">
                            <c:param name="id" value="${cust.id}"></c:param>
                        </c:url>
                        <a class="delete" href=${deleteEdit}>DELETE</a>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
</c:if>
</body>
</html>
