<%@page import="java.util.ResourceBundle"%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<%
	ResourceBundle rb=(ResourceBundle)application.getAttribute("rb");
%>
<body>
	<form action="login.do" method="post">
		<input type="hidden" name="formid" value="login">
		<%=rb.getString("username") %>:<input type="text" name="uname">
		<%=rb.getString("password") %>:<input type="password" name="upass">
		
		<input type="submit" value="Login...">
	</form>
</body>

</html>