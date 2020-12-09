<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>

    <%--    静态引入jsp页面的 base css jQuery框架--%>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单详情</span>

    <%--    &lt;%&ndash;    静态引入登录成功后menu菜单&ndash;%&gt;--%>
    <%--    <%@include file="/pages/common/login_success_menu.jsp" %>--%>
</div>
<div align="center" >
    <a href="${header.get("Referer")}" >返回</a>
</div>
<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>总金额</td>
        </tr>
        <%--        用于tongji--%>
        <c:set var="count" value="${0}"></c:set>
        <c:set var="totalPrice" value="${0}"></c:set>
        <c:forEach items="${requestScope.orderItems}" var="orderItem">

            <tr>
                <td>${orderItem.name}</td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.totalPrice}</td>
                <td hidden><input type="hidden" value="
                    ${count=count+orderItem.count}
                    ${totalPrice=totalPrice+orderItem.totalPrice}">
                </td>
            </tr>
        </c:forEach>

    </table>
    <div class="cart_info">
        <span class="cart_span">此订单中共有<span class="b_count">${count}</span>件商品</span>
        <span class="cart_span">总金额<span class="b_price">${totalPrice}</span>元</span>
    </div>

</div>

<%--    静态引入jsp页面的页脚--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>