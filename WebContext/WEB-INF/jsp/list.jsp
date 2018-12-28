<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有客户</title>
</head>
<body>
	<h3>客户所有数据</h3>
	<a href="${pageContext.request.contextPath}/customer/saveUI.action">添加客户</a>

	<!-- restful 风格 -->
	<form action="${pageContext.request.contextPath}/customer.action"
		method="post">
		
		<!-- 提交方法交换，隐藏域 -->
		<input type="hidden" name="_method" value="delete" />

		<table border="1" width="400px;">
			<tr>
				<th>选择</th>
				<th>客户名称</th>
				<th>客户电话</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${custList}" var="cust">
				<tr>
					<td><input type="checkbox" name="ids" value="${cust.id}" /></td>
					<td>${cust.name}</td>
					<td>${cust.telephone}</td>
					<!-- 带着 id 返回 -->
					<!-- restful 风格可以在路径上加上参数  -->
					<td><a href="${pageContext.request.contextPath}/customer/${cust.id}.action">修改</a></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="删除" />
	</form>

</body>
</html>






