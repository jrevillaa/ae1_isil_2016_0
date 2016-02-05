<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso al sistema!</h1>
        <form action="sValidador" method="post">
            Usuario: <input name="txtUsuario"/><br/>
            Password <input name="txtPassword"/><br/>
            <input type="submit" value="Enviar datos"/>
        </form>
        
    </body>
</html>
