
<%@page import="ventas.entidades.Cliente"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="ventas.entidades.Producto"%>
<%@page import="ventas.daos.ProductoDaoJpa"%>
<%@page import="ventas.entidades.Vendedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Cliente administrador =(Cliente)sesion.getAttribute("cliente");
    ProductoDaoJpa dao = new ProductoDaoJpa(Producto.class);
    List<Producto> lista = dao.findAll();

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <%=administrador.getRazsoccli()%>!</h1>
         <h1>Lista de Productos!</h1>
         <a href="productoInsertar.jsp">Nuevo Producto</a>
         <br/>
         <table border="1" cellspacing="1" cellpadding="1">
             <thead>
                 <tr>
                     <th>Codigo</th>
                     <th>Descripción</th>
                     <th>Precio</th>
                     <th>Stock Actual</th>
                     <th>Stock Minimo</th>
                     <th>Linea</th>
                     <th>Importado</th>
                 </tr>
             </thead>
             <tbody>
                 <% for(Producto curso: lista){  %>
                 <tr>
                     <td><%=curso.getCodpro()%></td>
                     <td><%=curso.getDespro()%></td>
                     <td><%=curso.getPrepro()%></td>
                     <td><%=curso.getStkact()%></td>
                     <td><%=curso.getStkmin()%></td>
                     <td><%=curso.getLinpro()%></td>
                     <td><%=curso.getImportado()%></td>
                 </tr>
                 <%}%>
             </tbody>
         </table>

         
        
    </body>
</html>
