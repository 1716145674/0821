<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.bean.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.sun.xml.internal.ws.api.ha.StickyFeature" %><%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/10/8
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.atguigu.com/foreach/core" prefix="atguigu"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% List<Customer> customers =new ArrayList<Customer>();
        Customer c1 = new Customer(1, "a");
        Customer c2 = new Customer(2, "b");
        Customer c3 = new Customer(3, "c");
        Customer c4 = new Customer(4, "d");
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        request.setAttribute("customers",customers);
        Map<String,Customer> map=new HashMap<String,Customer>();
        map.put("a",c1);
        map.put("b",c2);
        map.put("c",c3);
        map.put("d",c4);
        request.setAttribute("customerMap",map);
    %>
<atguigu:foreachAll items="${requestScope.customers}" var="cust">
    ${cust.id}->${cust.name}
    <br>
    <br>
</atguigu:foreachAll>
<%--<atguigu:foreachMap items="${requestScope.customerMap}" var="cust1">
    ${cust1.key}->${cust1.value.id}->${cust1.value.name} <br>
</atguigu:foreachMap>--%>
<%--<atguigu:foreachAll items="${requestScope.customerMap}" var="cust1">--%>
<%--    ${cust1.key}->${cust1.value.id}->${cust1.value.name} <br>--%>
<%--</atguigu:foreachAll>--%>
</body>
</html>
