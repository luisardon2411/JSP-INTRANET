package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.externos;

/**
 *
 * @author Luis
 */
public class externosDaoJDBC {

    private final String SELECT = "SELECT idexternos, cod_emp, nombre_emp,apellido_emp,fecha_nac,diu,email,observaciones,estado.tipo_estado AS estado, pais.Pais AS pais, nombre_distribuidor AS distribuidor, encargado, correo_responsable FROM externos INNER JOIN estado ON estado_idestado = idestado INNER JOIN pais ON pais_idpais = idpais INNER JOIN distribuidores ON distribuidores_iddistribuidores = iddistribuidores ORDER BY nombre_emp ASC;";
    private final String SELECT_ID = "SELECT idexternos, cod_emp, nombre_emp,apellido_emp,fecha_nac,diu,email,observaciones,estado.tipo_estado AS estado, pais.Pais AS pais, nombre_distribuidor AS distribuidor, encargado, correo_responsable FROM externos INNER JOIN estado ON estado_idestado = idestado INNER JOIN pais ON pais_idpais = idpais INNER JOIN distribuidores ON distribuidores_iddistribuidores = iddistribuidores WHERE idexternos = ? ORDER BY nombre_emp ASC;";
    private final String UPDATE = "UPDATE externos SET distribuidores_iddistribuidores = ?, estado_idestado = ?, observaciones = ? WHERE idexternos = ?;";
    private final String INSERT = "INSERT INTO externos(cod_emp,nombre_emp,apellido_emp,fecha_nac,diu,email,observaciones,estado_idestado,pais_idpais,distribuidores_iddistribuidores)VALUES(?,?,?,?,?,?,?,?,?,?);";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<externos> listar() {
        List<externos> externo = new ArrayList<>();
        externos ex = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idexternos = rs.getInt("idexternos");
                String cod_emp = rs.getString("cod_emp");
                String nombre_emp = rs.getString("nombre_emp");
                String apellido_emp = rs.getString("apellido_emp");
                String fecha_nac = rs.getString("fecha_nac");
                String diu = rs.getString("diu");
                String email = rs.getString("email");
                String obervaciones = rs.getString("observaciones");
                String estado = rs.getString("Estado");
                String pa = rs.getString("pais");
                String distribuidor = rs.getString("distribuidor");
                String encargado = rs.getString("encargado");
                String correo_responsable = rs.getString("correo_responsable");
                ex = new externos(nombre_emp, apellido_emp, fecha_nac, diu, email, obervaciones, estado, pa, distribuidor, cod_emp, encargado, correo_responsable, idexternos);
                externo.add(ex);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return externo;
    }

    public List<externos> listarId(int idex) {
        List<externos> externo = new ArrayList<>();
        externos ex = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_ID);
            ps.setInt(1, idex);
            rs = ps.executeQuery();
            if (rs.next()) {
                int idexternos = rs.getInt("idexternos");
                String cod_emp = rs.getString("cod_emp");
                String nombre_emp = rs.getString("nombre_emp");
                String apellido_emp = rs.getString("apellido_emp");
                String fecha_nac = rs.getString("fecha_nac");
                String diu = rs.getString("diu");
                String email = rs.getString("email");
                String obervaciones = rs.getString("observaciones");
                String estado = rs.getString("Estado");
                String pa = rs.getString("pais");
                String distribuidor = rs.getString("distribuidor");
                String encargado = rs.getString("encargado");
                String correo_responsable = rs.getString("correo_responsable");
                ex = new externos(nombre_emp, apellido_emp, fecha_nac, diu, email, obervaciones, estado, pa, distribuidor, cod_emp, encargado, correo_responsable, idexternos);
                externo.add(ex);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return externo;
    }

    public int insertar(externos ex) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, ex.getCod_emp());
            ps.setString(2, ex.getNombre_emp());
            ps.setString(3, ex.getApellido_emp());
            ps.setString(4, ex.getFecha_nac());
            ps.setString(5, ex.getDiu());
            ps.setString(6, ex.getEmail());
            ps.setString(7, ex.getObservaciones());
            ps.setInt(8, ex.getIdestado());
            ps.setInt(9, ex.getIdpais());
            ps.setInt(10, ex.getIdDistribuidor());
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex1) {
                Logger.getLogger(externosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return row;
    }
    public int modify(externos ex){
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(UPDATE);
            ps.setInt(1, ex.getIdDistribuidor());
            ps.setInt(2, ex.getIdestado());
            ps.setString(3, ex.getObservaciones());
            ps.setInt(4, ex.getIdexterno());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
        }
        return row;
    }
}
