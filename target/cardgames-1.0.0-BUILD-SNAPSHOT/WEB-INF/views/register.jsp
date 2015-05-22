<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>

<p>Registration</p>

<br>

<p>Create an Account:</p>

<form action="/cardgames/" method="post">
	<table>
		<tr class="game">
			<td>Name:</td>
			<td><input type="text" onfocus="this.value=''" name="name" value=""></td>
		</tr>
		<tr class="game">
			<td>Password:</td>
			<td><input type="password" value="************" onfocus="this.value=''" name="password"></td>
		</tr>
		<tr class="game">
			<td>Email Address:</td>
			<td><input type="email" onfocus="this.value=''" name="email"></td>
	</table>
	<p style="color:red">
	<% 
		String error = (String)request.getAttribute("error");
		if(error != null && error.trim().equals("true")){
		out.println("Fields cannot be blank. Try again."); }
	%>
	</p>
	<p><input type="submit" value="Register Now"></p>
</form>

</body>
</html>