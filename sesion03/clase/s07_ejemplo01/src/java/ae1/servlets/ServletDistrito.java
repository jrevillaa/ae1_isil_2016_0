
package ae1.servlets;

import ae1.beans.DistritoTO;
import ae1.daos.DistritoDaoFactory;
import ae1.daos.DistritoPSTDAO;
import ae1.service.EntidadService;
import ae1.util.Constantes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Profesor
 */
public class ServletDistrito extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        String sCodigo = request.getParameter("txtCodigo");
        int n=0;
        EntidadService<DistritoTO> servicio;
        servicio = DistritoDaoFactory.obtenerDistritoDao(Constantes.PST);
        if(accion.equals("insertar")){
            String sNombre = request.getParameter("txtNombre");
            String sVendedor = request.getParameter("txtVendedor");
            DistritoTO distrito = new DistritoTO();
            distrito.setCodigo(sCodigo);
            distrito.setNombre(sNombre);
            distrito.setVendendor(sVendedor);  
            n = servicio.crearEntidad(distrito);
        }
        if(accion.equals("eliminar")){
            n = servicio.eliminarEntidad(sCodigo);
        }
        if(accion.equals("actualizar")){
            String sNombre = request.getParameter("txtNombre");
            String sVendedor = request.getParameter("txtVendedor");
            //Agregar codigo necesario para realziar la actualizacion.....
        }
        if(n==0)
            response.sendRedirect("error.jsp");
        else{
            response.sendRedirect("msg.jsp");
        }
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
