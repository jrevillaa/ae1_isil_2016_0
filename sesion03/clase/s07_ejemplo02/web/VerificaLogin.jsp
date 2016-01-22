<!--  Derechos Reservados para CJava        -->

<%
if(session.getValue("administrador")==null){
	response.sendRedirect("Login.jsp");
}
%>