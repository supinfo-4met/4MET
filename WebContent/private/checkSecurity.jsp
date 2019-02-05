<%
	if (session.getAttribute("operator") == null) {
		response.sendRedirect(request.getContextPath()
				+ "/private/loginForm.jsp?msg=You are now logged out. Please login to access again.");
	}
%>