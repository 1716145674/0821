<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书列表</title>
    <style type="text/css">
        table {
            border: 1px blue solid;
            width: 700px;
            border-collapse: collapse;
        }

        td, th {
            border: 1px green solid;
        }

        div.menu {
            width: 700px;
            text-align: right;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            var deleteA=function(){
                var  name = $(this).parent().parent().find("td:first").text();
                return confirm("确定删除【"+name+"】吗？")
            };
            $("a.delete").live("click",deleteA);
        })
    </script>
</head>
<body>
<center>
    <h2>图书列表管理页面</h2>
    <div class="menu"><a href="${pageContext.request.contextPath}/book/bookEdit.jsp">添加图书</a></div>
    <table>
        <tr bgcolor="#FF8888">
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>销量</th>
            <th>库存</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a class="delete" href="${pageContext.request.contextPath}/book/delete?pageNo=${param.pageNo}&id=${book.id}">删除</a></td>
                <td><a href="${pageContext.request.contextPath}/book/getBook?pageNo=${param.pageNo}&id=${book.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
    <%@include file="/common/page_nav.jsp" %>
</center>
</body>
</html>