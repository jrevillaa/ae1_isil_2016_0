<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo curso!</h1>
        <form action="sCurso">
            Codigo:<input name="txtCodigo"/><br/>
            Nombre:<input name="txtNombre"/><br/>
            Creditos:<input name="txtCreditos"/><br/>
            <input type="hidden" value="grabar" name="accion"/>
            <input type="submit" value="Grabar"/>
        </form>
    </body>
</html>
