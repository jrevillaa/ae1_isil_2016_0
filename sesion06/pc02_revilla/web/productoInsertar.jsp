<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Producto!</h1>
        <form action="sProducto">
            Codigo:<input name="txtCodigo"/><br/>
            Descripción:<input name="txtDescripcion"/><br/>
            Precio:<input name="txtPrecio"/><br/>
            Stock Actual:<input name="txtAct"/><br/>
            Stock Mínimo:<input name="txtMin"/><br/>
            Línea:<input name="txtLinea"/><br/>
            Importado:<input name="txtImportado"/><br/>
            <input type="hidden" value="grabar" name="accion"/>
            <input type="submit" value="Grabar"/>
        </form>
    </body>
</html>
