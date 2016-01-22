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

package escuela.admin.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import escuela.admin.dao.*;
import escuela.bean.*;

import java.sql.*;

public class ServletAlumno extends HttpServlet {
	
//private final static String STR_NOMBRE_APP="ESCUELA"; 

public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String strTipo=request.getParameter("tipo");

	String strCodigo;
	String strNombres;
	String strApellidos;
	String strFechaNac;
	String strSexo;

	Alumno    objEntidad=new Alumno();
	AlumnoDAO objEntidadDAO=new AlumnoDAO();
	
	

try{	
	if(strTipo.equals("insertar")){
		
		//Captura los parametros que llegan de la Web.
		strCodigo=request.getParameter("txtCodigo");
		strNombres=request.getParameter("txtNombres");
		strApellidos=request.getParameter("txtApellidos");
		strFechaNac=request.getParameter("txtFechaNac");
		strSexo=request.getParameter("optSexo");

		//Llena el Bean
		objEntidad.setCodigo(strCodigo);
		objEntidad.setNombres(strNombres);
		objEntidad.setApellidos(strApellidos);
		objEntidad.setFechaNac(strFechaNac);
		objEntidad.setSexo(strSexo);

		//Inserta el Bean.
		objEntidadDAO.insertar(objEntidad);
		
	}
	else if(strTipo.equals("actualizar")){
		//Captura los parametros que llegan de la Web.
		strCodigo=request.getParameter("txtCodigo");
		strNombres=request.getParameter("txtNombres");
		strApellidos=request.getParameter("txtApellidos");
		strFechaNac=request.getParameter("txtFechaNac");
		strSexo=request.getParameter("optSexo");

		//Llena el Bean
		objEntidad.setCodigo(strCodigo);
		objEntidad.setNombres(strNombres);
		objEntidad.setApellidos(strApellidos);
		objEntidad.setFechaNac(strFechaNac);
		objEntidad.setSexo(strSexo);

		//Actualiza segun el Bean.
		objEntidadDAO.actualizar(objEntidad);
	}
	else{
		//Captura los parametros que llegan de la Web.
		strCodigo=request.getParameter("txtCodigo");
		
		
		//---Elimina la entidad------------.
		if(strCodigo!=null){
			strCodigo=strCodigo.trim();	
		}
		objEntidadDAO.eliminar(strCodigo);
		//----------------------------------.
	}
	
	response.sendRedirect("AlumnoMsg.jsp");	
	
}

catch(Exception e){
	
	response.sendRedirect("AlumnoError.jsp");	
//	System.out.println(STR_NOMBRE_APP+"; "+getClass().getName()+"; Error:"+e);
	
}	

}

}