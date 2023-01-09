package Controlador.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connections {

    protected Connection conexion;
    String url = "jdbc:sqlserver://LAPTOP-8DR7L2CD:1433;databaseName=LIGHTCONSUM";
    String user = "sa";
    String password = "12345";

    public Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en Conecctions.conectar(): "+ex.getMessage());
        }
        return conexion;
    }

    public void cerrar() {
        if (conexion != null) {
            try {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error en Connections.cerrar(): "+ex.getMessage());
            }
        }
    }
}
