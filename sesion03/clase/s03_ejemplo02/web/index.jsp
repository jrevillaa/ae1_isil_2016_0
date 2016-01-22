<%@page import="ae1.entidades.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    HttpSession sesion = request.getSession();
    Administrador admin =(Administrador)sesion.getAttribute("administrador");
    if(admin != null){
    response.sendRedirect("principal.jsp");
    }else{
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso al sistema</h1>
        <form action="sValidador">
            Usuario:<input type="text" name="txtUsuario"><br>
            Password:<input type="password" name="txtPassword"><br>
            <input type="submit" value="Validar">
                
        </form>
    </body>
</html>
<% }%>