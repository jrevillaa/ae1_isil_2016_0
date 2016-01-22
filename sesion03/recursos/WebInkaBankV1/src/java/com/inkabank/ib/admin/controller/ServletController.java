package com.inkabank.ib.admin.controller;

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

@WebServlet(name = "ServletController", urlPatterns = {"/admin/ServletController"})
public class ServletController extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		String accion = request.getParameter("hidAccion");
		System.out.println("ACCION:" + accion);
		String siguiente = "";
		try {
			if (accion.equals("login")) {
				siguiente = doLogin(request, response);
			} else if (accion.equals("registrarView")) {
				siguiente = doRegistrarView(request, response);
			} else if (accion.equals("registrar")) {
				siguiente = doRegistrar(request, response);
			} else if (accion.equals("actualizarView")) {
				siguiente = doActualizarView(request, response);
			} else if (accion.equals("detalleView")) {
				siguiente = doDetalleView(request, response);
			} else if (accion.equals("actualizar")) {
				siguiente = doActualizar(request, response);
			} else if (accion.equals("main")) {
				siguiente = doMain(request, response);				
			}
			else if (accion.equals("eliminarView")) {
				siguiente = doEliminarView(request, response);
				
			}
		else if (accion.equals("eliminar")) {
				siguiente = doEliminar(request, response);
				
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
		if (login.equals("administrador") && password.equals("123")) {
			ClienteBO bo = new ClienteBO();
			//Cliente cliente = new Cliente();
			ArrayList<Cliente> lista = bo.list();

			//Colocar la lista en el request
			request.setAttribute("listaClientes", lista);

			siguiente = "main.jsp";
		} else {
			siguiente = "error.html";
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

	private String doRegistrar(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		//---Parametros-------------
		String codigo = request.getParameter("txtCodigo");
		String nombres = request.getParameter("txtNombres");
		String apellidos = request.getParameter("txtApellidos");
		String fechaNacimiento = request.getParameter("txtFechaNacimiento");
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		String direccion = request.getParameter("txtDireccion");
		String email = request.getParameter("txtEmail");
		String telefono = request.getParameter("txtTelefono");
		String id = request.getParameter("txtId");
		String tipoID = request.getParameter("cmbTipoId");
		//-------------------------

		ClienteBO bo = new ClienteBO();

		Cliente cliente = new Cliente();
		cliente.setCodigoCliente(codigo);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setFechaNacimiento(fechaNacimiento);
		cliente.setLogin(login);
		cliente.setPassword(password);
		cliente.setDireccion(direccion);
		cliente.setEmail(email);
		cliente.setTelefono(telefono);
		cliente.setId(id);
		cliente.setTipoId(tipoID);

		bo.insert(cliente);
		return "mensaje.html";
	}

	private String doActualizar(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		//---Parametros-------------
		String codigo = request.getParameter("txtCodigo");
		String nombres = request.getParameter("txtNombres");
		String apellidos = request.getParameter("txtApellidos");
		String fechaNacimiento = request.getParameter("txtFechaNacimiento");
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		String direccion = request.getParameter("txtDireccion");
		String email = request.getParameter("txtEmail");
		String telefono = request.getParameter("txtTelefono");
		String id = request.getParameter("txtId");
		String tipoID = request.getParameter("cmbTipoId");
		//-------------------------

		ClienteBO bo = new ClienteBO();

		Cliente cliente = new Cliente();
		cliente.setCodigoCliente(codigo);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setFechaNacimiento(fechaNacimiento);
		cliente.setLogin(login);
		cliente.setPassword(password);
		cliente.setDireccion(direccion);
		cliente.setEmail(email);
		cliente.setTelefono(telefono);
		cliente.setId(id);
		cliente.setTipoId(tipoID);

		bo.update(cliente);
		return "mensaje.html";
	}

	private String doActualizarView(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		//---Parametros-------------
		//Es el codigo de cliente seleccionado
		String seleccion = request.getParameter("optSeleccion");
		//--------------------------

		//Busco el cliente
		ClienteBO bo = new ClienteBO();
		Cliente cliente = bo.find(seleccion);

		//Colocar cliente en el request
		request.setAttribute("cliente", cliente);

		return "actualizar.jsp";
	}

	private String doDetalleView(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		//---Parametros-------------
		//Es el codigo de cliente seleccionado
		String seleccion = request.getParameter("optSeleccion");
		//--------------------------

		//Busco el cliente
		ClienteBO bo = new ClienteBO();
		Cliente cliente = bo.find(seleccion);

		//Colocar cliente en el request
		request.setAttribute("cliente", cliente);

		return "detalle.jsp";
	}

	private String doRegistrarView(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		//---Parametros-------------
		
		//--------------------------

		return "registrar.html";
	}
	
private String doEliminarView(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		//---Parametros-------------
		//Es el codigo de cliente seleccionado
		String seleccion = request.getParameter("optSeleccion");
		//--------------------------

		//Busco el cliente
		ClienteBO bo = new ClienteBO();
		Cliente cliente = bo.find(seleccion);

		//Colocar cliente en el request
		request.setAttribute("cliente", cliente);

		return "eliminar.jsp";
	}	
	private String doEliminar(HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		//---Parametros-------------
		String codigo = request.getParameter("txtCodigo");
		//-------------------------

		ClienteBO bo = new ClienteBO();
		bo.delete(codigo);
		return "mensaje.html";
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
