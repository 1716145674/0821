<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图书列表</title>
		<%
			String basePath = request.getScheme() 
								+ "://"
								+ request.getServerName()
								+ ":"
								+ request.getServerPort()
								+ request.getContextPath()
								+ "/";
		%>
		<base href="<%=basePath %>" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
		<script type="text/javascript">
			// 页面加载完成之后
			$(function () {

				// 给删除的a标签绑定单击事件
				$("a.deleteBook").click(function () {
					//在事件响应的function函数中，有一个this对象。这个this对象是当前正在响应事件的dom对象。
					var name = $(this).parent().parent().find("td:first").text();
					/**
					 * confirm（）是javaScript语言中提供的一个确认提示框函数<br/>
					 * 方法参数是提示框内容<br/>
					 * 它有两个按钮，一个确定，一个取消，<br/>
					 * 点击确定返回true，点击取消返回false<br/>
					 *
					 * return false可以阻止元素的默认行为
					 */
					if ( confirm("你确定要删除 【" + name + "】 吗?") ) {
						// 提交删除前面的form表单
						$(this).prev("form").submit();
					}
					// 阻止a标签，删除的
					return false;
				});

			});
		</script>
		<style type="text/css">
			table {
				border: 1px blue solid;
				width: 700px;
				border-collapse: collapse;
			}
			td,th{
				border: 1px green solid;
			}
			div.menu {
				width: 700px;
				text-align: right;
			}
		</style>
	</head>
	<body>
		<center>
			<h2>图书列表管理页面</h2>
			<div class="menu"><a href="${pageContext.request.contextPath}/book/bookEdit.jsp">添加图书</a></div>
			<table>
				<tr bgcolor="#FF8888">
					<th>书名</th>
					<th>作者</th>
					<th>价格</th>
					<th>销量</th>
					<th>库存</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.books}" var="book">
					<tr>
						<td>${book.name}</td>
						<td>${book.author}</td>
						<td>${book.price}</td>
						<td>${book.sales}</td>
						<td>${book.stock}</td>
						<td>
							<form action="${pageContext.request.contextPath}/book/${book.id}" method="post">
								<input type="hidden" name="_method" value="DELETE">
							</form>
							<a class="deleteBook"
							   href="${pageContext.request.contextPath}/book/delete?id=${book.id}">删除</a>、
							<a href="${pageContext.request.contextPath}/book/${book.id}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</body>
</html>