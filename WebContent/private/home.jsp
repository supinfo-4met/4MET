<jsp:include page="/private/checkSecurity.jsp" />
<html>
<head>
<title>SUPbook : the online student directory</title>
<link type="text/css" href="<%= request.getContextPath() %>/main.css" rel="stylesheet">
</head>
<body>
	<table>
		<tr>
			<td valign="top"><jsp:include page="/private/menu.jsp" /></td>
			<td valign="top">
				<h1>BackOffice SUPBook</h1>
			</td>
		</tr>
	</table>
</body>
</html>