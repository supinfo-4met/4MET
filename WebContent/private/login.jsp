
<%@page import="com.zenika.supbook.model.Administrator"%>
<%@page import="com.zenika.supbook.service.AdministratorService"%>
<%
	String login = request.getParameter("login");
	String password = request.getParameter("password");
	
	Administrator administrator = new AdministratorService().readByLoginAndPassword(login, password);
	
	if (administrator != null) {
		session.setAttribute("administrator", administrator);
		response.sendRedirect(request.getContextPath() + "/private/home.jsp");
		
	} else {
		response.sendRedirect(request.getContextPath() + "/private/loginForm.jsp?msg=Connection error");
	}
%>