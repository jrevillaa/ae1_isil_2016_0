<%@page import="ae1.beans.ProductoTO"%>
<%@page import="java.util.List"%>
<%
    HttpSession misesion = request.getSession();
    
    if(misesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }else{
    String userName = misesion.getAttribute("nombre").toString();
    //List<DistritoTO> lista = (List<DistritoTO>)misesion.getAttribute("listaD");    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="ae1.daos.ProductoPSTDAO" id="ddao" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Felicitaciones ya ingresaste <%=userName%>!</h1>
        <a href="productoInsertar.jsp">Nuevo Producto</a>
        <br/><br/>
        <table border>
            <tr>
                <th>codigo</th>
                <th>Descipción</th>
                <th>Precio</th>
                <th>Stock Actual</th>
                <th>Stock Mínimo</th>
                <th>Línea</th>
                <th>Importado</th>
            </tr>
            <% for(ProductoTO producto : ddao.obtenerEntidades()){%>
            <tr>
                <td><%=producto.getCod_pro()%></td>
                <td><%=producto.getDes_pro()%></td>
                <td><%=producto.getPre_pro()%></td>
                <td><%=producto.getStk_act()%></td>
                <td><%=producto.getStk_min()%></td>
                <td><%=producto.getLin_pro()%></td>
                <td><%=producto.getImportado()%></td>
                <td><a href="distritoEliminar.jsp?disCodigo=<%=producto.getCod_pro() %>">X</a></td>
                <td><a href="distritoActualizar.jsp?disCodigo=<%=producto.getCod_pro() %>">A</a></td>
            </tr>
            <%}%>
        </table>
        <% }%>
    </body>
</html>
