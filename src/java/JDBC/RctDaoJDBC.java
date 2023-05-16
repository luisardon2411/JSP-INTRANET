package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RCT;

/**
 *
 * @author Luis
 */
public class RctDaoJDBC {
    private final String SELECT = "SELECT * FROM rct";
    private final String SELECT_BY_ID = "SELECT * FROM rct WHERE idrct = ?";
    private final String INSERT = "INSERT INTO rct(sitio, departamento, ipEnlace, idlp) VALUES(?,?,?,?)";
    private final String UPDATE = "UPDATE rct SET sitio = ?, departamento = ?, ipEnalce = ?, idIp = ? WHERE idrct = ?";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<RCT> listar(){
        List<RCT> segmento = new ArrayList<>();
        RCT rct = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                String sitio = rs.getString("sitio");
                String departamento = rs.getString("departamento");
                String ipEnlace = rs.getString("ipEnlace");
                String idIp = rs.getString("idIp");
                rct = new RCT(sitio, departamento, ipEnlace,idIp);
                segmento.add(rct);
            }
            con.close();
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace(System.out);
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RctDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return segmento;
    }
    public List<RCT> listarId(int idRct){
        List<RCT> segmento = new ArrayList<>();
        RCT rct = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_BY_ID);
            ps.setInt(1,idRct);
            rs = ps.executeQuery();
            while(rs.next()){
                String sitio = rs.getString("sitio");
                String departamento = rs.getString("departamento");
                String ipEnalce = rs.getString("ipEnlace");
                String idIp = rs.getString("idIp");
                rct = new RCT(sitio, departamento, ipEnalce, idIp);
                segmento.add(rct);
            }
            con.close();
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace(System.out);
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RctDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return segmento;      
    }
    public int insert (RCT rct){
        int row = 0; 
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, rct.getSitio());
            ps.setString(2, rct.getDepartamento());
            ps.setString(3, rct.getIpEnlace());
            ps.setString(4, rct.getIdIp());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RctDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }
    public int update(RCT rct){
        int row = 0;
        return row; 
    }
}
