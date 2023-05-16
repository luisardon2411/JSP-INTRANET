package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.alliedGlobal;

/**
 *
 * @author Luis
 */
public class alliedDaoJDBC {

    private final String SELECT = "SELECT * FROM allied_global";
    private final String SELECT_ID = "SELECT * FROM allied_global WHERE id = ?";
    private final String INSERT = "INSERT INTO allied_global(skill,encargado,correo) VALUES(?,?,?)";
    private final String UPDATE = "UPDATE allied_global SET skill = ?, encargado = ?, correo = ? WHERE id = ?";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //listado de datos 
    public List<alliedGlobal> listar() {
        List<alliedGlobal> allied = new ArrayList<>();
        alliedGlobal global = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String skill = rs.getString("skill");
                String encargado = rs.getString("encargado");
                String correo = rs.getString("correo");
                global = new alliedGlobal(id, skill, encargado, correo);
                allied.add(global);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return allied;
    }

    //INSERT
    public int insert(alliedGlobal g) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, g.getSkill());
            ps.setString(2, g.getEncargado());
            ps.setString(3, g.getCorreo());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return row;
    }

    //UPDATE
    public int update(alliedGlobal g) {
        int row = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, g.getSkill());
            ps.setString(2, g.getEncargado());
            ps.setString(3, g.getCorreo());
            ps.setInt(4, g.getId());
            row = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return row;
    }

    public List<alliedGlobal> listarId(int idGlobal) {
        List<alliedGlobal> allied = new ArrayList<>();
        alliedGlobal global = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_ID);
            ps.setInt(1, idGlobal);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String skill = rs.getString("skill");
                String encargado = rs.getString("encargado");
                String correo = rs.getString("correo");
                global = new alliedGlobal(id, skill, encargado, correo);
                allied.add(global);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return allied;
    }

}
