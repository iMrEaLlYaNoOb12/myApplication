<%@page import="java.util.ResourceBundle"%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<%
	ResourceBundle rb=(ResourceBundle)application.getAttribute("rb");
%>
<body>
	<form action="register.do" method="post">
		<input type="hidden" name="formid" value="register">
		<%=rb.getString("username") %>:<input type="text" name="uname">
		<%=rb.getString("password") %>:<input type="password" name="upass">
		
		<input type="submit" value="Register..">
	</form>
</body>

</html>