package ae1.servlets;

import ae1.daos.AdministradorDaoFactory;
import ae1.entidades.Administrador;
import ae1.servicios.AdministradorService;
import ae1.util.Constantes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Net
 */
@WebServlet(name = "ServletValidador", urlPatterns = {"/sValidador"})
public class ServletValidador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sUsuraio = request.getParameter("txtUsuario");
        String sPassword = request.getParameter("txtPassword");
        
        AdministradorService servicio = AdministradorDaoFactory.getAdministradorDao(Constantes.MEM);
        
        Administrador adm = servicio.validar(sUsuraio, sPassword);
        HttpSession sesion = request.getSession();
        
        if(adm!=null){
            sesion.setAttribute("eladministrador", adm);
            response.sendRedirect("principal.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
            
        
        
    }

   
}
