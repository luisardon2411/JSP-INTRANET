package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.contactoAplicacion;

/**
 *
 * @author Luis
 */
public class aplicacionesDaoJDBC {

    private final String SELECT = "SELECT * FROM contacto_aplicacion";
    private final String INSERT = "INSERT INTO contacto_aplicacion(nombre_aplicacion,encargado,correo_electronico)VALUES(?,?,?)";
    private final String UPDATE = "UPDATE contacto_aplicacion SET nombre_aplicacion = ?, encargado = ?, correo_electronico = ? WHERE idaplicacion = ?";
    private final String SELECT_ID = "SELECT * FROM contacto_aplicacion WHERE idaplicacion = ?";

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<contactoAplicacion> listar() {
        List<contactoAplicacion> app = new ArrayList<>();
        contactoAplicacion contacto = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idaplicacion = rs.getInt("idaplicacion");
                String nombre_app = rs.getString("nombre_aplicacion");
                String encargado = rs.getString("encargado");
                String correo = rs.getString("correo_electronico");
                contacto = new contactoAplicacion(idaplicacion, nombre_app, encargado, correo);
                app.add(contacto);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return app;
    }

    public int insert(contactoAplicacion app) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, app.getAplicacion());
            ps.setString(2, app.getEncargado());
            ps.setString(3, app.getCorreo());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(aplicacionesDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }

    public int update(contactoAplicacion app) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, app.getAplicacion());
            ps.setString(2, app.getEncargado());
            ps.setString(3, app.getCorreo());
            ps.setInt(4, app.getId());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return row;
    }

    public List<contactoAplicacion> listarId(int idAplicacion) {
        List<contactoAplicacion> app = new ArrayList<>();
        contactoAplicacion contacto = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_ID);
            ps.setInt(1, idAplicacion);
            rs = ps.executeQuery();
            if (rs.next()) {
                int idaplicacion = rs.getInt("idaplicacion");
                String nombre_app = rs.getString("nombre_aplicacion");
                String encargado = rs.getString("encargado");
                String correo = rs.getString("correo_electronico");
                contacto = new contactoAplicacion(idaplicacion, nombre_app, encargado, correo);
                app.add(contacto);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return app;
    }
}
