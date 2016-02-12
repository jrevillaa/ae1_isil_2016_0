<%@page import="ventas.daos.ProductoDaoJpa"%>
<%@page import="ventas.entidades.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    String codigo = request.getParameter("codigo");
    ProductoDaoJpa dao = new ProductoDaoJpa(Producto.class);
    Producto producto = dao.find(codigo);
%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar Producto!</h1>
        <form action="sProducto">
            Codigo:<input name="txtCodigo" value="<%=producto.getCodpro()%>" readonly/><br/>
            Descripción:<input name="txtDescripcion" value="<%=producto.getDespro()%>" readonly/><br/>
            Precio:<input name="txtPrecio" value="<%=producto.getPrepro()%>" readonly/><br/>
            Stock Actual:<input name="txtAct" value="<%=producto.getStkact()%>" readonly/><br/>
            Stock Mínimo:<input name="txtMin" value="<%=producto.getStkmin()%>" readonly/><br/>
            Línea:<input name="txtLinea" value="<%=producto.getLinpro()%>" readonly/><br/>
            Importado:<input name="txtImportado" value="<%=producto.getImportado()%>" readonly/><br/>
            <input type="hidden" value="eliminar" name="accion"/>
            <input type="submit" value="Borrar"/>
        </form>
    </body>
</html>
