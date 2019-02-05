<%@page import="com.zenika.supbook.model.User"%>
<%@page import="com.zenika.supbook.service.UserService"%>
<jsp:include page="/private/checkSecurity.jsp" />
<%
	long userId = Long.parseLong(request.getParameter("id"));
	User user = new User(userId, request.getParameter("login"), request.getParameter("email"));
	
	new UserService().update(user);

	response.sendRedirect(request.getContextPath()
	+ "/private/user/displayUsers.jsp?msg=User " + user.getId()
	+ " updated");
%>