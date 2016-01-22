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
import java.sql.SQLException;

public class ServletValidador extends HttpServlet {

@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{	
		AdministradorDAO objAdmDAO= new AdministradorDAO();
		Administrador    objAdm;

		HttpSession session=request.getSession();

		String strLogin;
		String strPassword;

		strLogin=request.getParameter("txtLogin");
		strPassword=request.getParameter("txtPassword");

		objAdm=objAdmDAO.validarLogin(strLogin,strPassword);

		if(objAdm!=null){
			session.setAttribute("strAdmNombre",objAdm.getNombres()+" "+objAdm.getApellidos());
			session.setAttribute("strAdmCodigo",objAdm.getCodigo());
			response.sendRedirect("Principal.jsp");
		}
		else{
			PrintWriter out=response.getWriter();
			out.println("<B>Error al Ingresar, verifique</B>");			
		}
		
	}
	catch(SQLException | IOException e){
		System.out.println("ESCUELA; "+e);	
	}
}
}