<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>订单管理</title>

    <%--    静态引入jsp页面的 base css jQuery框架--%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            $(".receive").click(function () {
                return confirm("确认发货吗?");
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单管理系统</span>

    <%--    静态引入manager模块的menu菜单--%>
    <%@include file="/pages/common/manager_menu.jsp" %>


</div>

<div id="main">
    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
            <td>发货</td>
        </tr>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>${order.createTime}</td>
                <td>${order.price}</td>
                <td class="status">
                    <c:choose>
                        <c:when test="${order.status==0}">未发货</c:when>
                        <c:when test="${order.status==1}">已发货</c:when>
                        <c:when test="${order.status==2}">已签收</c:when>
                    </c:choose>
                </td>
                <td><a href="manager/orderServlet?actionMethod=showDetails&orderId=${order.orderId}">查看详情</a></td>
                <td><a class="receive" href="manager/orderServlet?actionMethod=changeOrderStatus&status=1&orderId=${order.orderId}"> 确认发货</a></td>
            </tr>
        </c:forEach>



    </table>
</div>


<%--    静态引入jsp页面的页脚--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>