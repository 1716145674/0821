<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理</title>

    <%--    静态引入jsp页面的 base css jQuery框架--%>
    <%@include file="/pages/common/head.jsp" %>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">

    <%--    静态引入manager模块的menu菜单--%>
    <%@include file="/pages/common/manager_menu.jsp" %>

    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">后台管理系统</span>
</div>

<div id="main">
    <h1>欢迎管理员进入后台管理系统</h1>
</div>


<%--    静态引入jsp页面的页脚--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>