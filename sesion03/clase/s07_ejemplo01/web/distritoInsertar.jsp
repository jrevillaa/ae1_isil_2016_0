
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Distrito</title>
    </head>
    <body>
        <h1>Ingrese datos de un nuevo Distrito!</h1>
        <form action="sDistrito">
            Codigo:<input name="txtCodigo"/><br/>
            Nombre:<input name="txtNombre"/><br/>
            Vendedor:<input name="txtVendedor"/><br/>
            <input name="accion" type="hidden" value="insertar"/><br/>
            <input type="submit" value="Insertar"/>
        </form>
    </body>
</html>
