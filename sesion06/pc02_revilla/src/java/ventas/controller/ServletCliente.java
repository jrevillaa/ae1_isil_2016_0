/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ventas.daos.DaoFactory;
import ventas.daos.ProductoDaoJpa;
import ventas.entidades.Cliente;
import ventas.entidades.Producto;
import ventas.entidades.Vendedor;
import ventas.servicios.ClienteService;
import ventas.servicios.VendedorService;
import ventas.util.Constantes;

/**
 *
 * @author Alumno-CT
 */
public class ServletCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u = request.getParameter("txtUsuario");
        String p = request.getParameter("txtPassword");
        DaoFactory fabrica = DaoFactory.getInstance();
        
        ClienteService servicio = fabrica.getClientDao(Constantes.JPA);
        System.out.println("HOLA MUNDOOOOOOO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

           Cliente adm = (Cliente) servicio.validar(u, p);

        
        HttpSession sesion = request.getSession();
        if(adm!=null){
            sesion.setAttribute("cliente", adm);
            sesion.setAttribute("lista", new ProductoDaoJpa(Producto.class).findAll());
            response.sendRedirect("principal_cliente.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
