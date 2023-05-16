package JDBC;

import controller.loginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.solicitudes;
import model.usuarios;

/**
 *
 * @author Luis
 */
public class usuariosDaoJDBC {

    private final String SELECT = "SELECT usuario, cod_emp, nombre_user,apellido_user,ultima_sesion,tipoUsuario AS Rol_Usuario,tipo_estado FROM usuarios INNER JOIN tipo_usuario ON tipo_usuario_idtipo_usuario = idtipo_usuario INNER JOIN estado ON estado_idestado = idestado ORDER BY usuario ASC;";
    private final String SELECT_ID = "SELECT * FROM usuarios WHERE usuario = ?";
    private final String INSERT = "INSERT INTO usuarios(usuario,contraseña,cod_emp,nombre_user,apellido_user,numero_telefonico,fecha_reg,tipo_usuario_idtipo_usuario,estado_idestado)VALUES(?,?,?,?,?,?,?,?,?);";
    private final String DELETE = "DELETE FROM usuarios WHERE usuario = ?";
    private final String UPDATE = "UPDATE usuarios SET tipo_usuario_idtipo_usuario = ?, estado_idestado = ? WHERE usuario = ?";
    private final String SELECT_SOL = "SELECT * FROM solicitudes";
    private final String SELECT_SOL_ID = "SELECT * FROM solicitudes WHERE usuario = ?";
    private final String INSERT_SOL = "INSERT INTO solicitudes(usuario,contraseña,cod_emp,nombre_user,apellido_user,numero_telefonico,fecha_envio,estado) VALUES(?,?,?,?,?,?,?,?);";
    private final String UNLOCK_USER = "UPDATE usuarios SET estado_idestado = ? WHERE usuario = ?";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<usuarios> listar() {
        List<usuarios> usuario = new ArrayList<>();
        usuarios u = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                String user = rs.getString("usuario");
                String codigo = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_user");
                String apellido = rs.getString("apellido_user");
                String numero_telefonico = rs.getString("numero_telefonico");
                String ultimaSesion = rs.getString("ultima_sesion");
                String Rol = rs.getString("Rol_usuario");
                String estado = rs.getString("tipo_estado");
                u = new usuarios(user, codigo, nombre, apellido,numero_telefonico, Rol, estado, ultimaSesion);
                usuario.add(u);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }

    public static String ObtenerFechaActual() {
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }

    public int insertUser(usuarios u) {
        int row = 0;
        String dateTime = ObtenerFechaActual();
        int estado = 1;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getContraseña());
            ps.setString(3, u.getCod_emp());
            ps.setString(4, u.getNombre_user());
            ps.setString(5, u.getApellido_user());
            ps.setString(6, u.getNumero_telefonico());            
            ps.setString(7, dateTime);
            ps.setInt(8, u.getIdTipoUsuario());
            ps.setInt(9, estado);
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }

    public int eliminarUsuario(String usuario) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(DELETE);
            ps.setString(1, usuario);
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return row;
    }

    public int modificarUsuario(usuarios u) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(UPDATE);
            ps.setInt(1, u.getIdTipoUsuario());
            ps.setInt(2, u.getIdEstado());
            ps.setString(3, u.getUsuario());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }

    public List<usuarios> listarUsuario(String usuario) {
        List<usuarios> user = new ArrayList<>();
        usuarios u = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_ID);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                String us = rs.getString("usuario");
                String cod = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_user");
                String apellido = rs.getString("apellido_user");
                u = new usuarios(usuario, cod, nombre, apellido);
                user.add(u);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    public List<solicitudes> listarSolicitudes() {
        List<solicitudes> users = new ArrayList<>();
        solicitudes u = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_SOL);
            rs = ps.executeQuery();
            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String codigo = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_user");
                String apellido = rs.getString("apellido_user");
                String fecha = rs.getString("fecha_envio");
                String estado = rs.getString("estado");
                u = new solicitudes(usuario, contraseña, codigo, nombre, apellido, fecha, estado);
                users.add(u);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return users;
    }

    public int insertarSolicitud(solicitudes u) {
        /*String date = LocalDate.now().toString();
        String hour = LocalTime.now().toString();
        String dateTime = date + " " + hour;*/
        String dateTime = ObtenerFechaActual();
        String estado = "Pendiente";
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT_SOL);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getContraseña());
            ps.setString(3, u.getCod_emp());
            ps.setString(4, u.getNombre_user());
            ps.setString(5, u.getApellido_user());
            ps.setString(6, dateTime);
            ps.setString(7, estado);
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }

    public int AceptarSolicitud(String respuesta, String usuario) {
        int row = 0;
        int estado = 1;
        int tipoUser = 2;
        String admin = loginController.usuario;
        if (respuesta != null) {
            try {
                List<usuarios> user = new ArrayList<>();
                usuarios u = null;
                /*
                String date = LocalDate.now().toString();
                String hour = LocalTime.now().toString();
                String dateTime = date + " " + hour;*/
                String dateTime = ObtenerFechaActual();
                switch (respuesta) {
                    case "Aceptar":
                        try {
                        String res = "Aceptado";
                        actualizarEstado(usuario, res, admin);
                        con = Conexion.conectar();
                        ps = con.prepareStatement(SELECT_SOL_ID);
                        ps.setString(1, usuario);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            usuario = rs.getString("usuario");
                            String contraseña = rs.getString("contraseña");
                            String codigo = rs.getString("cod_emp");
                            String nombre = rs.getString("nombre_user");
                            String apellido = rs.getString("apellido_user");
                            u = new usuarios(usuario, contraseña, codigo, nombre, apellido);
                            user.add(u);
                        }
                        rs.close();
                        for (int i = 0; i < user.size(); i++) {
                            ps = con.prepareStatement(INSERT);
                            ps.setString(1, user.get(i).getUsuario());
                            ps.setString(2, user.get(i).getContraseña());
                            ps.setString(3, user.get(i).getCod_emp());
                            ps.setString(4, user.get(i).getNombre_user());
                            ps.setString(5, user.get(i).getApellido_user());
                            ps.setString(6, dateTime);
                            ps.setInt(7, tipoUser);
                            ps.setInt(8, estado);
                            row = ps.executeUpdate();
                            eliminarAceptado(user.get(i).getUsuario());
                        }
                    } catch (SQLException e) {
                        e.printStackTrace(System.out);
                    }
                    break;
                    case "Rechazar":
                        con = Conexion.conectar();
                        ps = con.prepareStatement(SELECT_SOL_ID);
                        ps.setString(1, usuario);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            usuario = rs.getString("usuario");
                            String contraseña = rs.getString("contraseña");
                            String codigo = rs.getString("cod_emp");
                            String nombre = rs.getString("nombre_user");
                            String apellido = rs.getString("apellido_user");
                            u = new usuarios(usuario, contraseña, codigo, nombre, apellido);
                            user.add(u);
                        }
                        for (int i = 0; i < user.size(); i++) {
                            eliminarAceptado(user.get(i).getUsuario());
                        }
                        break;
                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }

    public void actualizarEstado(String usuario, String estado, String admin) {
        String query = "UPDATE solicitudes SET fecha_acept = ?, user_acept = ?, estado = ? WHERE usuario = ?";

        /*String date = LocalDate.now().toString();
        String hour = LocalTime.now().toString();
        String dateTime = date + " " + hour;*/
        String dateTime = ObtenerFechaActual();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, dateTime);
            ps.setString(2, admin);
            ps.setString(3, estado);
            ps.setString(4, usuario);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminarAceptado(String usuario) {
        int row = 0;
        String query = "DELETE FROM solicitudes WHERE usuario = ?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
/*
    //METODOS PARA FILTRAR BUSQUEDA DE USUARIO
    public List<usuarios> FilterUser(String user) {
        List<usuarios> filter = new ArrayList<>();
        usuarios u = null;
        String SELECT_FILTER_USER = "SELECT usuario, cod_emp, nombre_user,apellido_user,ultima_sesion,tipoUsuario AS Rol_Usuario,tipo_estado FROM usuarios INNER JOIN tipo_usuario ON tipo_usuario_idtipo_usuario = idtipo_usuario INNER JOIN estado ON estado_idestado = idestado WHERE usuario LIKE '%" + user + "%' ORDER BY usuario ASC;";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_FILTER_USER);
            rs = ps.executeQuery();
            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String codigo = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_user");
                String apellido = rs.getString("apellido_user");
                String ultimaSesion = rs.getString("ultima_sesion");
                String Rol = rs.getString("Rol_usuario");
                String estado = rs.getString("tipo_estado");
                u = new usuarios(usuario, codigo, nombre, apellido, Rol, estado, ultimaSesion);
                filter.add(u);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filter;
    }

    public List<usuarios> FilterName(String name) {
        List<usuarios> filter = new ArrayList<>();
        usuarios u = null;
        String SELECT_FILTER_USER = "SELECT usuario, cod_emp, nombre_user,apellido_user,ultima_sesion,tipoUsuario AS Rol_Usuario,tipo_estado FROM usuarios INNER JOIN tipo_usuario ON tipo_usuario_idtipo_usuario = idtipo_usuario INNER JOIN estado ON estado_idestado = idestado WHERE nombre_user LIKE '%" + name + "%' ORDER BY nombre_user ASC;";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_FILTER_USER);
            rs = ps.executeQuery();
            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String codigo = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_user");
                String apellido = rs.getString("apellido_user");
                String ultimaSesion = rs.getString("ultima_sesion");
                String Rol = rs.getString("Rol_usuario");
                String estado = rs.getString("tipo_estado");
                u = new usuarios(usuario, codigo, nombre, apellido, Rol, estado, ultimaSesion);
                filter.add(u);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filter;
    }

    public List<usuarios> FilterLastName(String Lastname) {
        List<usuarios> filter = new ArrayList<>();
        usuarios u = null;
        String SELECT_FILTER_USER = "SELECT usuario, cod_emp, nombre_user,apellido_user,ultima_sesion,tipoUsuario AS Rol_Usuario,tipo_estado FROM usuarios INNER JOIN tipo_usuario ON tipo_usuario_idtipo_usuario = idtipo_usuario INNER JOIN estado ON estado_idestado = idestado WHERE apellido_user LIKE '%" + Lastname + "%' ORDER BY apellido_user ASC;";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_FILTER_USER);
            rs = ps.executeQuery();
            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String codigo = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_user");
                String apellido = rs.getString("apellido_user");
                String ultimaSesion = rs.getString("ultima_sesion");
                String Rol = rs.getString("Rol_usuario");
                String estado = rs.getString("tipo_estado");
                u = new usuarios(usuario, codigo, nombre, apellido, Rol, estado, ultimaSesion);
                filter.add(u);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuariosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filter;
    }
*/
    public int unlock(String user, int estado) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(UNLOCK_USER);
            ps.setInt(1, estado);
            ps.setString(2, user);
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return row;
    }
}
