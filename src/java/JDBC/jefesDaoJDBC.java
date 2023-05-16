package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.jefes;

/**
 *
 * @author Luis
 */
public class jefesDaoJDBC {

    private final String SELECT = "SELECT idjefes,cod_emp,nombre_emp,email,estado.tipo_estado AS Estado, pais AS Pais FROM jefes INNER JOIN estado ON estado_idestado = idestado INNER JOIN pais ON pais_idpais = idpais ORDER BY nombre_emp ASC;";
    private final String SELECT_ID = "SELECT idjefes,cod_emp,nombre_emp,email,estado.tipo_estado AS Estado, pais AS Pais FROM jefes INNER JOIN estado ON estado_idestado = idestado INNER JOIN pais ON pais_idpais = idpais WHERE idjefes = ? ORDER BY nombre_emp ASC";
    private final String INSERT = "INSERT INTO jefes(cod_emp,nombre_emp,email,estado_idestado,pais_idpais)VALUES(?,?,?,?,?)";
    private final String UPDATE = "UPDATE jefes SET estado_idestado = ? WHERE idjefes = ?";
    private final String FIND_ID = "SELECT idjefes FROM jefes WHERE cod_emp = ? AND pais_idpais = ?";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<jefes> listar() {
        List<jefes> jefe = new ArrayList<>();
        jefes j = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idJefe = rs.getInt("idjefes");
                String cod = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_emp");
                String email = rs.getString("email");
                String estado = rs.getString("Estado");
                String pais = rs.getString("Pais");
                j = new jefes(idJefe, cod, nombre, email, estado, pais);
                jefe.add(j);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return jefe;
    }

    public List<jefes> listId(int idjefe) {
        List<jefes> jefe = new ArrayList<>();
        jefes j = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_ID);
            ps.setInt(1, idjefe);
            rs = ps.executeQuery();
            if (rs.next()) {
                int idJefe = rs.getInt("idjefes");
                String cod = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_emp");
                String email = rs.getString("email");
                String estado = rs.getString("Estado");
                String pais = rs.getString("Pais");
                j = new jefes(idJefe, cod, nombre, email, estado, pais);
                jefe.add(j);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(jefesDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jefe;
    }

    public int insert(jefes j) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, j.getCod_emp());
            ps.setString(2, j.getNombre_emp());
            ps.setString(3, j.getEmail());
            ps.setInt(4, j.getIdEstado());
            ps.setInt(5, j.getIdPais());
            row = ps.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(jefesDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }
    
    public int modify(jefes j) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(UPDATE);
            ps.setInt(1, j.getIdEstado());
            ps.setInt(2, j.getIdJefes());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return row;
    }
    public int finded(String cod, int idPais){
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(FIND_ID);
            ps.setString(1, cod);
            ps.setInt(1, idPais);
            rs = ps.executeQuery();
            if(rs.next()){
                row = rs.getInt("idjefes");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return row;
    }
}
