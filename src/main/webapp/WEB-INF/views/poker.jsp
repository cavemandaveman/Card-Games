<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Poker</title>
	<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>

<p>Poker</p>

<jsp:include page="header.jsp"/>

<%
String check = (String)request.getAttribute("check");
if(check == null){
%>
<form name="pokerform" method="post">
	<table>
		<tr class="game">
			<td>How Many Players?</td>
			<td><input type="radio" name="players" value="2" checked>2
				<input type="radio" name="players" value="3">3
				<input type="radio" name="players" value="4">4
				<input type="radio" name="players" value="5">5
			</td>
		</tr>
		<tr class="game">
			<td>Ante:</td>
			<td>$<input type="text" onfocus="this.value=''" name="ante" value="5.00"></td>
		</tr>
		<tr class="game">
			<td>Wallet Size:</td>
			<td>$<input type="text" onfocus="this.value=''" name="wallet" value="15.00"></td>
		</tr>
	</table>
	<p style="color:red">
	<% 
		String anteError = (String)request.getAttribute("anteError");
		String walletError = (String)request.getAttribute("walletError");
		if(anteError != null && anteError.trim().equals("true")){
			out.println("Ante must be greater than $0.00. Try again."); }
		if(walletError != null && walletError.trim().equals("true")){
			out.println("Wallet must be at least $"+ Double.parseDouble(request.getParameter("ante"))*3.0 +". Try again."); }
	%>
	</p>
	<p><input type="submit" value="Play!"></p>
</form>
<% }else { %>



<% } %>

<jsp:include page="footer.jsp"/>

</body>
</html>
