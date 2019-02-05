<%@page import="com.zenika.supbook.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.zenika.supbook.service.UserService"%>
<jsp:include page="/private/checkSecurity.jsp" />
<html>
<head>
<title>SUPbook : the online student directory</title>
<link type="text/css" href="<%=request.getContextPath()%>/main.css" rel="stylesheet">
</head>
<body>
	<%
		long userId = Long.parseLong(request.getParameter("id"));
		User user = new UserService().readById(userId);
	%>
	<table>
		<tr>
			<td valign="top"><jsp:include page="/private/menu.jsp" /></td>
			<td valign="top">
				<h1><img src="<%=request.getContextPath() %>/images/office_building.png" style="vertical-align: middle;"/> Update City</h1>
				<form action="<%=request.getContextPath()%>/private/user/updateUser.jsp" method="POST">
					<input type="hidden" name="id" value="<%=user.getId()%>"/>
					<table>
						<tr>
							<td>Id</td>
							<td><%=user.getId()%></td>
						</tr>
						<tr>
							<td>Login</td>
							<td><input type="text" name="login"
								value="<%=user.getLogin()%>" /></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" name="email"
								value="<%=user.getEmail()%>" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Update"/></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
