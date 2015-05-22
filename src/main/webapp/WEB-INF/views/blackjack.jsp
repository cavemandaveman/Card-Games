<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Blackjack</title>
	<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>

<p>Blackjack</p>

<jsp:include page="header.jsp"/>

<%
String check = (String)request.getAttribute("check");
if(check == null){
%>
<form name="bjform" method="post">
	<table>
		<tr class="game">
			<td>How Many Rounds? </td>
			<td><input type="text" onfocus="this.value=''" name="rounds" value="10"></td>
		</tr>
	</table>
	<p style="color:red">
	<% 
		String error = (String)request.getAttribute("error");
		if(error != null && error.trim().equals("true")){
		out.println("Must play at least 1 round. Try again."); }
	%>
	</p>
	<p><input type="submit" name="start" value="play!"></p>
</form>
<% 
}else {
int rounds = Integer.parseInt(request.getParameter("rounds"));
String dealerBust = (String)request.getAttribute("dealerBust");
%>
<table>
	<tr class="pgame">
		<td>Dealer</td>
	</tr>
	<tr class="pgame">
		<td><span style='font-size:28'>${dealerCards}</span></td>
	</tr>
	<tr class="pgame">
		<td>${dealerBust}</td>
	</tr>
	<tr class="pgame">
		<td>${dealerValue}</td>
	</tr>
	<tr class="pgame">
		<td>----------------------------------------</td>
	</tr>
</table>

<table>
	<tr>
		<td>Rounds left: <% out.print(rounds); %></td>
	</tr>
</table>

<table>
	<tr>
		<% 
		String cheat1 = request.getParameter("dealt");
		String cheat2 = request.getParameter("hit");
		String cheat3 = request.getParameter("stay");
		String start = request.getParameter("start");
		String bust = (String)request.getAttribute("bust");
		if(bust == null && ((cheat1 != null && cheat1.trim().equals("true")) 
				|| (cheat2 != null && cheat2.trim().equals("true")))) { 
		%>
		<td><form method="post">
			<input type="submit" value="stay"/>
			<input type="hidden" name="rounds" value="<% if(rounds==1) { out.print("0"); }
														else { out.print(rounds); } %>"/>
			<input type="hidden" name="stay" value="true"/></form></td>
		<td><form method="post">
			<input type="submit" value="hit"/>
			<input type="hidden" name="rounds" value="<% out.print(rounds); %>"/>
			<input type="hidden" name="hit" value="true"/></form></td>
		<% } if((rounds > 1 && (cheat3 != null && cheat3.trim().equals("true"))) 
				|| (start != null && start.trim().equals("play!")) || (bust != null && bust.trim().equals("BUST!"))) { %>
		<td><form method="post">
			<input type="submit" value="deal"/>
			<input type="hidden" name="rounds" value="<% out.print(rounds-1); %>"/>
			<input type="hidden" name="dealt" value="true"/></form></td>
		<% } %>
	</tr>
</table>

<table>
	<tr>
		<td>Wins: ${wins}</td>
	</tr>
</table>

<table>
	<tr class="pgame">
		<td>----------------------------------------</td>
	</tr>
	<tr class="pgame">
		<td>${p1Value}</td>
	</tr>
	<tr class="pgame">
		<td>${bust}</td>
	</tr>
	<tr class="pgame">
		<td>
			<span style='font-size:28'>${p1Cards}</span>
		</td>
	</tr>
	<tr class="pgame">
		<td>${name}</td>
	</tr>
</table>

<form action="/cardgames/*" method="post">
<p><input type="submit" value="quit"/></p>
</form>
<% } %>

<jsp:include page="footer.jsp"/>

</body>
</html>