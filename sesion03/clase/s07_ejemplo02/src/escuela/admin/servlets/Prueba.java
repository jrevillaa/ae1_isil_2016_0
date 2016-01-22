package escuela.admin.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Prueba extends HttpServlet {
	
        @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String[] files = { "Datos.ini", "/slashfile", "./dotfile", "/./slashdotfile"};

        
        out.println("<html><body>");
        out.println("<H4>File paths</H4>");
        out.println("<table border=4>");
        out.println("<tr><th>AbsoluteFile</th><th>AbsolutePath</th><th>CanonicalFile</th><th>CanonicalPath</th></tr>");

        try {
                for (int i = 0; i < files.length; i++)
                {
                        File file = new File(files[i]);
                        out.println("  <tr><td>" +
                                file.getAbsoluteFile() + "</td><td>" +
                                file.getAbsolutePath() + "</td><td>" +
                                file.getCanonicalFile() + "</td><td>" +
                                file.getCanonicalPath() + "</td></tr>");
                }
        } catch (IOException e1) {}

        out.println("</table>");
        out.println("<body><html>");
	}

}
