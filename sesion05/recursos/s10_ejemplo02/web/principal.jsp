<%@page import="s10.daos.CursoDaoJpa"%>
<%@page import="java.util.List"%>
<%@page import="s10.entidades.Curso"%>
<%@page import="s10.entidades.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Administrador administrador =(Administrador)sesion.getAttribute("usuario");
    CursoDaoJpa dao = new CursoDaoJpa(Curso.class);
    List<Curso> lista = dao.findAll();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <%=administrador.getVchAdmNombres()+" "+administrador.getVchAdmApellidos() %>!</h1>
         <h1>Lista de Cursos!</h1>
         <a href="cursoInsertar.jsp">Nuevo Curso</a>
         <br/>
         <table border="1" cellspacing="1" cellpadding="1">
             <thead>
                 <tr>
                     <th>Codigo</th>
                     <th>Nombre</th>
                     <th>Creditos</th>
                     <th>Eliminar</th>
                     <th>Actualizar</th>
                 </tr>
             </thead>
             <tbody>
                 <% for(Curso curso: lista){  %>
                 <tr>
                     <td><%=curso.getChrCurCodigo() %></td>
                     <td><%=curso.getVchCurNombre()%></td>
                     <td><%=curso.getIntCurCreditos() %></td>
                     <td><a href="cursoEliminar.jsp?codigo=<%=curso.getChrCurCodigo() %>">Eliminar</a></td>
                     <td><a href="cursoActualizar.jsp?codigo=<%=curso.getChrCurCodigo() %>">Actualizar</a></td>
                 </tr>
                 <%}%>
             </tbody>
         </table>

         
        
    </body>
</html>
