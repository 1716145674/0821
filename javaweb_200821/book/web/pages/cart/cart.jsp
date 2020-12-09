<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>

    <%--    静态引入jsp页面的 base css jQuery框架--%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            $(".deleteItem").click(function () {
                return confirm("确定删除"+ $(this).parent().parent().find("td:first").text()+"吗？");
            });
            $("#clearCart").click(function () {
                return confirm("确定清空购物车吗？")
            });
            $(".itemCount").change(function () {
                var name =$(this).parent().parent().find("td:first").text();
                var count=$(this).val();
                var inputContentReg = /^[0-9]*$/;
                if (!inputContentReg.test(count)) {
                    alert("输入的格式不正确。请输入正确数字");
                    this.value=this.defaultValue;
                    return false;
                }
                if (confirm("确定将【"+name+"】的数量改为 "+count+" 吗")){
                    var bookId=$(this).attr("bookId");
                    location.href="${requestScope.basePath}manager/carServlet?actionMethod=updateCount&bookId="+bookId+"&count="+count;
                }else {
                    this.value=this.defaultValue;
                }
            })

        })

    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>

    <%--    静态引入登录成功后menu菜单--%>
    <%@include file="/pages/common/login_success_menu.jsp" %>

</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${sessionScope.car.carItems}" var="item">
            <tr>
                <td>${item.value.name}</td>
                <td>
                    <input type="text" style="width: 50px"  bookId="${item.value.id}" class="itemCount" value="${item.value.itemCount}">
                </td>
                <td>${item.value.itemPrice}</td>
                <td>${item.value.itemTotalPrice}</td>
                <td><a class="deleteItem" href="manager/carServlet?actionMethod=delete&bookId=${item.value.id}">删除</a></td>
            </tr>
        </c:forEach>


        <c:if test="${ empty sessionScope.car.carItems}">
            <tr>
                <td colspan="5">
                <a href="index.jsp">您的购物车暂无商品，快去商场中购物吧！</a>
                </td>
            </tr>
        </c:if>
    </table>
    <c:if test="${ not empty sessionScope.car.carItems}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.car.carCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.car.carTotalPrice}</span>元</span>
            <span class="cart_span"><a  id="clearCart" href="manager/carServlet?actionMethod=clear">清空购物车</a></span>
            <span class="cart_span"><a href="manager/orderServlet?actionMethod=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%--    静态引入jsp页面的页脚--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>