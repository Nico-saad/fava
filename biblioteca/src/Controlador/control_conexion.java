package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class control_conexion {
    // Atributo de tipo Connection
    Connection con = null;

    // Constructor
    public control_conexion() {
    }

    // Método para conectar
    public void conectar() {
        try {
            String db = "jdbc:mysql://localhost:3306/biblioteca"; 
            con = DriverManager.getConnection(db, "root", ""); // Conexión a la base de datos
            if (con != null) {
                System.out.println("Conexión establecida con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión. " + e.getMessage());
        }
    }

    // Método para desconectar
    public void cerrar() {
        if (con != null) {
            try {
                con.close(); // Cierra la conexión a la base de datos
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión. " + e.getMessage());
            }
        }
    }

    // Método para obtener el estado de la conexión
    public Connection estado() {
        return con;
    }
}