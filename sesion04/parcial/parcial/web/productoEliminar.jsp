<%-- 
    Document   : productoEliminar
    Created on : 28/01/2016, 07:48:20 PM
    Author     : Alumno-CT
--%>



<%@page import="ae1.beans.ProductoTO"%>
<jsp:useBean id="ddao" scope="session" class="ae1.daos.ProductoPSTDAO"/>

<%

    HttpSession misesion = request.getSession();
    
    if(misesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }
    
    String codigo = request.getParameter("disCodigo");
    ProductoTO producto = ddao.buscarEntidad(codigo);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto Eliminar</title>
    </head>
    <body>
        <h1>Ingrese datos de Producto a eliminar!</h1>
        <form action="sProducto">
            Codigo:<input name="txtCodigo" value="<%=producto.getCod_pro()%>" readonly/><br/>
            Descripción:<input name="txtNombre" value="<%=producto.getDes_pro()%>" disabled="true"/><br/>
            Precio:<input name="txtVendedor" value="<%=producto.getPre_pro()%>" disabled="true"/><br/>
            Stock Actual:<input name="txtCodigo" value="<%=producto.getStk_act()%>" disabled="true"/><br/>
            Stock Mínimo:<input name="txtNombre" value="<%=producto.getStk_min()%>" disabled="true"/><br/>
            Línea:<input name="txtVendedor" value="<%=producto.getLin_pro()%>" disabled="true"/><br/>
            Importado:<input name="txtVendedor" value="<%=producto.getImportado()%>" disabled="true"/><br/>
            <input name="accion" type="hidden" value="eliminar"/><br/>
            <input type="submit" value="eliminar"/>
        </form>
    </body>
</html>
