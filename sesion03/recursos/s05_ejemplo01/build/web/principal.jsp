<%@page import="ae1.entidades.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession misesion = request.getSession();
    Administrador adm = (Administrador)misesion.getAttribute("eladministrador");
    String nombre = adm.getNombre();
    %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intranet</title>
    </head>
    <body>
        <h1>::::::::::sistema intranet ::::::::!</h1>
        <h1>::::::::::Bienvenido <%=nombre %> ::::::::!</h1>
        
    </body>
</html>
