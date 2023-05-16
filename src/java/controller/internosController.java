package controller;

import JDBC.internosDaoJDBC;
import JDBC.jefesDaoJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.internos;

/**
 *
 * @author Luis
 */
@WebServlet(name = "internosController", urlPatterns = {"/internosController"})
public class internosController extends HttpServlet {

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
                    int idInterno = Integer.parseInt(request.getParameter("idInterno"));
                    List<internos> intern = new internosDaoJDBC().listarId(idInterno);
                    request.setAttribute("Intern", intern);
                    request.getRequestDispatcher("/WEB-INF/view/admin/modificarInterno.jsp").forward(request, response);
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
        List<internos> interno = new internosDaoJDBC().listar();
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "home":
                    request.setAttribute("internos", interno);
                    request.getRequestDispatcher("/WEB-INF/view/admin/Internos.jsp").forward(request, response);
                    break;
                case "add":
                    request.setAttribute("internos", interno);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Internos/successInterno.jsp").forward(request, response);
                    break;
                case "add1":
                    request.setAttribute("internos", interno);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Internos/errorInterno.jsp").forward(request, response);
                    break;
                case "mod":
                    request.setAttribute("internos", interno);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Internos/modInterno.jsp").forward(request, response);
                    break;
                case "mod1":
                    request.setAttribute("internos", interno);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Internos/errorModInterno.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        String cod_emp = request.getParameter("cod_emp");
        String codJefe = request.getParameter("codJefe");
        String nombre_emp = request.getParameter("nombre_emp");
        String apellido = request.getParameter("apellido_emp");
        String fecha_nac = request.getParameter("fecha_nac");
        String diu = request.getParameter("diu");
        String email = request.getParameter("email");
        String sede = request.getParameter("sede");
        String observaciones = request.getParameter("observaciones");
        int estado = 1;
        int idPais = Integer.parseInt(request.getParameter("idPais"));
        int idPaisJefe = Integer.parseInt(request.getParameter("idPaisJefe"));
        int idJefe = new internosDaoJDBC().devolverIdInterno(codJefe, idPaisJefe);
        internos in = new internos(cod_emp, nombre_emp, apellido, fecha_nac, diu, email, observaciones, sede, estado, idPais, idJefe);
        int respuesta = new internosDaoJDBC().insert(in);
        if (respuesta > 0) {
            request.getRequestDispatcher("internosController?action=add").forward(request, response);
        } else {
            request.getRequestDispatcher("internosController?action=add1").forward(request, response);
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sede = request.getParameter("sede");
        String observaciones = request.getParameter("observaciones");
        int idPais = Integer.parseInt(request.getParameter("idPaisJefe"));
        String cod = request.getParameter("codEmp");
        int idJefe = new internosDaoJDBC().devolverIdInterno(cod, idPais);
        int estado = Integer.parseInt(request.getParameter("estado"));
        int idinternos = Integer.parseInt(request.getParameter("idinternos"));
        internos in = new internos(observaciones, sede, estado, idJefe, idinternos);
        int res = new internosDaoJDBC().update(in);
        if (res > 0) {
            request.getRequestDispatcher("internosController?action=mod").forward(request, response);
        } else {
            request.getRequestDispatcher("internosController?action=mod1").forward(request, response);
        }

    }

}
