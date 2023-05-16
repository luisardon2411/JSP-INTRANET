/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import JDBC.paisesDaoJDBC;
import JDBC.representantesDaoJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.paises;
import model.representantes;

/**
 *
 * @author Luis
 */
@WebServlet(name = "representantesController", urlPatterns = {"/representantesController"})
public class representantesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "list":
                    int idPais = Integer.parseInt(request.getParameter("idPais"));
                    List<representantes> rep = new representantesDaoJDBC().listarPorPais(idPais);
                    request.setAttribute("rep", rep);
                    request.getRequestDispatcher("/WEB-INF/view/admin/representantes.jsp").forward(request, response);
                    break;
                case "insert":
                    insert(request, response);
                    break;
                case "modify":
                    int iddistribuidor = Integer.parseInt(request.getParameter("idDistribuidor"));
                    List<representantes> repre = new representantesDaoJDBC().listId(iddistribuidor);
                    request.setAttribute("repre", repre);
                    request.getRequestDispatcher("/WEB-INF/view/admin/modificarDistribuidor.jsp").forward(request, response);
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
        List<representantes> rep = new representantesDaoJDBC().listar();
        HttpSession sesion = request.getSession();
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "home":
                    request.setAttribute("representante", rep);
                    request.getRequestDispatcher("/WEB-INF/view/admin/representantes.jsp").forward(request, response);
                    break;
                case "add":
                    request.setAttribute("representante", rep);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Representantes/successDistribuidor.jsp").forward(request, response);
                    break;
                case "mod":
                    request.setAttribute("representante", rep);
                    request.getRequestDispatcher("/WEB-INF/responsePage/Representantes/modDistribuidor.jsp").forward(request, response);
                    break;
                case "inicio":
                    List<representantes> repre = new representantesDaoJDBC().listar();
                    request.setAttribute("representante", repre);
                    request.getRequestDispatcher("/WEB-INF/view/user/representantes.jsp").forward(request, response);
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
        String codDis = request.getParameter("codDis");
        String nombreDis = request.getParameter("nombreDis");
        String encargado = request.getParameter("encargado");
        String email = request.getParameter("email");
        int pais = Integer.parseInt(request.getParameter("idPais"));
        representantes r = new representantes(pais, codDis, nombreDis, encargado, email);
        int respuesta = new representantesDaoJDBC().insert(r);
        if (respuesta > 0) {
            request.getRequestDispatcher("representantesController?action=add").forward(request, response);
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String encargado = request.getParameter("encargado");
        String email = request.getParameter("email");
        int idDistribuidor = Integer.parseInt(request.getParameter("idDistribuidor"));
        representantes r = new representantes(idDistribuidor, encargado, email);
        int respuesta = new representantesDaoJDBC().modify(r);
        if (respuesta > 0) {
            request.getRequestDispatcher("representantesController?action=mod").forward(request, response);
        }
    }

}
