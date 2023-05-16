package controller;

import JDBC.aplicacionesDaoJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.contactoAplicacion;

/**
 *
 * @author Luis
 */
@WebServlet(name = "contactoController", urlPatterns = {"/contactoController"})
public class contactoController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "insert":
                    insertar(request, response);
                    break;
                case "update":
                    modificar(request, response);
                    break;
                case "modify":
                    int id = Integer.parseInt(request.getParameter("id"));
                    List<contactoAplicacion> aplicacion = new aplicacionesDaoJDBC().listarId(id);
                    request.setAttribute("moAplicacion", aplicacion);
                    request.getRequestDispatcher("/WEB-INF/view/admin/modificarAplicacion.jsp").forward(request, response);
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
        HttpSession sesion = request.getSession();
        List<contactoAplicacion> aplicaciones = new aplicacionesDaoJDBC().listar();
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "home":
                    request.setAttribute("aplicaciones", aplicaciones);
                    request.getRequestDispatcher("/WEB-INF/view/admin/contactoAplicacion.jsp").forward(request, response);
                    break;
                case "inicio":
                    sesion.setAttribute("aplicaciones", aplicaciones);
                    request.getRequestDispatcher("/WEB-INF/view/user/contactoAplicacion.jsp").forward(request, response);
                    break;
                case "add":
                    request.setAttribute("aplicaciones", aplicaciones);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Apps/successApp.jsp").forward(request, response);
                    break;
                case "add1":
                    request.setAttribute("aplicaciones", aplicaciones);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Apps/successApp.jsp").forward(request, response);
                    break;
                case "mod":
                    request.setAttribute("aplicaciones", aplicaciones);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Apps/modAplicacion.jsp").forward(request, response);
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

    public void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String aplicacion = request.getParameter("app");
        String encargado = request.getParameter("encargado");
        String correo = request.getParameter("correo");
        contactoAplicacion c = new contactoAplicacion(aplicacion, encargado, correo);
        int r = new aplicacionesDaoJDBC().insert(c);
        if (r > 0) {
            request.getRequestDispatcher("contactoController?action=add").forward(request, response);
        } else {
            request.getRequestDispatcher("contactoController?action=add1").forward(request, response);
        }
    }

    public void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String aplicacion = request.getParameter("app");
        String correo = request.getParameter("correo");
        String encargado = request.getParameter("encargado");
        contactoAplicacion c = new contactoAplicacion(id, aplicacion, encargado, correo);
        int r = new aplicacionesDaoJDBC().update(c);
        if (r > 0) {
            request.getRequestDispatcher("contactoController?action=mod").forward(request, response);
        } else {
            request.getRequestDispatcher("contactoController?action=mod1").forward(request, response);
        }
    }

}
