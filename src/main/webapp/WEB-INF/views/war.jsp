<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>War</title>
	<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>

<p>War</p>

<jsp:include page="header.jsp"/>

<%
String check = (String)request.getAttribute("check");
if(check == null) {
%>
<form name="warform" method="post">
	<p><input type="submit" name="start" value="play!"></p>
</form>
<% 
}else { 
	String dealt = request.getParameter("dealt");
	String dealt2 = (String)request.getAttribute("dealt");
	String battle = (String)request.getAttribute("battle");
	String start = request.getParameter("start");
%>
<table>
	<tr class="pgame">
		<td>CPU</td>
	</tr>
	<tr class="pgame">
		<td><span style='font-size:28'>${cpuHand} ${blankCards}</span></td>
	</tr>
	<tr class="pgame">
		<td>Cards in deck: <% if(dealt == null && dealt2 == null && battle == null) { out.print("26"); } %> ${cpuTotal}</td>
	</tr>
	<tr class="pgame">
		<td>------------------------------</td>
	</tr>
</table>
	
<table>
	<% if((battle == null) && ((dealt != null && dealt.trim().equals("true")) || (dealt2 != null && dealt2.trim().equals("true"))
			|| (start != null && start.trim().equals("play!")))) { %>
	<tr class="pgame">
		<td><form method="post">
				<input type="submit" value="deal"/>
				<input type="hidden" name="dealt" value="true"/>
			</form>
		</td>
	</tr>
	<% } if(battle != null && battle.trim().equals("true")) { %>
	<tr class="pgame">
		<td><form method="post">
				##<input type="submit" value="WAR!"/>##
				<input type="hidden" name="battle" value="true"/>
			</form>
		</td>
	</tr>
	<% } %>
</table>

<table>
	<tr class="pgame">
		<td>------------------------------</td>
	</tr>
	<tr class="pgame">
		<td>Cards in deck: <% if(dealt == null && dealt2 == null && battle == null) { out.print("26"); } %> ${p1Total}</td>
	</tr>
	<tr class="pgame">
		<td>
			<span style='font-size:28'>${blankCards} ${p1Hand}</span>
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