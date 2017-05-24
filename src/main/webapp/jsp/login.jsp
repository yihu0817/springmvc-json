<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<form action="${pageContext.request.contextPath}/login" method="POST">
		用户名:<input type="text" name="userName"/><br><br>
		密    码:<input type="password" name="passWord"/><br>
		<input type="submit" value="登录"/>
	</form>
	<br>
	${message}<br>
	${failuser.userName}<br>
	${failuser.passWord}
</body>
</html>