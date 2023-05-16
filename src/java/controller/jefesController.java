package controller;

import JDBC.jefesDaoJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.jefes;

/**
 *
 * @author Luis
 */
@WebServlet(name = "jefesController", urlPatterns = {"/jefesController"})
public class jefesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "insert":
                    insert(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "modify":
                    int idJefe = Integer.parseInt(request.getParameter("idJefe"));
                    List<jefes> Jefes = new jefesDaoJDBC().listId(idJefe);
                    request.setAttribute("J", Jefes);
                    request.getRequestDispatcher("/WEB-INF/view/admin/modificarJefe.jsp").forward(request, response);
                    break;
                case "filter":
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
        List<jefes> jefe = new jefesDaoJDBC().listar();
        HttpSession sesion = request.getSession();
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "home":
                    request.setAttribute("jefe", jefe);
                    request.getRequestDispatcher("/WEB-INF/view/admin/Jefes.jsp").forward(request, response);
                    break;
                case "add":
                    request.setAttribute("jefe", jefe);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Jefes/successJefe.jsp").forward(request, response);
                    break;
                case "mod":
                    request.setAttribute("jefe", jefe);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Jefes/modJefe.jsp").forward(request, response);
                    break;
                case "inicio":
                    List<jefes> Jefe = new jefesDaoJDBC().listar();
                    request.setAttribute("jefe", Jefe);
                    request.getRequestDispatcher("/WEB-INF/view/user/Jefes.jsp").forward(request, response);
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

    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod_emp = request.getParameter("cod_emp");
        String nombre_emp = request.getParameter("nombre_emp");
        String email = request.getParameter("email");
        int estado = 1;
        int idPais = Integer.parseInt(request.getParameter("idPais"));
        jefes j = new jefes(estado, idPais, cod_emp, nombre_emp, email);
        int respuesta = new jefesDaoJDBC().insert(j);
        if (respuesta > 0) {
            request.getRequestDispatcher("jefesController?action=add").forward(request, response);
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int estado = Integer.parseInt(request.getParameter("estado"));
        int idjefe = Integer.parseInt(request.getParameter("idjefe"));
        jefes j = new jefes(idjefe, estado);
        int respuesta = new jefesDaoJDBC().modify(j);
        if (respuesta > 0) {
            request.getRequestDispatcher("jefesController?action=mod").forward(request, response);
        }
    }

}
