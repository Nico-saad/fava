package Controlador;  // Se define el paquete Controlador, en el que se encuentra la clase de gestión de la conexión.

import java.sql.Connection;  // Importamos la clase Connection de JDBC para manejar la conexión a la base de datos.
import java.sql.DriverManager;  // Importamos DriverManager para gestionar la conexión con el motor de la base de datos.
import java.sql.SQLException;  // Importamos SQLException para manejar los errores relacionados con SQL.
import javax.swing.JOptionPane;  // Importamos JOptionPane para mostrar cuadros de diálogo en la interfaz gráfica.

public class control_conexion {  // Definimos la clase control_conexion que gestionará la conexión a la base de datos.
    
    Connection con = null;  // Atributo de tipo Connection que almacenará la conexión a la base de datos.

    // Constructor de la clase control_conexion
    public control_conexion() {  // El constructor no recibe parámetros y simplemente inicializa la clase.
    }

    // Método para conectar a la base de datos
    public void conectar() {
        try {
            String db = "jdbc:mysql://localhost:3306/biblioteca";  // Definimos la URL de la base de datos, indicando el nombre de la base 'biblioteca'.
            con = DriverManager.getConnection(db, "root", "");  // Usamos DriverManager para establecer la conexión con el usuario 'root' y sin contraseña (asumido por la configuración).
            if (con != null) {  // Si la conexión es exitosa
                System.out.println("Conexión establecida con éxito.");  // Imprimimos un mensaje en la consola.
            }
        } catch (SQLException e) {  // Si ocurre un error en la conexión
            JOptionPane.showMessageDialog(null, "Error en la conexión. " + e.getMessage());  // Mostramos un cuadro de diálogo con el error.
        }
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrar() {
        if (con != null) {  // Si la conexión está abierta
            try {
                con.close();  // Cerramos la conexión a la base de datos.
                System.out.println("Conexión cerrada.");  // Imprimimos un mensaje en la consola indicando que la conexión ha sido cerrada.
            } catch (SQLException e) {  // Si ocurre un error al cerrar la conexión
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión. " + e.getMessage());  // Mostramos un cuadro de diálogo con el error.
            }
        }
    }

    // Método para obtener el estado de la conexión
    public Connection estado() {
        return con;  // Devolvemos el objeto Connection que representa la conexión actual a la base de datos.
    }
}
