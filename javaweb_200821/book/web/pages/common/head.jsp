<%@ page import="com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--获取可以根据客户端访问url不同而不同的base--%>
<%
    String basePath = request.getScheme()
            +"://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";
    request.setAttribute("basePath",basePath);
%>
<!--
设置base标签
-->
<base href="${basePath}">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<link type="text/css" rel="stylesheet" href="static/css/style.css">