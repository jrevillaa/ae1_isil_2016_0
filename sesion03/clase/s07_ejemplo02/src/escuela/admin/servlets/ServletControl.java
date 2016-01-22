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

public class ServletControl extends HttpServlet {


		private void CambiaPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
	try{
		AdministradorDAO objAdmDAO= new AdministradorDAO();
		Administrador    objAdm;

		HttpSession session=request.getSession(false);

		String strLogin;
		String strPassword;
		String strNewPassword;
		String strCodigo;

		strLogin=request.getParameter("txtLogin");
		strPassword=request.getParameter("txtPassword");
		strNewPassword=request.getParameter("txtNewPassword");

		strCodigo=String.valueOf(session.getValue("strAdmCodigo"));
		
		//Valido Password antiguo.
		objAdm=objAdmDAO.validarLogin(strLogin,strPassword);

		if(objAdm!=null){

			//Login y Password antiguos correctos.
			//Cambio Password.
			objAdmDAO.CambiaPassword(strCodigo,strNewPassword);
			
			response.sendRedirect("Principal.jsp");

		}
		else{
			PrintWriter out=response.getWriter();
			out.println("<B>Error al Ingresar, verifique</B>");			
		}
	}	
	catch( java.sql.SQLException e){
		System.out.println("ESCUELA; "+getClass().getName()+"; Error:"+e);
	}	
	}	private void Salir(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		//Objeto para la sesion.
		HttpSession session=request.getSession();

		//Elimino la sesion.
		session.invalidate();

		//Direcciono.
		response.sendRedirect("Salir.jsp");		
	}/**
 * Process incoming HTTP POST requests 
 * 
 * @param request Object that encapsulates the request to the servlet 
 * @param response Object that encapsulates the response from the servlet
 */ 
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String strTipo=request.getParameter("tipo");

	if(strTipo.equals("cambio")){
		CambiaPassword(request,  response);
	}
	else if(strTipo.equals("salir")){
		Salir( request,  response);
	}
		
}}