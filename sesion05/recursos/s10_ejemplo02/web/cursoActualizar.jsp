<%@page import="s10.daos.CursoDaoJpa"%>
<%@page import="s10.entidades.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<%
    String codigo = request.getParameter("codigo");
    CursoDaoJpa dao = new CursoDaoJpa(Curso.class);
    Curso objCurso = dao.find(codigo);
%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar curso!</h1>
        <form action="sCurso">
            Codigo:<input name="txtCodigo" value="<%=objCurso.getChrCurCodigo() %>"/><br/>
            Nombre:<input name="txtNombre" value="<%=objCurso.getVchCurNombre()%>"/><br/>
            Creditos:<input name="txtCreditos" value="<%=objCurso.getIntCurCreditos()%>"/><br/>
            <input type="hidden" value="actualizar" name="accion"/>
            <input type="submit" value="Actualizar"/>
        </form>
    </body>
</html>
