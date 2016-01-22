<%@page import="java.util.List"%>
<%@page import="ae1.beans.DistritoTO"%>
<%
    HttpSession misesion = request.getSession();
    
    if(misesion.getAttribute("nombre")==null){
        response.sendRedirect("error.jsp");
    }else{
    String userName = misesion.getAttribute("nombre").toString();
    //List<DistritoTO> lista = (List<DistritoTO>)misesion.getAttribute("listaD");    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="ae1.daos.DistritoSTDAO" id="ddao" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Felicitaciones ya ingresaste <%=userName%>!</h1>
        <a href="distritoInsertar.jsp">Nuevo Distrito</a>
        <br/><br/>
        <table border>
            <tr>
                <th>id</th>
                <th>nombre</th>
                <th>codven</th>
            </tr>
            <% for(DistritoTO distrito: ddao.obtenerEntidades()){%>
            <tr>
                <td><%=distrito.getCodigo() %></td>
                <td><%=distrito.getNombre() %></td>
                <td><%=distrito.getVendendor() %></td>
                <td><a href="distritoEliminar.jsp?disCodigo=<%=distrito.getCodigo() %>">X</a></td>
                <td><a href="distritoActualizar.jsp?disCodigo=<%=distrito.getCodigo() %>">A</a></td>
            </tr>
            <%}%>
        </table>
        <% }%>
    </body>
</html>
