<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户添加页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/customer.action" method="post">
		客户名称：<input type="text" name="name" /><br />
		电话：<input type="text" name="telephone" /><br />
		<input type="submit" value="添加" />
	</form>
</body>
</html>