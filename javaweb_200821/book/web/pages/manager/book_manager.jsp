<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>图书管理</title>

    <%--    静态引入jsp页面的 base css jQuery框架--%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            //给删除按钮添加确认操作
            $("a.delete").live("click", function () {
                var bookName = $(this).parent().parent().find("td:first").text();
                return confirm("确定删除【" + bookName + "】吗？");
            });
        });
    </script>

</head>
<body>
<div id="header">

    <%--    静态引入manager模块的menu菜单--%>
    <%@include file="/pages/common/manager_menu.jsp" %>

    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
</div>

<div id="main" style="height: 80%">
    <table>
        <tr>
            <td colspan="6">
            <td style="align-content: end"><a href="pages\manager\book_create.jsp?&pageNo=${requestScope.page.pageCount}">添加图书</a></td>
        </tr>
        <tr>
            <th>名称</th>
            <th>价格</th>
            <th>作者</th>
            <th>销量</th>
            <th>库存</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td>
                    <a href="manager/bookServlet?actionMethod=showDetails&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a>
                </td>
                <td><a href="manager/bookServlet?actionMethod=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}"class="delete">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--    静态引入图书的分页格式--%>
    <%@include file="/pages/common/page_nav.jsp" %>
</div>
<div style="height: 20%">

    <%--    静态引入jsp页面的页脚--%>
    <%@include file="/pages/common/footer.jsp" %>

</div>
</body>
</html>