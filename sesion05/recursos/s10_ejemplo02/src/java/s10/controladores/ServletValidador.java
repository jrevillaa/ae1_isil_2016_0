
package s10.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import s10.daos.CursoDaoJpa;
import s10.daos.DaoFactory;
import s10.entidades.Administrador;
import s10.entidades.Curso;
import s10.servicios.AdministradorService;

/**
 *
 * @author Profesor
 */
@WebServlet(name = "ServletValidador", urlPatterns = {"/sValidador"})
public class ServletValidador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u = request.getParameter("txtUsuario");
        String p = request.getParameter("txtPassword");

        DaoFactory fabrica = DaoFactory.getInstance();
        AdministradorService servicio = fabrica.getAdministradorDao(1);
        Administrador adm = servicio.validar(u, p);
        HttpSession sesion = request.getSession();
        if(adm!=null){
            sesion.setAttribute("usuario", adm);
            sesion.setAttribute("lista", new CursoDaoJpa(Curso.class).findAll());
            response.sendRedirect("principal.jsp");
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
