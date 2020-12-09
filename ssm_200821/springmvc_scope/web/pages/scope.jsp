
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Request 域中的 reqKey1 数据： ${requestScope.reqKey1} <br>
    Request 域中的 reqKey2 数据： ${requestScope.reqKey2} <br>
    <hr>
    Session 域中的 sessionKey1 数据： ${sessionScope.sessionKey1} <br>
    Session 域中的 sessionKey2 数据： ${sessionScope.sessionKey2} <br>
    <hr>
    ServletContext 域中的 servletContextKey1 数据： ${applicationScope.servletContextKey1} <br>
    ServletContext 域中的 servletContextKey2 数据： ${applicationScope.servletContextKey2} <br>
    <hr>
    Request 域中的 key1 数据： ${requestScope.key1} <br>
    Request 域中的 key2 数据： ${requestScope.key2} <br>
    <hr>
    Request 域中的 modelkey1 数据： ${requestScope.modelkey1} <br>
    Request 域中的 modelkey2 数据： ${requestScope.modelkey2} <br>
    <hr>
    Request 域中的 modelMapkey1 数据： ${requestScope.modelMapkey1} <br>
    Request 域中的 modelMapkey2 数据： ${requestScope.modelMapkey2} <br>


</body>
</html>
