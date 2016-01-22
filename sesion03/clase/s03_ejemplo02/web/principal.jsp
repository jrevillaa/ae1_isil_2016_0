<%@page import="ae1.entidades.Administrador"%>
<%
    HttpSession sesion = request.getSession();
    Administrador admin =(Administrador)sesion.getAttribute("administrador");
    if(admin == null){
    response.sendRedirect("error.jsp");
    }else{
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <%= admin.getNombre() %> </h1>
    </body>
</html>
<% }%>