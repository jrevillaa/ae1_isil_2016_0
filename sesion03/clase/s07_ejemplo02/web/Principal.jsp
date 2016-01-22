<!--  Derechos Reservados para CJava        -->

<%

//Para verificar la sesion.
if(session.getAttribute("strAdmCodigo")==null){
	response.sendRedirect("Login.jsp");
}

String strAdministrador=String.valueOf(session.getAttribute("strAdmNombre"));
%>

<html>

<head>
<meta http-equiv="Content-Language" content="es">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta name="GENERATOR" content="Microsoft FrontPage 4.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
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
      Bienvenido :</b> <%=strAdministrador%></font>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <div align="center">
        <center>
      <table border="0" width="65%" cellspacing="0" cellpadding="0">
        <tr>
          <td width="100%">
            <p align="center"><font size="4" face="Arial">Admistrador de la
            Intranet</font></td>
        </tr>
        <tr>
          <td width="100%" bgcolor="#FFFFD2">
            <p align="center">&nbsp;</p>
            <p align="center"><font face="Arial">El sistema le permite dar
            mantenimiento <br>
            a las diferentes tablas del sistema</font>
            <p align="center">
            
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
        </center>
      </div>
    </td>
  </tr>
</table>

</body>

</html>
