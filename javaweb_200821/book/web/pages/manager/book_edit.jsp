<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>编辑图书</title>

    <%--    静态引入jsp页面的 base css jQuery框架--%>
    <%@include file="/pages/common/head.jsp" %>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">编辑图书</span>

    <%--    静态引入manager模块的menu菜单--%>
    <%@include file="/pages/common/manager_menu.jsp" %>

</div>

<div id="main">
    <form action="manager/bookServlet" method="post">
        <input type="hidden" name="pageNo" value="${param.pageNo}">
        <input type="hidden" name="actionMethod" value="update">
        <input type="hidden" name="id" value="${requestScope.tempBook.id}">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="${requestScope.tempBook.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.tempBook.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.tempBook.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.tempBook.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.tempBook.stock}"/></td>
                <td><input type="submit" value="修改"/></td>
            </tr>
        </table>
    </form>


</div>

<%--    静态引入jsp页面的页脚--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>