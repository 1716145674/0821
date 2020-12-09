<%@ page language="java" contentType="text/html;charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>我的订单</title>

	<%--    静态引入jsp页面的 base css jQuery框架--%>
	<%@include file="/pages/common/head.jsp" %>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
	<script type="text/javascript">
		$(function () {
			$(".receive").click(function () {
				var price=$(this).parent().parent().find("td:eq(1)").text();
				return confirm("确认签收价格为 "+price+" 的订单吗?");
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>

		<%--    静态引入登录成功后menu菜单--%>
		<%@include file="/pages/common/login_success_menu.jsp" %>


    </div>
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
				<td></td>
			</tr>
			<c:choose>
				<c:when test="${empty requestScope.orders}">
					<tr>
						<td colspan="4">您暂时还没有订单交易！</td>
					</tr>

				</c:when>
				<c:otherwise>
					<c:forEach items="${ requestScope.orders}" var="order">
						<tr>
							<td>${order.createTime}</td>
							<td>${order.price}</td>
							<td class="status">
								<c:choose>
									<c:when test="${order.status==0}">未发货</c:when>
									<c:when test="${order.status==1}">已发货</c:when>
									<c:when test="${order.status==2}">已签收</c:when>
								</c:choose>
							</td>
							<td><a href="manager/orderServlet?actionMethod=showDetails&orderId=${order.orderId}">查看详情</a></td>
							<td><a class="receive" href="manager/orderServlet?actionMethod=changeOrderStatus&status=2&orderId=${order.orderId}"> 确认收货</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</table>
		
	
	</div>

	<%--    静态引入jsp页面的页脚--%>
	<%@include file="/pages/common/footer.jsp" %>

</body>
</html>