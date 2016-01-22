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
<title>Bienvenido</title>
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
      <p align="center"><font size="3"><b>Cambio de Password</b></font></p>
      <p align="center">&nbsp;</p>
      <form method="POST" action="Control">
        <div align="center">
          <center>
          <table border="0" width="70%" cellpadding="0">
            <tr>
              <td width="37%" bgcolor="#FFFFD2">Login</td>
              <td width="63%"><input type="text" name="txtLogin" size="20"></td>
            </tr>
            <tr>
              <td width="37%" bgcolor="#FFFFD2">Password Anterior</td>
              <td width="63%"><input type="password" name="txtPassword" size="20"></td>
            </tr>
            <tr>
              <td width="37%" bgcolor="#FFFFD2">Password Nuevo</td>
              <td width="63%"><input type="password" name="txtNewPassword" size="20"></td>
            </tr>
            <tr>
              <td width="37%" bgcolor="#FFFFD2">Password Nuevo(Repetir)</td>
              <td width="63%"><input type="password" name="txtNewPassword" size="20"></td>
            </tr>
          </table>
          </center>
        </div>
        <p align="center">
        <input type="submit" value="Guardar" name="btnGuardar">
        <input type="reset" value="Limpiar" name="btnLimpiar"></p>
        <input type="hidden" value="cambio" name="tipo">
      </form>
      <p>&nbsp;
      <p>&nbsp;
      <p>&nbsp;
      <p>
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
