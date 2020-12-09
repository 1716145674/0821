<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/10/8
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://www.atguigu.taglig/my" prefix="my"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<my:hello value="${param.name}" count="10"/>--%>
<%--<my:max num1="${param.num1}"  num2="${param.num2}"></my:max>--%>
<my:readFile src="/WEB-INF/files.txt"/>
</body>
</html>
