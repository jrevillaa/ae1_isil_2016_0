package ae1.servlets;

import ae1.beans.VendedorTO;
import ae1.daos.ProductoDaoFactory;
import ae1.daos.ProductoPSTDAO;
import ae1.daos.VendedorDaoFactory;
import ae1.service.VendedorService;
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
public class ServletValidador extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //leer los datos de la pagina index.jsp
        String susu = request.getParameter("txtUsuario");
        String spas = request.getParameter("txtPassword");
        
        VendedorService servicio = VendedorDaoFactory.obtenerVendedorDao(Constantes.OPC);
        VendedorTO user = servicio.validar(susu, spas);
        
        HttpSession sesion = request.getSession();
        
        if(user==null){
            response.sendRedirect("error.jsp");
        }else{
            sesion.setAttribute("nombre",user.getNombre());
            sesion.setAttribute("dao", ProductoDaoFactory.obtenerProductoDao(Constantes.OPC));
            sesion.setAttribute("listaD",new ProductoPSTDAO().obtenerEntidades());
            response.sendRedirect("principal.jsp");
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
