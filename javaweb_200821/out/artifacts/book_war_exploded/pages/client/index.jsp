<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>书城首页</title>
    <%--   静态引入头部代码 css jquery  base --%>
    <%@ include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            //用户注销验证
            $("a.logout").click(function () {
                return confirm("确认注销用户吗？");
            });
            //添加购购物跳转事件
            $(".book_add_btn").click(function () {
                //添加购物车成功提示
                var $bookName = $(this).attr("bookName");
                //添加购物车跳转
                var $bookId = $(this).attr("bookId");
                location.href = "${requestScope.basePath}/manager/carServlet?actionMethod=addBookItem&bookId=" + $bookId
                    + "&bookName=" + $bookName;

            })
        })
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${ empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.name}</span>光临尚硅谷书城</span>
            <a href="manager/orderServlet?actionMethod=showOrder">我的订单</a>
            <a class="logout" href="userServlet?actionMethod=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="actionMethod" value="queryWithCriteria">
                <table>
                    <tr>
                        <td>价格：</td>
                        <td><input id="min" type="text" name="minPrice" value="${param.minPrice}"></td>
                        <td> 元-</td>
                        <td><input id="max" type="text" name="maxPrice" value="${param.maxPrice}"></td>
                        <td>元</td>
                        <td>书名：</td>
                        <td><input type="text" id="bookName" name="name" value="${param.name}"></td>
                        <td>作者：</td>
                        <td><input type="text" id="bookAuthor" name="author" value="${param.author}"></td>
                        <td><input type="submit" value="查询"/></td>
                    </tr>
                </table>


            </form>
        </div>
        <div style="text-align: center">

            <c:choose>
                <c:when test="${ not empty sessionScope.user}">
                    <span>您的购物车中有${sessionScope.car.carCount}件商品</span>
                    <c:if test="${ not empty sessionScope.bookName}">
                        <div>
                            您刚刚将<span style="color: red" class="selectedBook">${sessionScope.bookName}</span>加入到了购物车中
                        </div>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <span>您的购物车中有0件商品</span>
                    <div>
                        您还没登录！
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${book.id}" bookName="${book.name}" class="book_add_btn">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <%--    静态引入图书的分页格式--%>
    <%@include file="/pages/common/page_nav.jsp" %>

    <%@include file="/pages/common/footer.jsp" %>

</body>
</html>