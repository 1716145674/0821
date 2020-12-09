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
    <script type="text/javascript">
        $(function () {
            $(":submit").click(function () {
                if ($(":text[name='name']").val() == "" ){
                    alert("请输入书名");
                    return false
                }else {
                    return true;
                }

            });
        });
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">编辑图书</span>

    <%--    静态引入manager模块的menu菜单--%>
    <%@include file="/pages/common/manager_menu.jsp" %>

</div>

<div id="main">
    <form action="manager/bookServlet?actionMethod=create&pageNo=${param.pageNo}" method="post" enctype="multipart/form-data">
        <%--        <input type="hidden" name="actionMethod" value="create">--%>
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td>封面</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value=""/></td>
                <td><input name="price" type="text" value=""/></td>
                <td><input name="author" type="text" value=""/></td>
                <td><input name="sales" type="text" value=""/></td>
                <td><input name="stock" type="text" value=""/></td>
                <td><input type="file" name="img"></td>
                <td><input type="submit" value="添加"/></td>
            </tr>
        </table>
    </form>


</div>

<%--    静态引入jsp页面的页脚--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>