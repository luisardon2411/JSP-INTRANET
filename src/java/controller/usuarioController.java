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
import model.hash;
import model.usuarios;

/**
 *
 * @author Luis
 */
@WebServlet(name = "usuarioController", urlPatterns = {"/usuarioController"})
public class usuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
              /*  case "filter":
                    filterUser(request, response);
                    break;
                */
                case "insert":
                    insert(request, response);
                    break;
                case "modify":
                    String Usuario = request.getParameter("usuario");
                    List<usuarios> us = new usuariosDaoJDBC().listarUsuario(Usuario);
                    request.setAttribute("modify", us);
                    request.getRequestDispatcher("/WEB-INF/view/admin/modificarUsuario.jsp").forward(request, response);
                    break;
                case "delete":
                    break;
                case "update":
                    update(request, response);
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
        List<usuarios> users = new usuariosDaoJDBC().listar();
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "home":
                    request.setAttribute("listUsers", users);
                    request.getRequestDispatcher("/WEB-INF/view/admin/users.jsp").forward(request, response);
                    break;
                case "add":
                    request.setAttribute("listUsers", users);
                    request.getRequestDispatcher("/WEB-INF/responsePage/usuarios/successUsuario.jsp").forward(request, response);
                    break;
                case "mod":
                    request.setAttribute("listUsers", users);
                    request.getRequestDispatcher("/WEB-INF/responsePage/usuarios/modUsuario.jsp").forward(request, response);
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
/*
    public void filterUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        if (user != null && name.equals("") && lastname.equals("")) {
            List<usuarios> filterUs = new usuariosDaoJDBC().FilterUser(user);
            request.setAttribute("filter", filterUs);
            request.setAttribute("search", user);
            request.getRequestDispatcher("/WEB-INF/view/admin/users.jsp").forward(request, response);
        } else if (name != null && user.equals("") && lastname.equals("")) {
            List<usuarios> filterNa = new usuariosDaoJDBC().FilterName(name);
            request.setAttribute("filter", filterNa);
            request.setAttribute("search", name);
            request.getRequestDispatcher("/WEB-INF/view/admin/users.jsp").forward(request, response);
        } else if (lastname != null && user.equals("") && name.equals("")) {
            List<usuarios> filterLast = new usuariosDaoJDBC().FilterLastName(lastname);
            request.setAttribute("filter", filterLast);
            request.setAttribute("search", lastname);
            request.getRequestDispatcher("/WEB-INF/view/admin/users.jsp").forward(request, response);
        }

    }
*/
    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String codEmp = request.getParameter("cod_emp");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String encripPass = hash.md5(password);
        String nombre = request.getParameter("nombre_user");
        String apellido = request.getParameter("apellido_user");
        String numero_telefonico = request.getParameter("numero_telefonico");
        int idTipoUser = Integer.parseInt(request.getParameter("tipoUser"));
        int estado = 1;
        usuarios u = new usuarios(usuario, encripPass, codEmp, nombre, apellido,numero_telefonico, estado, idTipoUser);
        int respuesta = new usuariosDaoJDBC().insertUser(u);
        if (respuesta > 0) {
            request.getRequestDispatcher("usuarioController?action=add").forward(request, response);
        } else {

        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String User = request.getParameter("user");
        int estado = Integer.parseInt(request.getParameter("estado"));
        int tipoUser = Integer.parseInt(request.getParameter("tipoU"));
        usuarios u = new usuarios(User, estado, tipoUser);
        int respuesta = new usuariosDaoJDBC().modificarUsuario(u);
        if (respuesta > 0) {
            request.getRequestDispatcher("usuarioController?action=mod").forward(request, response);
        } else {
            response.sendRedirect("out.jsp");
        }
    }

    public void desbloquearUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        int estado = 1;
        usuariosDaoJDBC dao = new usuariosDaoJDBC();
        dao.unlock(user, estado);
    }

    public void elimiar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        int respuesta = new usuariosDaoJDBC().eliminarUsuario(user);
        if (respuesta > 0) {
            request.getRequestDispatcher("usuarioController?action=home").forward(request, response);
        } else {
            request.getRequestDispatcher("usuarioController?action=home").forward(request, response);
        }
    }

}
