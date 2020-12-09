<%@ page language="java" contentType="text/html;charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>结算页面</title>

	<%--    静态引入jsp页面的 base css jQuery框架--%>
	<%@include file="/pages/common/head.jsp" %>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">结算</span>

		<%--    静态引入登录成功后menu菜单--%>
		<%@include file="/pages/common/login_success_menu.jsp" %>

	</div>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号为${param.orderId}</h1>
		
	
	</div>

	<%--    静态引入jsp页面的页脚--%>
	<%@include file="/pages/common/footer.jsp" %>

</body>
</html>