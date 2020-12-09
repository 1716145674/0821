<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/10/6
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies!=null&&cookies.length>0){
        for (Cookie cookie : cookies) {
            out.print("cookieName :"+cookie.getName());
            out.println();
            out.print(cookie.getMaxAge());
        }

    }else {
        out.println("不存在cookie 正在创建");
        Cookie cookie = new Cookie("name", "atguigu");
        response.addCookie(cookie);

    }

%>

</body>
</html>
