
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope.message!=null}">
    <br>
    <c:set value="${requestScope.message}" var="errorMessage"></c:set>
    <span style="color: #ff0000">${errorMessage} </span>;
    <br>
    <br>
    <hr>
</c:if>
<c:set value="${requestScope.oldCustomer}" var="cust"></c:set>
<c:set var="newCust" value="${requestScope.newCustomer}"></c:set>
<c:if test="${newCust}!=null">
      ${cust}=${newCust};
</c:if>
<%--<%  Customer customer = (Customer) request.getAttribute("oldCustomer");
    Customer newCustomer = (Customer) request.getAttribute("newCustomer");
    if (newCustomer != null) {
        customer = newCustomer;
    }%>--%>

<form action="updateCustomer.do" method="post">
    <input type="hidden" name="id" value=${cust.id}">
    <input type="hidden"  name="oldName" value=${cust.name}>
    <table align="center" border="1" cellpadding="2" cellspacing="0">
        <tr>
            <td><label>CustomerName:</label></td>
            <td><input type="text" name="name" value=${cust.name}></td>
        </tr>
        <tr>
            <td><label>Address:</label></td>
            <td><input type="text" name="address" value=${cust.address}></td>
        </tr>
        <tr>
            <td><label>Phone:</label></td>
            <td><input type="text" name="phone" value=${cust.phone}></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="update"></td>
        </tr>

    </table>
</form>
</body>
</html>
