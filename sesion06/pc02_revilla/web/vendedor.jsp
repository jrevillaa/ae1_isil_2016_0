<%-- 
    Document   : vendedor
    Created on : 11/02/2016, 09:58:05 PM
    Author     : Alumno-CT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso al sistema como vendedor!</h1>
        <form action="sVendedor" method="post">
            Usuario: <input name="txtUsuario"/><br/>
            Password <input name="txtPassword"/><br/>
            <input type="submit" value="Enviar datos"/>
        </form>
    </body>
</html>
