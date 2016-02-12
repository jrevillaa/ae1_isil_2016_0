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
import ventas.daos.ProductoDaoJpa;
import ventas.entidades.Producto;

/**
 *
 * @author Alumno-CT
 */
public class ServletProducto extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        String sCodigo = request.getParameter("txtCodigo");
        String sDescripcion = request.getParameter("txtDescripcion");
        String sPrecio = request.getParameter("txtPrecio");
        String sActual = request.getParameter("txtAct");
        String sMinimo = request.getParameter("txtMin");
        String sLinea = request.getParameter("txtLinea");
        String sImportado = request.getParameter("txtImportado");
        Producto producto = new Producto();
        producto.setCodpro(sCodigo);
        producto.setDespro(sDescripcion);
        producto.setPrepro(Double.parseDouble(sPrecio));
        producto.setStkact(Integer.parseInt(sActual));
        producto.setStkmin(Integer.parseInt(sMinimo));
        producto.setLinpro(sLinea);
        producto.setImportado(Boolean.parseBoolean(sImportado));
        int n = 0;
        ProductoDaoJpa dao = new ProductoDaoJpa(Producto.class);
        if (accion.equals("insertar")) {

            dao.create(producto);
        }
        if (accion.equals("eliminar")) {
            dao.remove(producto);
        }
        if (accion.equals("actualizar")) {
            dao.edit(producto);
        }

        response.sendRedirect("msg.jsp");
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
