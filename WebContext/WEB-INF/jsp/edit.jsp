<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>客户修改页面</h3>
	<form action="${pageContext.request.contextPath}/customer.action" method="post">
		
		<!-- 隐藏域 -->
		<input type="hidden" name="id" value="${cust.id}" />
		
		<!-- 由于 Spring 不支持 put 和 delete 的传输方式，所以这里需要传输方式的转换 -->
		<!-- 将 POST 方法转换成 PUT 方法 -->
		<input type="hidden" name="_method" value="put" />
		
		<!-- 返回的数据展示 -->
		客户名称：<input type="text" name="name" value="${cust.name}" /><br />
		电话：<input type="text" name="telephone" value="${cust.telephone}" /><br />
		<input type="submit" value="修改" />
	</form>
</body>
</html>
