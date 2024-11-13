package Controlador; 

import Controlador.control_conexion;
import java.sql.*; 

/**
 * Clase 'transaccion' que maneja las operaciones relacionadas con la tabla 'transacciones'.
 */
public class transaccion { // Define la clase pública 'transaccion'.
    control_conexion con = new control_conexion(); // Crea un objeto 'control_conexion' llamado 'con' para gestionar la conexión a la base de datos.

    // Constructor de la clase 'transaccion' que inicializa el objeto 'con'.
    public transaccion() {
        this.con = new control_conexion(); // Instancia un nuevo objeto 'control_conexion'.
    }

    /* Método para añadir un nuevo registro a la tabla 'transacciones'. */
    public void NuevaTransaccion(String fecha, String diasprestamo, String codigo_libro, String rut_usuario) {
        try {
            con.conectar(); // Llama al método 'conectar()' para establecer la conexión con la base de datos.
            PreparedStatement pstm = con.estado().prepareStatement("insert into " +
                    "transacciones(fecha, diasprestamo, cod_lib, usu_rut) " +
                    "values(?,?,?,?)"); // Prepara una sentencia SQL para insertar una nueva transacción.

            // Asigna los valores de los parámetros a la sentencia SQL.
            pstm.setString(1, fecha); //valor para 'fecha'.
            pstm.setString(2, diasprestamo); //valor para 'diasprestamo'.
            pstm.setString(3, codigo_libro); //valor para 'cod_lib'.
            pstm.setString(4, rut_usuario); //valor para 'usu_rut'.

            pstm.execute(); // Ejecuta la sentencia SQL.
            pstm.close(); // Cierra el 'PreparedStatement' para liberar recursos.
        } catch (SQLException e) { 
            System.out.println(e); 
        }
        con.cerrar(); // Cierra la conexión a la base de datos.
    }

    /* Método para obtener todos los datos de la tabla 'transacciones'. */
    public Object[][] getDatos() {
        int x = 0;

        // Obtiene la cantidad de registros existentes en la tabla 'transacciones'.
        try {
            con.conectar(); // Establece la conexión con la base de datos.
            PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM transacciones"); // Prepara una consulta para contar los registros.
            ResultSet res = pstm.executeQuery(); // Ejecuta la consulta y obtiene los resultados.
            res.next(); // Mueve el cursor al primer registro del 'ResultSet'.
            x = res.getInt("total"); // Almacena la cantidad de registros en 'x'.
            res.close(); // Cierra el 'ResultSet' para liberar recursos.
        } 
        
        catch (SQLException e) { 
            System.out.println(e); 
            con.cerrar(); // Cierra la conexión en caso de error.
        }

        Object[][] s = new String[x][5]; // Crea una matriz de objetos para almacenar los datos de las transacciones.

        // Realiza la consulta SQL y llena los datos en la matriz 's'.
        try {
            con.conectar(); // Establece la conexión con la base de datos.
            PreparedStatement pstm = con.estado().prepareStatement("SELECT " +
                    "tra.cod_trans, tra.fecha, tra.diasprestamo, li.cod_lib, usu.usu_rut " +
                    "FROM transacciones tra " +
                    "LEFT JOIN libros li on tra.cod_lib = li.cod_lib " +
                    "LEFT JOIN usuarios usu on tra.usu_rut = usu.usu_rut " +
                    "ORDER BY tra.cod_trans"); // Prepara una consulta SQL para obtener los datos de las transacciones.

            ResultSet res = pstm.executeQuery(); // Ejecuta la consulta y obtiene los resultados.
            
            int i = 0;
            while (res.next()) { //cada registro en el 'ResultSet'.
                
                // Almacena los datos de cada transacción en la matriz 's'.
                String estcodigo = res.getString("tra.cod_trans"); // Obtiene el código de la transacción.
                String estfecha = res.getString("tra.fecha"); // Obtiene la fecha de la transacción.
                String estdiasp = res.getString("tra.diasprestamo"); // Obtiene los días de préstamo.
                String estlibro = res.getString("li.cod_lib"); // Obtiene el código del libro asociado.
                String estusuario = res.getString("usu.usu_rut"); // Obtiene el RUT del usuario asociado.

                s[i][0] = estcodigo; //código de la transacción.
                s[i][1] = estfecha; //fecha de la transacción.
                s[i][2] = estdiasp; //días de préstamo.
                s[i][3] = estlibro; //código del libro.
                s[i][4] = estusuario; //RUT del usuario.

                i++; 
            }
            res.close(); // Cierra el 'ResultSet' para liberar recursos.
        } catch (SQLException e) { 
            System.out.println(e); 
        }
        con.cerrar(); // Cierra la conexión a la base de datos.
        return s; // Devuelve la matriz con los datos de las transacciones.
    }

    /* Método para eliminar una transacción de la tabla 'transacciones' basado en su código. */
    public void eliminartransaccion(String cod) {
        try {
            con.conectar(); // Establece la conexión con la base de datos.
            PreparedStatement aaa = con.estado().prepareStatement("delete from transacciones where cod_trans = ?"); // Prepara una consulta SQL para eliminar una transacción.
            aaa.setString(1, cod); // Asigna el valor del código de la transacción al parámetro de la consulta.
            aaa.execute(); // Ejecuta la sentencia SQL.
            aaa.close(); // Cierra el 'PreparedStatement' para liberar recursos.
        } catch (SQLException e) { // Captura las excepciones relacionadas con SQL.
            System.out.println(e); 
        }
        con.cerrar();
    }
}

/*
Dependencia de control_conexion: La clase usa control_conexion para gestionar las conexiones 
a la base de datos, asegurando que cada operación interactúe correctamente con el servidor de base de datos.

Operaciones CRUD: La clase realiza operaciones para añadir, obtener 
y eliminar datos de la tabla transacciones, con soporte para consultas relacionadas con otras tablas 
(libros y usuarios).

Manejo de recursos: Los PreparedStatement y ResultSet se cierran para liberar los recursos 
de la base de datos después de cada operación.
*/
