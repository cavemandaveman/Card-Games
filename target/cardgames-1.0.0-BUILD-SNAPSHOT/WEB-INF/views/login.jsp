<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>

<p>Login</p>

<br>

<p>Welcome Back!</p>

<form action="/cardgames/*" method="post">
	<table>
		<tr class="game">
			<td>Email Address:</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr class="game">
			<td>Password:</td>
			<td><input type="password" onfocus="this.value=''" name="password"></td>
		</tr>
	</table>
	<p style="color:red">
	<% 
		String error = (String)request.getAttribute("error");
		if(error != null && error.trim().equals("true")){
		out.println("Incorrect email or password. Try again."); }
	%>
	</p>
	<p><input type="submit" value="Login"></p>
</form>

<br>

<p>Don't have an account? <a class="list" href="/cardgames/register"> Sign up!</a></p>

</body>
</html>