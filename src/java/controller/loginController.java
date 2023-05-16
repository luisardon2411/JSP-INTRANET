package controller;

import JDBC.Conexion;
import JDBC.RctDaoJDBC;
import JDBC.paisesDaoJDBC;
import JDBC.usuariosDaoJDBC;
import static JDBC.usuariosDaoJDBC.ObtenerFechaActual;
import java.sql.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.RCT;
import model.hash;
import model.paises;
import model.solicitudes;
import model.usuarios;

/**
 *
 * @author Luis
 */
@WebServlet(name = "loginController", urlPatterns = {"/loginController"})
public class loginController extends HttpServlet {
// GLOBAL VARIABLES

    public static String usuario;
    public int intentosFallidos = 0;

    //METODOS HTTP
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        List<solicitudes> notifications = new usuariosDaoJDBC().listarSolicitudes();
        List<RCT> rct = new RctDaoJDBC().listar();
        List<paises> pais = new paisesDaoJDBC().listar();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "login":
                    request.setAttribute("notifications", notifications);
                    request.setAttribute("notification", notifications.size());
                    sesion.setAttribute("p", pais);
                    sesion.setAttribute("rct", rct);
                    login(request, response);
                    actualizarUltimaSesion(usuario);
                    break;
                case "register":
                    registrarUsuario(request, response);
                    break;
                case "logout":
                    sesion.invalidate();
                    response.sendRedirect("index.jsp");

                    break;
                case "update":
                    actualizarContraseña(request, response);
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
        processRequest(request, response);
    }

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
    //METODO DE LOGEO

    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String encriPass = hash.md5(password);
        int estado = 0;
        int typeUser;
        try {
            String query = "SELECT * FROM usuarios WHERE usuario = ?";
            con = Conexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = rs.getString("usuario");
                typeUser = rs.getInt("tipo_usuario_idtipo_usuario");
                estado = rs.getInt("estado_idestado");
                String nPass = rs.getString("contraseña");
                if (encriPass.equals(nPass)) {
                    if (estado == 1) {
                        if (user != null && encriPass != null) {
                            switch (typeUser) {
                                case 1:
                                    List<usuarios> User = new usuariosDaoJDBC().listarUsuario(usuario);
                                    sesion.setMaxInactiveInterval(86400);
                                    sesion.setAttribute("user", User);
                                    intentosFallidos = 0;
                                    request.getRequestDispatcher("/WEB-INF/view/admin/home.jsp").forward(request, response);
                                    break;
                                case 2:
                                    User = new usuariosDaoJDBC().listarUsuario(usuario);
                                    sesion.setMaxInactiveInterval(86400);
                                    sesion.setAttribute("user", User);
                                    intentosFallidos = 0;
                                    request.getRequestDispatcher("/WEB-INF/view/user/home.jsp").forward(request, response);
                                    break;
                            }
                        }
                    } else {
                        response.sendRedirect("usuario inactivo.jsp");
                    }
                } else {
                    if (usuario.equals(user)) {
                        if (estado == 2) {
                            response.sendRedirect("usuario inactivo.jsp");
                        } else {
                            intentosFallidos++;
                            sesion.setAttribute("intentos", intentosFallidos);
                            response.sendRedirect("validationLogin.jsp");
                            if (intentosFallidos == 3) {
                                bloquearUsuario(user);
                                intentosFallidos = 0;
                            }

                        }
                    } else {
                        intentosFallidos = 0;
                    }
                }

            } else {
                response.sendRedirect("invalidUser.jsp");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    //Registrar usuario 
    public void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String us = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        String codigo = request.getParameter("codigo");
        String encripPass = hash.md5(contraseña);
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        solicitudes u = new solicitudes(us, encripPass, codigo, nombre, apellido);
        int respuesta = new usuariosDaoJDBC().insertarSolicitud(u);
        if (respuesta > 0) {
            response.sendRedirect("solicitud.jsp");
        } else {
            response.sendRedirect("solicitud_espera.jsp");
        }
    }

    //METODO PARA ACTUALIZAR ULTIMA SESION
    public void actualizarUltimaSesion(String usuario) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "UPDATE usuarios SET ultima_sesion = ? WHERE usuario = ?";
        /*String date = LocalDate.now().toString();
        String hour = LocalTime.now().toString();
        String dateTime = date + " " + hour;*/
        String dateTime = ObtenerFechaActual();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, dateTime);
            ps.setString(2, usuario);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //METODO PARA ACTUALIZAR LA CONTRASEÑA
    public int actualizarContraseña(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int row = 0;
        String query = "UPDATE usuarios SET contraseña = ? WHERE usuario = ?";
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String encripPass = hash.md5(password);
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, encripPass);
            ps.setString(2, user);
            row = ps.executeUpdate();
            if (row > 0) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return row;
    }

    //INTENTOS FALLIDOS
    public void bloquearUsuario(String usuario) {
        Connection c = null;
        PreparedStatement ps = null;
        String query = "UPDATE usuarios SET estado_idestado = ? WHERE usuario = ?";
        int row = 0;
        int estado = 2;
        try {
            c = Conexion.conectar();
            ps = c.prepareStatement(query);
            ps.setInt(1, estado);
            ps.setString(2, usuario);
            row = ps.executeUpdate();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}
