<%@page import="escuela.admin.dao.*"%>
<%@page import="escuela.bean.*" %>
<%@page import="escuela.util.*" %>

<%
//Para verificar la sesion.
if(session.getValue("strAdmCodigo")==null){
	response.sendRedirect("Login.jsp");
}
%>

<jsp:useBean class="escuela.admin.dao.AlumnoDAO" id="ALUMNODAO" scope="session"/>

<%
Lista objLista=ALUMNODAO.obtenerAlumnos();
%>

<html>
<head>
<title>Intranet Escuela - Administrador</title>
</head>

<body>

<table border="0" width="100%" height="550" cellspacing="0" cellpadding="0">
  <tr>
    <td width="17%" height="544" valign="top">
    
    <table border="1" width="97%" cellspacing="0" bordercolor="#800000">
      <tr>
        <td width="100%">
        
        <!--Archivo para el menu -->
        <jsp:include page="menu.jsp" flush="true"/>
        
        </td>
      </tr>
    </table>
    
    </td>
    <td width="83%" height="544" valign="top"><font face="Arial"><b>&nbsp;&nbsp;&nbsp;
      </b></font>
      <p align="center"><font size="3"><b>Lista de Alumnos</b></font></p>
      <div align="center">
        <center>
        <table border="1" width="86%" height="74">
          <tr>
            <td width="19%" bgcolor="#FFFFD2" align="center" height="19"><b>Codigo</b></td>
            <td width="36%" bgcolor="#FFFFD2" align="center" height="19"><b>Nombres y
              Apellidos</b></td>
            <td width="24%" bgcolor="#FFFFD2" align="center" height="19"><b>Fecha de&nbsp;<br>
              Nacimiento</b></td>
            <td width="9%" bgcolor="#FFFFD2" align="center" height="19"><b>Eliminar</b></td>
            <td width="12%" bgcolor="#FFFFD2" align="center" height="19"><b>Actualizar</b></td>
          </tr>
		<%for(int i=0;i<objLista.getTamanio();i++){%>          
          <tr>
            <td width="19%" height="18"><%=((Alumno)objLista.getElemento(i)).getCodigo()%></td>
            <td width="36%" height="18"><%=((Alumno)objLista.getElemento(i)).getNombres()+" "+((Alumno)objLista.getElemento(i)).getApellidos() %></td>
            <td width="24%" height="18"><%=((Alumno)objLista.getElemento(i)).getFechaNac()%></td>
            <td width="9%" height="18" align="center"><a href="AlumnoEliminar.jsp?codigo=<%=((Alumno)objLista.getElemento(i)).getCodigo()%>">X</a></td>
            <td width="12%" height="18" align="center"><a href="AlumnoActualizar.jsp?codigo=<%=((Alumno)objLista.getElemento(i)).getCodigo()%>">A</a></td>
          </tr>
		<%}%>        
		  
        </table>
        </center>
      </div>
      <p>&nbsp;
      <p>
      
      <div align="center">
       <center>
      
        <table border="1" width="86%">
          <tr>
            <td width="100%"><a href="AlumnoInsertar.jsp">Nuevo Alumno</a></td>
          </tr>
        </table>

          </center>
      </div>

      <p>
      <p>&nbsp;
      <p>&nbsp;
      
      
       <table border="0" width="100%" cellspacing="0" cellpadding="0">
        <tr>
          <td width="100%">
          
          <!--Archivo para los derechos de copia -->
          <jsp:include page="derechos.jsp" flush="true"/>
          
          </td>
        </tr>
      </table>
      

    </td>
  </tr>
</table>



</body>

</html>
