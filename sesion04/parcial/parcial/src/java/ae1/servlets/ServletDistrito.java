/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae1.servlets;

import ae1.beans.ProductoTO;
import ae1.daos.ProductoDaoFactory;
import ae1.service.EntidadService;
import ae1.util.Constantes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno-CT
 */
public class ServletDistrito extends HttpServlet {

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
        int n=0;
        EntidadService<ProductoTO> servicio;
        servicio = ProductoDaoFactory.obtenerProductoDao(Constantes.PST);
        if(accion.equals("insertar")){
            String sDescripcion = request.getParameter("txtDescripcion");
            String sPrecio = request.getParameter("txtPrecio");
            String sActual = request.getParameter("txtAct");
            String sMinimo = request.getParameter("txtMin");
            String sLinea = request.getParameter("txtLinea");
            String sImportado = request.getParameter("txtImportado");
            ProductoTO producto = new ProductoTO();
            producto.setCod_pro(sCodigo);
            producto.setDes_pro(sDescripcion);
            producto.setPre_pro(Double.parseDouble(sPrecio));
            producto.setStk_act(Integer.parseInt(sActual));
            producto.setStk_min(Integer.parseInt(sMinimo));
            producto.setLin_pro(sLinea);
            producto.setImportado(Integer.parseInt(sImportado));
            
            n = servicio.crearEntidad(producto);
        }
        if(accion.equals("eliminar")){
            n = servicio.eliminarEntidad(sCodigo);
        }
        if(accion.equals("actualizar")){
            String sDescripcion = request.getParameter("txtDescripcion");
            String sPrecio = request.getParameter("txtPrecio");
            String sActual = request.getParameter("txtAc");
            String sMinimo = request.getParameter("txtMiN");
            String sLinea = request.getParameter("txtLinea");
            String sImportado = request.getParameter("txtImportado");
            //Agregar codigo necesario para realziar la actualizacion.....
            ProductoTO producto = new ProductoTO();
            producto.setCod_pro(sCodigo);
            producto.setDes_pro(sDescripcion);
            producto.setPre_pro(Double.parseDouble(sPrecio));
            producto.setStk_act(Integer.parseInt(sActual));
            producto.setStk_min(Integer.parseInt(sMinimo));
            producto.setLin_pro(sLinea);
            producto.setImportado(Integer.parseInt(sImportado));
            n = servicio.actualizarEntidad(producto);
        }
        if(n==0)
            response.sendRedirect("error.jsp");
        else{
            response.sendRedirect("msg.jsp");
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
