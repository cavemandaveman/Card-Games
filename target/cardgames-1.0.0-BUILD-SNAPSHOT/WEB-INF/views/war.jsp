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

<form name="warform" method="post">
	<p><input type="submit" value="Play!"></p>
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>