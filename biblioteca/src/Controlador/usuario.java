package Controlador; // Define el paquete 'Controlador', organizando la clase dentro de la estructura del proyecto.

import java.sql.*; // Importa el paquete 'java.sql' para manejar las conexiones y operaciones de la base de datos.

/**
 * Clase 'usuario' para manejar las operaciones relacionadas con la tabla 'usuarios' en la base de datos.
 */
public class usuario { // Define la clase pública 'usuario'.
    control_conexion con; // Declara un objeto 'control_conexion' llamado 'con' que manejará la conexión a la base de datos.

    // Constructor de la clase 'usuario' que inicializa el objeto 'con'.
    public usuario() {
        this.con = new control_conexion(); // Crea una instancia de 'control_conexion'.
    }

    /* Método para añadir un nuevo registro a la tabla 'usuarios'. */
    public void nuevousuario(String rut, String nombre, String apellido, String direccion, String telefono, String pass, String correo) {
        try {
            con.conectar(); // Llama al método 'conectar()' para establecer la conexión a la base de datos.
            PreparedStatement pstm = con.estado().prepareStatement("insert into " +
                "usuarios(usu_rut, usu_nombre, usu_apellido, usu_direccion, usu_telefono, usu_pass, usu_correo) " +
                "values(?,?,?,?,?,?,?)"); // Prepara una sentencia SQL para insertar un nuevo usuario.

            // Asigna los valores de los parámetros a la sentencia SQL.
            pstm.setString(1, rut); // Establece el valor para 'usu_rut'.
            pstm.setString(2, nombre); // Establece el valor para 'usu_nombre'.
            pstm.setString(3, apellido); // Establece el valor para 'usu_apellido'.
            pstm.setString(4, direccion); // Establece el valor para 'usu_direccion'.
            pstm.setString(5, telefono); // Establece el valor para 'usu_telefono'.
            pstm.setString(6, pass); // Establece el valor para 'usu_pass'.
            pstm.setString(7, correo); // Establece el valor para 'usu_correo'.

            pstm.execute(); // Ejecuta la sentencia SQL.
            pstm.close(); // Cierra el 'PreparedStatement' para liberar recursos.
        } catch (SQLException e) { // Captura las excepciones relacionadas con SQL.
            System.out.println(e); // Imprime el error en la consola.
            con.cerrar(); // Cierra la conexión en caso de error.
        }
    }

    /* Método para obtener todos los datos de la tabla 'usuarios'. */
    public Object[][] getDatos() {
        int x = 0; // Variable para almacenar la cantidad de registros en la tabla.

        // Obtiene la cantidad de registros existentes en la tabla 'usuarios'.
        try {
            con.conectar(); // Establece la conexión a la base de datos.
            PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM usuarios"); // Prepara una consulta para contar los registros.
            ResultSet res = pstm.executeQuery(); // Ejecuta la consulta y obtiene los resultados.
            res.next(); // Mueve el cursor al primer registro.
            x = res.getInt("total"); // Almacena la cantidad de registros en 'x'.
            res.close(); // Cierra el 'ResultSet' para liberar recursos.
        } catch (SQLException e) { // Captura las excepciones relacionadas con SQL.
            System.out.println(e); // Imprime el error en la consola.
            con.cerrar(); // Cierra la conexión en caso de error.
        }

        Object[][] s = new String[x][7]; // Crea una matriz de objetos para almacenar los datos de los usuarios.

        // Realiza la consulta SQL y llena los datos en la matriz 's'.
        try {
            con.conectar(); // Establece la conexión a la base de datos.
            PreparedStatement pstm = con.estado().prepareStatement("SELECT " +
                "usu_rut, usu_nombre, usu_apellido, usu_direccion, usu_telefono, usu_pass, usu_correo " +
                "FROM usuarios " +
                "ORDER BY usu_rut"); // Prepara una consulta SQL para obtener todos los datos de los usuarios.

            ResultSet res = pstm.executeQuery(); // Ejecuta la consulta y obtiene los resultados.
            int i = 0; // Variable para iterar sobre los resultados.
            while (res.next()) { // Recorre cada registro en el 'ResultSet'.
                // Almacena los datos de cada usuario en la matriz 's'.
                String estCodigo = res.getString("usu_rut");
                String estNombre = res.getString("usu_nombre");
                String estapellido = res.getString("usu_apellido");
                String estDireccion = res.getString("usu_direccion");
                String estTelefono = res.getString("usu_telefono");
                String estpass = res.getString("usu_pass");
                String estcorreo = res.getString("usu_correo");

                s[i][0] = estCodigo; // Almacena el RUT del usuario.
                s[i][1] = estNombre; // Almacena el nombre del usuario.
                s[i][2] = estapellido; // Almacena el apellido del usuario.
                s[i][3] = estDireccion; // Almacena la dirección del usuario.
                s[i][4] = estTelefono; // Almacena el teléfono del usuario.
                s[i][5] = estpass; // Almacena la contraseña del usuario.
                s[i][6] = estcorreo; // Almacena el correo del usuario.
                i++; // Incrementa el contador.
            }
            res.close(); // Cierra el 'ResultSet' para liberar recursos.
        } catch (SQLException e) { // Captura las excepciones relacionadas con SQL.
            System.out.println(e); // Imprime el error en la consola.
        }
        con.cerrar(); // Cierra la conexión a la base de datos.
        return s; // Devuelve la matriz con los datos de los usuarios.
    }

    /* Método para actualizar los datos de un usuario en la tabla 'usuarios'. */
    public void ActualizarPersona(String codigo, String nombre, String direccion, String telefono, String ciudad, String pass, String correo) {
        try {
            con.conectar(); // Establece la conexión a la base de datos.
            PreparedStatement pstm = con.estado().prepareStatement("update usuarios " +
                "set usu_rut = ?, " +
                "usu_nombre = ?, " +
                "usu_apellido = ?, " +
                "usu_direccion = ?, " +
                "usu_telefono = ?, " +
                "usu_pass = ?, " +
                "usu_correo = ? " +
                "where usu_rut = ?"); // Prepara una consulta SQL para actualizar los datos de un usuario.

            // Asigna los valores de los parámetros a la sentencia SQL.
            pstm.setString(0, codigo); // Establece el valor del RUT del usuario.
            pstm.setString(1, nombre); // Establece el valor del nombre del usuario.
            pstm.setString(2, direccion); // Establece el valor de la dirección del usuario.
            pstm.setString(3, telefono); // Establece el valor del teléfono del usuario.
            pstm.setString(4, ciudad); // Establece el valor de la ciudad del usuario.
            pstm.setString(5, pass); // Establece el valor de la contraseña del usuario.
            pstm.setString(6, correo); // Establece el valor del correo del usuario.

            pstm.execute(); // Ejecuta la sentencia SQL.
            pstm.close(); // Cierra el 'PreparedStatement' para liberar recursos.
        } catch (SQLException e) { // Captura las excepciones relacionadas con SQL.
            System.out.println(e); // Imprime el error en la consola.
        }
        con.cerrar(); // Cierra la conexión a la base de datos.
    }

    // Método para eliminar un usuario de la tabla 'usuarios' basado en su RUT.
    public void eliminarPersona(String cod) {
        try {
            con.conectar(); // Establece la conexión a la base de datos.
            PreparedStatement aaa = con.estado().prepareStatement("delete from usuarios where usu_rut = ?"); // Prepara una consulta SQL para eliminar un usuario.
            aaa.setString(1, cod); // Asigna el valor del RUT al parámetro de la consulta.
            aaa.execute(); // Ejecuta la sentencia SQL.
            aaa.close(); // Cierra el 'PreparedStatement' para liberar recursos.
        } catch (SQLException e) { // Captura las excepciones relacionadas con SQL.
            System.out.println(e); // Imprime el error en la consola.
        }
        con.cerrar(); // Cierra la conexión a la base de datos.
    }
}

/*
control_conexion con: La clase depende de control_conexion, 
que se encarga de gestionar las conexiones a la base de datos.

Manejo de excepciones: Cada operación SQL está envuelta en un bloque try-catch para capturar
y manejar posibles errores.

Operaciones CRUD: La clase realiza operaciones CRUD (crear, leer, actualizar, eliminar) 
sobre la tabla usuarios.

Manejo de recursos: Los PreparedStatement y ResultSet se cierran correctamente 
después de su uso para evitar fugas de recursos.
*/

