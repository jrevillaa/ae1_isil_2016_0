<!-- 

/*****************************************************************
 * CJava - Capacitaciones (Derechos Reservados)                  *
 *																 *
 * Curso:     J2EE usando MVC y Tomcat			       			 *
 * Profesor:  Edwin Maraví										 *
 *																 *
 * Version:   1.0  												 *
 * Año:       2005												 *
 *																 *
 * Dirección: Jr. Joaquín Bernal 482 - Lima 14					 *
 * Teléfono:  471-2673 											 *
 *																 *
 *****************************************************************/

 -->

<%
//Para verificar la sesion.
if(session.getValue("strAdmCodigo")==null){
	response.sendRedirect("Login.jsp");
}
%>

<html>

<head>
<title>Intranet Escuela - Administrador</title>
</head>

<body>

<table border="0" width="100%" height="550" cellspacing="0" cellpadding="0">
  <tr>
    <td width="19%" height="544" valign="top">    
    
    <table border="1" width="97%" cellspacing="0" bordercolor="#800000">
      <tr>
        <td width="100%">
        
        <!--Archivo para el menu -->
        <jsp:include page="menu.jsp" flush="true"/>
        
        </td>
      </tr>
    </table>
    
    </td>
    <td width="81%" height="544" valign="top"><font face="Arial"><b>&nbsp;&nbsp;&nbsp;
      </b></font>
      <p align="center"><font size="3"><b>Insertar xxxx</b></font></p>
      <form method="POST" action="AlumnoMan">
        <div align="center">
          <center>
          <table border="0" width="46%" cellpadding="0">
            <tr>
              <td width="63%" bgcolor="#FFFFD2">&nbsp;Codigo</td>
              <td width="62%"><input type="text" name="txtCodigo" size="20" ></td>
            </tr>
            <tr>
              <td width="63%" bgcolor="#FFFFD2">&nbsp;Nombres</td>
              <td width="62%"><input type="text" name="txtNombres" size="20" ></td>
            </tr>
            <tr>
              <td width="63%" bgcolor="#FFFFD2">&nbsp;Apellidos</td>
              <td width="62%"><input type="text" name="txtApellidos" size="20" ></td>
            </tr>
            <tr>
              <td width="63%" bgcolor="#FFFFD2">&nbsp;Fecha de Nacimiento</td>
              <td width="62%"><input type="text" name="txtFechaNac" size="20" ></td>
            </tr>
            <tr>
              <td width="63%" bgcolor="#FFFFD2">&nbsp;Sexo</td>
              <td>
              <input type="radio" value="M" name="optSexo" checked >M 
              <input type="radio" value="F" name="optSexo" >F</td>
            </tr>
          </table>
          </center>
        </div>
        <p align="center"><input type="reset" value="&lt;&lt;&lt;Regresar" name="btnRegresar">
        <input type="submit" value="    Guardar    " name="btnGuardar"></p>
	<input type="hidden" value="insertar" name="tipo">
      </form>
      <p>&nbsp;
      <p>&nbsp;
      <p>&nbsp;
      <p>&nbsp;
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
