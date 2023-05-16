package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.internos;

/**
 *
 * @author Luis
 */
public class internosDaoJDBC {

    private final String SELECT = "SELECT idinternos, internos.cod_emp,internos.nombre_emp,internos.apellido_emp,fecha_nac,diu,internos.email,sede,observaciones,estado.tipo_estado AS Estado, pais, jefes.cod_emp AS codJefe, jefes.nombre_emp AS nombreJefe, jefes.email AS correoJefe FROM internos INNER JOIN estado ON estado_idestado = idestado INNER JOIN pais ON pais_idpais = idpais INNER JOIN jefes ON jefes_idjefes = idjefes ORDER BY internos.nombre_emp ASC;";
    private final String INSERT = "INSERT INTO internos(cod_emp,nombre_emp,apellido_emp,fecha_nac,diu,email,sede,observaciones,estado_idestado,pais_idpais,jefes_idjefes)VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    private final String SELECT_ID = "SELECT idinternos, internos.cod_emp,internos.nombre_emp,internos.apellido_emp,fecha_nac,diu,internos.email,sede,observaciones,estado.tipo_estado AS Estado, pais, jefes.cod_emp AS codJefe, jefes.nombre_emp AS nombreJefe, jefes.email AS correoJefe FROM internos INNER JOIN estado ON estado_idestado = idestado INNER JOIN pais ON pais_idpais = idpais INNER JOIN jefes ON jefes_idjefes = idjefes WHERE idinternos = ? ORDER BY internos.nombre_emp ASC;";
    private final String UPDATE = "UPDATE internos SET sede = ?, observaciones = ?, estado_idestado = ?, jefes_idjefes = ? WHERE idinternos = ?";

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<internos> listar() {
        List<internos> interno = new ArrayList<>();
        internos in = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idInterno = Integer.parseInt(rs.getString("idinternos"));
                String codigo = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_emp");
                String apellido = rs.getString("apellido_emp");
                String fecha = rs.getString("fecha_nac");
                String diu = rs.getString("diu");
                String email = rs.getString("email");
                String sede = rs.getString("sede");
                String observaciones = rs.getString("observaciones");
                String estado = rs.getString("Estado");
                String pais = rs.getString("pais");
                String codJefe = rs.getString("codJefe");
                String nombreJefe = rs.getString("nombreJefe");
                String correoJefe = rs.getString("correoJefe");
                in = new internos(idInterno, codigo, nombre, apellido, fecha, diu, email, observaciones, estado, pais, correoJefe, nombreJefe, codJefe, sede);
                interno.add(in);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return interno;
    }

    public List<internos> listarId(int idinternos) {
        List<internos> interno = new ArrayList<>();
        internos in = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_ID);
            ps.setInt(1, idinternos);
            rs = ps.executeQuery();
            if(rs.next()) {
                int idInterno = Integer.parseInt(rs.getString("idinternos"));
                String codigo = rs.getString("cod_emp");
                String nombre = rs.getString("nombre_emp");
                String apellido = rs.getString("apellido_emp");
                String fecha = rs.getString("fecha_nac");
                String diu = rs.getString("diu");
                String email = rs.getString("email");
                String sede = rs.getString("sede");
                String observaciones = rs.getString("observaciones");
                String estado = rs.getString("Estado");
                String pais = rs.getString("pais");
                String codJefe = rs.getString("codJefe");
                String nombreJefe = rs.getString("nombreJefe");
                String correoJefe = rs.getString("correoJefe");
                 in = new internos(idInterno, codigo, nombre, apellido, fecha, diu, email, observaciones, estado, pais, correoJefe, nombreJefe, codJefe, sede);
                interno.add(in);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(internosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return interno;
    }
    public int devolverIdInterno(String cod_emp, int idPais){
        int busqueda = 0;
        String query = "SELECT idjefes FROM jefes WHERE cod_emp = ? AND pais_idpais = ?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, cod_emp);
            ps.setInt(2, idPais);
            rs = ps.executeQuery();
            if(rs.next()){
                busqueda = rs.getInt("idjefes");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return busqueda;
    }
    
    public int insert (internos in){
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, in.getCod_emp());
            ps.setString(2, in.getNombre_emp());
            ps.setString(3, in.getApellido_emp());
            ps.setString(4, in.getFecha_nac());
            ps.setString(5, in.getDiu());
            ps.setString(6, in.getEmail());
            ps.setString(7, in.getSede());
            ps.setString(8, in.getObservaciones());
            ps.setInt(9, in.getIdestado());
            ps.setInt(10, in.getIdpais());
            ps.setInt(11, in.getIdjefe());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return row;
    }
    public int update(internos in){
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, in.getSede());
            ps.setString(2, in.getObservaciones());
            ps.setInt(3, in.getIdestado());
            ps.setInt(4, in.getIdjefe());
            ps.setInt(5, in.getIdinternos());
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(internosDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row; 
    }
}
