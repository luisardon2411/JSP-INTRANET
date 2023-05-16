/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import JDBC.alliedDaoJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.alliedGlobal;

/**
 *
 * @author Luis
 */
@WebServlet(name = "alliedController", urlPatterns = {"/alliedController"})
public class alliedController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "insert":
                    insertar(request, response);
                    break;
                case "modify":
                    int id = Integer.parseInt(request.getParameter("id"));
                    List<alliedGlobal> global = new alliedDaoJDBC().listarId(id);
                    request.setAttribute("moAllied", global);
                    request.getRequestDispatcher("/WEB-INF/view/admin/modificarAllied.jsp").forward(request, response);
                    break;
                case "update":
                    modificar(request, response);
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
        List<alliedGlobal> global = new alliedDaoJDBC().listar();
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "home":
                    request.setAttribute("global", global);
                    request.getRequestDispatcher("/WEB-INF/view/admin/alliedGlobal.jsp").forward(request, response);
                    break;
                case "add":
                    request.setAttribute("global", global);
                    request.getRequestDispatcher("/WEB-INF/responsePage/alliedGlobal/successAllied.jsp").forward(request, response);
                    break;
                case "add1":
                    request.setAttribute("global", global);
                    request.getRequestDispatcher("/WEB-INF/responsePage/alliedGlobal/errorAllied.jsp").forward(request, response);
                    break;
                case "mod":
                    request.setAttribute("global", global);
                    request.getRequestDispatcher("/WEB-INF/responsePage/alliedGlobal/modAllied.jsp").forward(request, response);
                    break;
                case "mod1":
                    request.setAttribute("global", global);
                    request.getRequestDispatcher("/WEB-INF/responsePage/alliedGlobal/errorModAllied.jsp").forward(request, response);
                    break;
                case "inicio":
                    sesion.setAttribute("global", global);
                    request.getRequestDispatcher("/WEB-INF/view/user/alliedGlobal.jsp").forward(request, response);
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
        String skill = request.getParameter("skill");
        String encargado = request.getParameter("encargado");
        String correo = request.getParameter("correo_electronico");
        alliedGlobal g = new alliedGlobal(skill, encargado, correo);
        int respuesta = new alliedDaoJDBC().insert(g);
        if (respuesta > 0) {
            request.getRequestDispatcher("alliedController?action=add").forward(request, response);
        } else {
            request.getRequestDispatcher("alliedController?action=add1").forward(request, response);
        }

    }

    public void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String skill = request.getParameter("skill");
        String encargado = request.getParameter("encargado");
        String correo = request.getParameter("correo");
        int id = Integer.parseInt(request.getParameter("id"));
        alliedGlobal g = new alliedGlobal(id, skill, encargado, correo);
        int respuesta = new alliedDaoJDBC().update(g);
        if (respuesta > 0) {
            request.getRequestDispatcher("alliedController?action=mod").forward(request, response);
        } else {
            request.getRequestDispatcher("alliedController?action=mod1").forward(request, response);
        }
    }

}
