
package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.representantes;

/**
 *
 * @author Luis
 */
public class representantesDaoJDBC {
    private final String SELECT = "SELECT iddistribuidores,codigo_distribuidor, nombre_distribuidor, encargado, correo_responsable, Pais FROM distribuidores INNER JOIN pais ON pais_idpais = idpais ORDER BY pais_idpais ASC;";
    private final String SELECT_BY_ID = "SELECT iddistribuidores,codigo_distribuidor, nombre_distribuidor, encargado, correo_responsable, Pais FROM distribuidores INNER JOIN pais ON pais_idpais = idpais WHERE iddistribuidores = ?";
    private final String SELECT_ID = "SELECT iddistribuidores,codigo_distribuidor, nombre_distribuidor, encargado, correo_responsable, Pais FROM distribuidores INNER JOIN pais ON pais_idpais = idpais WHERE pais_idpais = ?";
    private final String INSERT = "INSERT INTO distribuidores (codigo_distribuidor,nombre_distribuidor,encargado,correo_responsable,pais_idpais) VALUES (?,?,?,?,?);";
    private final String UPDATE = "UPDATE distribuidores SET encargado = ?, correo_responsable = ? WHERE iddistribuidores = ?";
    private final String DISTINCT = "SELECT DISTINCT nombre_distribuidor AS Distribuidor FROM distribuidores;";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
        public List<representantes> listar(){
        List<representantes> dis = new ArrayList<>();
        representantes r = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                int idDistribuidor = rs.getInt("iddistribuidores");
                String codDist = rs.getString("codigo_distribuidor");
                String nombre_dis = rs.getString("nombre_distribuidor");
                String encargado = rs.getString("encargado");
                String email = rs.getString("correo_responsable");
                String p = rs.getString("Pais");
                r = new representantes(idDistribuidor, codDist, nombre_dis, encargado, email, p);
                dis.add(r);
            }
            con.close();
        } catch (SQLException e) {
        }
        return dis;
    }
    public List<representantes> listarPorPais(int pais){
        List<representantes> dis = new ArrayList<>();
        representantes r = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            ps.setInt(1, pais);
            rs = ps.executeQuery();
            while(rs.next()){
                int idDistribuidor = rs.getInt("iddistribuidores");
                String codDist = rs.getString("codigo_distribuidor");
                String nombre_dis = rs.getString("nombre_distribuidor");
                String encargado = rs.getString("encargado");
                String email = rs.getString("correo_responsable");
                String p = rs.getString("Pais");
                r = new representantes(idDistribuidor, codDist, nombre_dis, encargado, email, p);
                dis.add(r);
            }
            con.close();
        } catch (SQLException e) {
        }
        return dis;
    }
    public List<representantes> listId(int iddistribuidores){
        List<representantes> dis = new ArrayList<>();
        representantes r = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, iddistribuidores);
            rs = ps.executeQuery();
            while(rs.next()){
                int idDistribuidor = rs.getInt("iddistribuidores");
                String codDist = rs.getString("codigo_distribuidor");
                String nombre_dis = rs.getString("nombre_distribuidor");
                String encargado = rs.getString("encargado");
                String email = rs.getString("correo_responsable");
                String p = rs.getString("Pais");
                r = new representantes(idDistribuidor, codDist, nombre_dis, encargado, email, p);
                dis.add(r);
            }
            con.close();
        } catch (SQLException e) {
        }
        return dis;
    }
    public int insert(representantes r){
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, r.getCodDist());
            ps.setString(2, r.getNombreDistribuidor());
            ps.setString(3, r.getEncargado());
            ps.setString(4, r.getEmail());
            ps.setInt(5, r.getIdPais());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(representantesDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }
    public int modify(representantes r){
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, r.getEncargado());
            ps.setString(2, r.getEmail());
            ps.setInt(3, r.getIdDistribuidor());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return row;
    }
    public int busquedaIdDistribuidor(String codDist, int idPais){
        int busqueda = 0;
        String query = "SELECT iddistribuidores FROM distribuidores WHERE codigo_distribuidor = ? AND pais_idpais = ?";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(query);
            ps.setString(1, codDist);
            ps.setInt(2, idPais);
            rs = ps.executeQuery();
            if(rs.next()){
                busqueda = rs.getInt("iddistribuidores");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(representantesDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return busqueda;
    }
}
