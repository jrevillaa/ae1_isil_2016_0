<!-- 

/*****************************************************************
 * CJava - Capacitaciones (Derechos Reservados)                  *
 *																 *
 * Curso:     J2EE usando MVC y Tomcat			       			 *
 * Profesor:  Edwin Marav�										 *
 *																 *
 * Version:   1.0  												 *
 * A�o:       2005												 *
 *																 *
 * Direcci�n: Jr. Joaqu�n Bernal 482 - Lima 14					 *
 * Tel�fono:  471-2673 											 *
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
      <p align="center"><font size="3"><b>Alumno&nbsp;</b></font></p>
      <form method="POST" action="AlumnoMan">
        <p align="center"><font color="#0000FF">El proceso fue existoso</font></p>

        <p align="center">
	<A HREF="AlumnoMain.jsp">Continuar...</A>
        </p>

	<input type="hidden" value="eliminar" name="tipo">

      </form>

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
