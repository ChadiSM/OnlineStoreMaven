package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class ConexionBD {
    
    private Connection conexion;
    private String url = "jdbc:mysql://localhost:3306/javaonlinestore";
    private String usuario = "root";
    private String contrasena = "";
    
    public ConexionBD() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver JDBC1");
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos");
            throw ex;
        }
    }
    
    public Connection getConexion() {
        return conexion;
    }
    
    public void cerrarConexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
            System.out.println("Conexión cerrada");
        }
    }
}

