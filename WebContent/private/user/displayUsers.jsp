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
	<table>
		<tr>
			<td valign="top"><jsp:include page="/private/menu.jsp" /></td>
			<td valign="top">
				<h1>Users</h1>
				<jsp:include page="/private/messageBar.jsp" />
				<p><a href="<%=request.getContextPath()%>/private/user/createUserForm.jsp"><img src="<%=request.getContextPath()%>/images/add.png" style="vertical-align: middle;" title="Add"/> Create User</a></p>
				<table>
					<tr>
						<th>Id</th>
						<th>Login</th>
						<th>Password</th>
						<th>Operation</th>
					</tr>
					<%
						List<User> users = new UserService().findAll();

												for (User user : users) {
					%>
					<tr>
						<td><%=user.getId()%></td>
						<td><%=user.getLogin()%></td>
						<td><%=user.getEmail()%></td>
						<td align="center">
						<a href="<%= request.getContextPath()%>/private/user/deleteUser.jsp?id=<%=user.getId()%>"><img src="<%=request.getContextPath() %>/images/delete.png" style="vertical-align: middle;" title="Delete"/></a>
						<a href="<%= request.getContextPath()%>/private/user/updateUserForm.jsp?id=<%=user.getId()%>"><img src="<%=request.getContextPath() %>/images/edit.png" style="vertical-align: middle;" title="Update"/></a>
						</td>
					</tr>
					<%
						}
					%>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
