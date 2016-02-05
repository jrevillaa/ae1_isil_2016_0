
<%@page import="java.util.List"%>
<%@page import="ventas.entidades.Distrito"%>
<%@page import="ventas.daos.DistritoDaoJpa"%>
<%@page import="ventas.entidades.Vendedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Vendedor administrador =(Vendedor)sesion.getAttribute("usuario");
    DistritoDaoJpa dao = new DistritoDaoJpa(Distrito.class);
    List<Distrito> lista = dao.findAll();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <%=administrador.getNomVen()+" "+administrador.getApeVen()%>!</h1>
         <h1>Lista de Distritos!</h1>
         <a href="cursoInsertar.jsp">Nuevo Curso</a>
         <br/>
         <table border="1" cellspacing="1" cellpadding="1">
             <thead>
                 <tr>
                     <th>Codigo</th>
                     <th>Nombre</th>
                     <th>Vendedor</th>
                 </tr>
             </thead>
             <tbody>
                 <% for(Distrito curso: lista){  %>
                 <tr>
                     <td><%=curso.getCoddis()%></td>
                     <td><%=curso.getNomdis()%></td>
                     <td><%=curso.getCodven()%></td>
                     <td><a href="distritoEliminar.jsp?codigo=<%=curso.getCoddis() %>">Eliminar</a></td>
                     <td><a href="distritoActualizar.jsp?codigo=<%=curso.getCoddis() %>">Actualizar</a></td>
                 </tr>
                 <%}%>
             </tbody>
         </table>

         
        
    </body>
</html>
