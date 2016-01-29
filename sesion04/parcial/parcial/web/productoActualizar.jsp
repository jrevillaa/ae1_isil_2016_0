<%-- 
    Document   : productoActualizar
    Created on : 28/01/2016, 07:39:32 PM
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
        <title>Producto Actualizar</title>
    </head>
    <body>
        <h1>Ingrese datos de Distrito a actualizar!</h1>
        <form action="sProducto">
            Codigo:<input name="txtCodigo" value="<%=producto.getCod_pro()%>"/><br/>
            Descripción:<input name="txtNombre" value="<%=producto.getDes_pro()%>"/><br/>
            Precio:<input name="txtVendedor" value="<%=producto.getPre_pro()%>"/><br/>
            Stock Actual:<input name="txtCodigo" value="<%=producto.getStk_act()%>"/><br/>
            Stock Mínimo:<input name="txtNombre" value="<%=producto.getStk_min()%>"/><br/>
            Línea:<input name="txtVendedor" value="<%=producto.getLin_pro()%>"/><br/>
            Importado:<input name="txtVendedor" value="<%=producto.getImportado()%>"/><br/>
            <input name="accion" type="hidden" value="actualizar"/><br/>
            <input type="submit" value="actualizar"/>
        </form>
    </body>
</html>
