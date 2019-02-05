<%@page import="com.zenika.supbook.model.User"%>
<%@page import="com.zenika.supbook.service.UserService"%>
<jsp:include page="/private/checkSecurity.jsp" />
<%
	User user = new User(0, request.getParameter("login"), request.getParameter("email"));
	new UserService().create(user);

	response.sendRedirect(request.getContextPath() + "/private/user/displayUsers.jsp?msg=User " + user.getLogin() + " created with id " + user.getId());
%>