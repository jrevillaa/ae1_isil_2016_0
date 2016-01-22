

<%@page import="ae1.beans.DistritoTO"%>
<jsp:useBean id="ddao" scope="session" class="ae1.daos.DistritoSTDAO"/>

<%

    HttpSession misesion = request.getSession();
    
    if(misesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }
    
    String codigo = request.getParameter("disCodigo");
    DistritoTO distrito = ddao.buscarEntidad(codigo);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Distrito Actualizar</title>
    </head>
    <body>
        <h1>Ingrese datos de Distrito a actualizar!</h1>
        <form action="sDistrito">
            Codigo:<input name="txtCodigo" value="<%=distrito.getCodigo() %>" /><br/>
            Nombre:<input name="txtNombre"  value="<%=distrito.getNombre() %>" /><br/>
            Vendedor:<input name="txtVendedor"  value="<%=distrito.getVendendor() %>" /><br/>
            <input name="accion" type="hidden" value="actualizar"/><br/>
            <input type="submit" value="actualizar"/>
        </form>
    </body>
</html>
