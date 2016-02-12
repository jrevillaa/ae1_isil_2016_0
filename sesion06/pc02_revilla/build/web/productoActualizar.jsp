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
            Codigo:<input name="txtCodigo" value="<%=producto.getCodpro()%>"/><br/>
            Descripción:<input name="txtDescripcion" value="<%=producto.getDespro()%>"/><br/>
            Precio:<input name="txtPrecio" value="<%=producto.getPrepro()%>"/><br/>
            Stock Actual:<input name="txtAct" value="<%=producto.getStkact()%>"/><br/>
            Stock Mínimo:<input name="txtMin" value="<%=producto.getStkmin()%>"/><br/>
            Línea:<input name="txtLinea" value="<%=producto.getLinpro()%>"/><br/>
            Importado:<input name="txtImportado" value="<%=producto.getImportado()%>"/><br/>
            <input type="hidden" value="actualizar" name="accion"/>
            <input type="submit" value="Actualizar"/>
        </form>
    </body>
</html>
