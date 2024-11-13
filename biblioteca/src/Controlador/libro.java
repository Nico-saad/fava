package Controlador;
import Controlador.control_conexion;  // Importa la clase control_conexion para manejar la conexión a la base de datos.
import java.sql.*;  // Importa las clases necesarias para trabajar con bases de datos en Java.

public class libro {

    control_conexion con = new control_conexion();  // Se crea un objeto de control_conexion para manejar la conexión con la base de datos.

    public libro() {
        this.con = new control_conexion();  // Inicializa el objeto de conexión.
    } 

    // Método para agregar un nuevo libro en la base de datos
    public void nuevolibro(String titulo, String editorial, String autor) {
        try {
            con.conectar();  // Establece la conexión a la base de datos.
            // Prepara la consulta SQL para insertar un nuevo libro en la tabla "libros".
            PreparedStatement pstm = con.estado().prepareStatement("insert into libros(titulo, cod_edit, cod_aut) values(?,?,?)");
            pstm.setString(1, titulo);  // Establece el primer parámetro (título del libro).
            pstm.setString(2, editorial);  // Establece el segundo parámetro (código de la editorial).
            pstm.setString(3, autor);  // Establece el tercer parámetro (código del autor).
            pstm.execute();  // Ejecuta la consulta SQL para insertar el libro.
            pstm.close();  // Cierra el PreparedStatement.
        } catch(SQLException e) {
            System.out.println(e);  // Si ocurre una excepción, se imprime el error.
        }
        con.cerrar();  // Cierra la conexión con la base de datos.
    }

    // Método para obtener todos los libros desde la base de datos y devolverlos en una matriz
    public Object[][] getDatos() {
        int x = 0;
        // Obtiene la cantidad de registros en la tabla "libros"
        try {
            con.conectar();  // Establece la conexión a la base de datos.
            PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM libros ");
            ResultSet res = pstm.executeQuery();
            res.next();  // Se mueve al primer (y único) resultado.
            x = res.getInt("total");  // Obtiene el total de registros.
            res.close();  // Cierra el ResultSet.
        } catch(SQLException e) {
            System.out.println(e);  // Si ocurre una excepción, la imprime.
            con.cerrar();  // Cierra la conexión si ocurre un error.
        }
        
        // Crea una matriz para almacenar los datos de los libros
        Object[][] s = new String[x][4];  
        // Realiza la consulta SQL para obtener los detalles de los libros
        try {
            con.conectar();  // Establece la conexión a la base de datos.
            PreparedStatement pstm = con.estado().prepareStatement("SELECT li.cod_lib, li.titulo, e.cod_edit, a.cod_aut " +
                                                                   "FROM libros li " +
                                                                   "LEFT JOIN editoriales e on li.cod_edit = e.cod_edit " +
                                                                   "LEFT JOIN autores a on li.cod_aut = a.cod_aut " +
                                                                   "ORDER BY li.cod_lib");
            ResultSet res = pstm.executeQuery();  // Ejecuta la consulta SQL.
            int i = 0;
            while(res.next()) {  // Itera sobre los resultados del ResultSet.
                // Obtiene los valores de cada columna y los asigna a la matriz.
                String estCodigo = res.getString("li.cod_lib");
                String esttitulo = res.getString("li.titulo");
                String esteditorial = res.getString("e.cod_edit");
                String estautor = res.getString("a.cod_aut");
                s[i][0] = estCodigo;
                s[i][1] = esttitulo;
                s[i][2] = esteditorial;
                s[i][3] = estautor;
                i++;  // Incrementa el índice de la matriz.
            }
            res.close();  // Cierra el ResultSet.
        } catch(SQLException e) {
            System.out.println(e);  // Si ocurre una excepción, la imprime.
        }
        con.cerrar();  // Cierra la conexión con la base de datos.
        return s;  // Retorna la matriz con los datos de los libros.
    }

    // Método para eliminar un libro basado en su código
    public void eliminarlibro(String cod) {
        try {
            con.conectar();  // Establece la conexión con la base de datos.
            // Prepara la consulta SQL para eliminar un libro con un código específico.
            PreparedStatement aaa = con.estado().prepareStatement("delete from libros where cod_lib = ?");
            aaa.setString(1, cod);  // Establece el parámetro (código del libro).
            aaa.execute();  // Ejecuta la consulta de eliminación.
            aaa.close();  // Cierra el PreparedStatement.
        } catch(SQLException e) {
            System.out.println(e);  // Si ocurre una excepción, la imprime.
        }
        con.cerrar();  // Cierra la conexión con la base de datos.
    }
}
