<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AddCustomer</title>
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
<form action="addCustomer.do" method="post">
    <table align="center" border="1" cellpadding="2" cellspacing="0">
        <tr>
            <td><label>CustomerName:</label></td>
            <td><input type="text" name="name"
                       value=${param.name==null?"":param.name}></td>
        </tr>
        <tr>
            <td><label>Address:</label></td>
            <td><input type="text" name="address"
                       value=${param.address==null?"":param.address}></td>
        </tr>
        <tr>
            <td><label>Phone:</label></td>
            <td><input type="text" name="phone"
                       value=${param.phone==null?"":param.phone}></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit"></td>
        </tr>

    </table>
</form>
</body>
</html>
