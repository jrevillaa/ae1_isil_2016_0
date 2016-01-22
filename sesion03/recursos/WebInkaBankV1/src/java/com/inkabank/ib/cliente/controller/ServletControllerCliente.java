package com.inkabank.ib.cliente.controller;

import com.inkabank.ib.admin.controller.*;
import com.inkabank.ib.business.ClienteBO;
import com.inkabank.ib.entity.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletControllerCliente", urlPatterns = {"/ServletControllerCliente"})
public class ServletControllerCliente extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String accion = request.getParameter("hidAccion");
		System.out.println("ACCION CLIENTE:" + accion);
		String siguiente = "";
		try {
			if (accion.equals("login")) {
				siguiente = doLogin(request, response);
			} else if (accion.equals("main")) {
				siguiente = doMain(request, response);				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			siguiente = "error.html";
		}

		//Continua el flujo al siguiente componente Web
		RequestDispatcher rd = request.getRequestDispatcher(siguiente);
		rd.forward(request, response);
	}

	private String doLogin(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		//---Parametros-------------
		String login = request.getParameter("txtUsuario");
		String password = request.getParameter("txtPassword");
		//-------------------------

		String siguiente = "";
		ClienteBO bo = new ClienteBO();
		Cliente cliente=bo.login(login, password);

		if(cliente == null){
			siguiente = "error.html";
		}
		else{
			//Colocar el objeto en el request
			//request.setAttribute("cliente",cliente);
			
			//Referencia a la sesion
			HttpSession session= request.getSession();
			//Colocar el objeto en sesion
			session.setAttribute("cliente",cliente);
			//Con session.getAttribute("cliente") lo obtengo

			siguiente = "main.jsp";			
		}
		

		return siguiente;
	}

	private String doMain(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		//---Parametros-------------
		//-------------------------

		ClienteBO bo = new ClienteBO();
		//Cliente cliente = new Cliente();
		ArrayList<Cliente> lista = bo.list();

		//Colocar la lista en el request
		request.setAttribute("listaClientes", lista);

		return "main.jsp";
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		processRequest(request, response);
	}

}
