/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import JDBC.externosDaoJDBC;
import JDBC.representantesDaoJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.externos;
import model.representantes;

/**
 *
 * @author Luis
 */
@WebServlet(name = "externosController", urlPatterns = {"/externosController"})
public class externosController extends HttpServlet {

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
                    int idExterno = Integer.parseInt(request.getParameter("idexterno"));
                    List<externos> Externo = new externosDaoJDBC().listarId(idExterno);
                    request.setAttribute("Extern", Externo);
                    request.getRequestDispatcher("/WEB-INF/view/admin/modificarExterno.jsp").forward(request, response);
                    break;
                case "profile":
                    profile(request, response);
                    break;
                case "perfil":
                    perfil(request, response);
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

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "home":
                    List<externos> externo = new externosDaoJDBC().listar();
                    request.setAttribute("externos", externo);
                    request.getRequestDispatcher("/WEB-INF/view/admin/Externos.jsp").forward(request, response);
                    break;
                case "inicio":
                    List<externos> extern = new externosDaoJDBC().listar();
                    sesion.setAttribute("externos", extern);
                    request.getRequestDispatcher("/WEB-INF/view/user/Externos.jsp").forward(request, response);
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String cod = request.getParameter("cod");
        String fecha_nac = request.getParameter("fecha_nac");
        String diu = request.getParameter("diu");
        String email = request.getParameter("email");
        String observaciones = request.getParameter("observaciones");
        String codDist = request.getParameter("cod_dis");
        int idPaisDist = Integer.parseInt(request.getParameter("idPaisDist"));
        int codFinal = new representantesDaoJDBC().busquedaIdDistribuidor(codDist, idPaisDist);
        int idPais = Integer.parseInt(request.getParameter("idPais"));
        int idEstado = 1;
        externos ex = new externos(nombre, apellido, fecha_nac, diu, email, observaciones, cod, idEstado, idPais, codFinal);
        int respuesta = new externosDaoJDBC().insertar(ex);
        if (respuesta > 0) {
            request.getRequestDispatcher("externosController?action=home").forward(request, response);
        } else {

        }
    }

    public void profile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idexternos = Integer.parseInt(request.getParameter("codEmp"));
        List<externos> externo = new externosDaoJDBC().listarId(idexternos);
        request.setAttribute("profile", externo);
        request.getRequestDispatcher("/WEB-INF/view/admin/profile.jsp").forward(request, response);
    }

    public void perfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idexternos = Integer.parseInt(request.getParameter("codEmp"));
        List<externos> externo = new externosDaoJDBC().listarId(idexternos);
        request.setAttribute("profile", externo);
        request.getRequestDispatcher("/WEB-INF/view/user/profile.jsp").forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String observaciones = request.getParameter("observaciones");
        int estado = Integer.parseInt(request.getParameter("estado"));
        String cod = request.getParameter("codEmp");
        int pais = Integer.parseInt(request.getParameter("idPais"));
        int idexterno = Integer.parseInt(request.getParameter("idexterno"));
        int idDist = new representantesDaoJDBC().busquedaIdDistribuidor(cod, pais);
        externos ex = new externos(observaciones, idexterno, estado, idDist);
        int respuesta = new externosDaoJDBC().modify(ex);
        if (respuesta > 0) {
            request.getRequestDispatcher("externosController?action=home").forward(request, response);
        } else {

        }
    }
}
