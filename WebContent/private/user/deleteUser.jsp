<%@page import="com.zenika.supbook.model.User"%>
<%@page import="com.zenika.supbook.service.UserService"%>
<jsp:include page="/private/checkSecurity.jsp" />
<%
	long userId = Long.parseLong(request.getParameter("id"));
	new UserService().delete(userId);

	response.sendRedirect(request.getContextPath()
	+ "/private/user/displayUsers.jsp?msg=User " + userId + " deleted");
%>