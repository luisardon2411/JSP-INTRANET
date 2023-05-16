package controller;

import JDBC.usuariosDaoJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.solicitudes;

/**
 *
 * @author Luis
 */
@WebServlet(name = "notificacionesController", urlPatterns = {"/notificacionesController"})
public class notificacionesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "home":
                    inicio(request, response);
                    break;
                case "interaction":
                    interaction(request, response);
                    break;
            }
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
        doPost(request, response);
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
        String action = request.getParameter("action");
        HttpSession sesion = request.getSession();
        if (action != null) {
            switch (action) {
                case "home":
                    List<solicitudes> notifications = new usuariosDaoJDBC().listarSolicitudes();
                    request.setAttribute("notifications", notifications);
                    request.setAttribute("notification", notifications.size());
                    break;
            }
        }
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

    public void inicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/admin/notifications.jsp").forward(request, response);
    }

    public void interaction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String interaction = request.getParameter("interaction");
        String answer = null;
        String user = null;
        int row = 0;
        if (interaction != null) {
            switch (interaction) {
                case "accept":
                    answer = "Aceptar";
                    user = request.getParameter("user");
                    row = new usuariosDaoJDBC().AceptarSolicitud(answer, user);
                    if (row > 0) {
                        request.getRequestDispatcher("notificacionesController?action=home").forward(request, response);
                    }
                    break;
                case "decline":
                    answer = "Rechazar";
                    user = request.getParameter("user");
                    row = new usuariosDaoJDBC().AceptarSolicitud(answer, user);
                    if (row > 0) {
                        request.getRequestDispatcher("notificacionesController?action=home").forward(request, response);
                    }
                    break;
            }
        }
    }

}
