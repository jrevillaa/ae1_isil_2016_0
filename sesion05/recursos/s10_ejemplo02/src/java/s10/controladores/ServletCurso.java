package s10.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import s10.daos.CursoDaoJpa;
import s10.entidades.Curso;

@WebServlet(name = "ServletCurso", urlPatterns = {"/sCurso"})
public class ServletCurso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CursoDaoJpa dao = new CursoDaoJpa(Curso.class);
        String accion= request.getParameter("accion");
        String id = request.getParameter("txtCodigo");
        String nombre = request.getParameter("txtNombre");
        int creditos = Integer.parseInt(request.getParameter("txtCreditos"));
        Curso curso = new Curso();
        curso.setChrCurCodigo(id);
        curso.setVchCurNombre(nombre);
        curso.setIntCurCreditos(creditos);
        if(accion.equals("grabar")){
            dao.create(curso);
        }
        if(accion.equals("eliminar")){
            dao.remove(curso);
        }
        if(accion.equals("actualizar")){
            dao.edit(curso);
        }
        response.sendRedirect("principal.jsp");
        
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
