package Controlador;  // Define el paquete Controlador, donde se encuentra la clase control_personas.

import java.sql.PreparedStatement;  // Importa PreparedStatement para ejecutar consultas SQL preparadas.
import java.sql.ResultSet;  // Importa ResultSet para manejar los resultados de una consulta SQL.
import java.sql.SQLException;  // Importa SQLException para manejar excepciones relacionadas con SQL.
import java.util.logging.Level;  // Importa Level para configurar niveles de log en el registro de errores.
import java.util.logging.Logger;  // Importa Logger para generar mensajes de log.
import Controlador.control_conexion;  // Importa la clase control_conexion para manejar la conexión a la base de datos.
import Modelo.personas;  // Importa la clase personas desde el paquete Modelo, que extiende en esta clase.

public class control_personas extends personas {  // La clase control_personas extiende la clase personas, lo que significa que hereda atributos y métodos de personas.
    
    // Método para verificar si un usuario y contraseña son válidos en la base de datos
    public boolean verificar() {  // Método que devuelve un booleano que indica si el acceso es válido.
        try {
            control_conexion con = new control_conexion();  // Se crea una instancia de la clase control_conexion para manejar la conexión a la base de datos.
            con.conectar();  // Llama al método conectar() de control_conexion para establecer la conexión con la base de datos.

            // Prepara la consulta SQL que se va a ejecutar en la base de datos.
            PreparedStatement sql = con.estado().prepareStatement(
                    "SELECT adm_nombre, adm_apellido FROM administradores WHERE adm_usuario='" +
                    this.getPer_usuraio() + "' AND adm_password='" + 
                    this.getPer_password() + "'");

            // Ejecuta la consulta SQL y obtiene los resultados.
            ResultSet res = sql.executeQuery();

            // Si hay resultados, se obtienen los nombres y apellidos del administrador.
            if (res.next()) {
                this.setPer_nombres(res.getString("adm_nombre"));  // Establece el nombre del administrador.
                this.setPer_apellidos(res.getString("adm_apellido"));  // Establece el apellido del administrador.
                return true;  // Retorna true si la verificación es exitosa.
            }
            
            // Si no hay resultados, no se hace nada más y cierra la conexión.
            con.cerrar();  // Cierra la conexión con la base de datos.

        } catch (SQLException ex) {  // Si ocurre un error en la ejecución de la consulta SQL, se captura la excepción.
            System.out.println(ex);  // Imprime el error en la consola.
        }
        
        return false;  // Retorna false si la verificación no es exitosa.
    }
}
