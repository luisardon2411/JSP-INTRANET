
package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.paises;

/**
 *
 * @author Luis
 */
public class paisesDaoJDBC {
    private final String SELECT = "SELECT * FROM pais";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<paises> listar(){
        List<paises> pais = new ArrayList<>();
        paises pa = null;
        try {
           con = Conexion.conectar();
           ps = con.prepareStatement(SELECT);
           rs = ps.executeQuery();
           while(rs.next()){
               int idPais = rs.getInt("idpais");
               String p = rs.getString("Pais");
               pa = new paises(idPais, p);
               pais.add(pa);
           }
           con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return pais;
    }
    
    
}
