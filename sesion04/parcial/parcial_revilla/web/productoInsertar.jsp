<%-- 
    Document   : productoInsertar
    Created on : 28/01/2016, 07:36:31 PM
    Author     : Alumno-CT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Producto</title>
    </head>
    <body>
        <h1>Ingrese datos de un nuevo Producto!</h1>
        <form action="sDistrito">
            Codigo:<input name="txtCodigo"/><br/>
            Descripción:<input name="txtDescripcion"/><br/>
            Precio:<input name="txtPrecio"/><br/>
            Stock Actual:<input name="txtAct"/><br/>
            Stock Mínimo:<input name="txtMin"/><br/>
            Línea:<input name="txtLinea"/><br/>
            Importado:<input name="txtImportado"/><br/>
            <input name="accion" type="hidden" value="insertar"/><br/>
            <input type="submit" value="Insertar"/>
        </form>
    </body>
</html>
