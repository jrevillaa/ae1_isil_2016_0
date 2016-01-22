<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos!</h1>
        <form action="sDatos" method="post">
            Ingresa tu nombre
            <input name="txtNombre"/>
            <input type="submit" value="eniar"/>
        </form>
        llamado mendiante Link 
        <a href="sDatos?txtNombre=juan">Ver saludo</a>
    </body>
</html>
