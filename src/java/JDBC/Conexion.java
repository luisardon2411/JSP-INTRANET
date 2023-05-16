package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
   private static String URL = "jdbc:mysql://localhost:3306/cmdb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static String Usuario = "root";
    private static String contraseña = "root";
    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, Usuario, contraseña);
            System.out.println("Conexion Establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "Error " + e);
        }
        return conexion;
    }
}
    

