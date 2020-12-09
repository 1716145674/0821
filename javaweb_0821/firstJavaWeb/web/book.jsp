<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/10/6
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <a href="books.jsp"> return</a>
<%
    String bookName = request.getParameter("name");

    Cookie[] cookies = request.getCookies();
    List<Cookie> booksName =new ArrayList<>();
    Cookie tempCookie=null;
    if (cookies!=null&&cookies.length>0){
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            if (cookieName.startsWith("ATGUIGU_BOOK_")){
                booksName.add(cookie);
                if (cookieName.equals(bookName)){
                    tempCookie=cookie;
                }
            }

        }
    }

    if (booksName.size()>=5&&tempCookie==null){
        booksName.get(0).setMaxAge(0);
    }
    if (tempCookie!=null){
        tempCookie.setMaxAge(0);
    }
    Cookie cookie = new Cookie("ATGUIGU_BOOK_" + bookName, bookName);
    response.addCookie(cookie);



%>
</body>
</html>
