<%@page import="com.zenika.supbook.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.zenika.supbook.service.UserService"%>
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
				<h1>Create User</h1>
				<form action="<%=request.getContextPath() %>/private/user/createUser.jsp" method="POST">
					<table>
						<tr>
							<td>Login</td>
							<td><input type="text" name="login" />
							</td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" name="email" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Create" />
							</td>
						</tr>
					</table>
				</form></td>
		</tr>
	</table>
</body>
</html>
