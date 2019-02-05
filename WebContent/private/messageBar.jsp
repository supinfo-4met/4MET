<%
	if (request.getParameter("msg") != null) {
%>
<span style="color: red; font-weight: bold;"><%=request.getParameter("msg")%></span>
<%
	}
%>