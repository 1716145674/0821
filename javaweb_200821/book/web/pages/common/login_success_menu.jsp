
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.name}</span>光临尚硅谷书城</span>
    <a href="manager/orderServlet?actionMethod=showOrder">我的订单</a>
    <a class="logout" href="userServlet?actionMethod=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
<script type="text/javascript">
    $(function () {
        $("a.logout").click(function () {
            return confirm("确认注销用户吗？");
        });
    })
</script>