package Controlador;  // Se define el paquete al que pertenece esta clase.

import java.sql.*;  // Se importa todo el paquete java.sql para trabajar con bases de datos.

public class Editorial {  // Se define la clase 'Editorial'.

    control_conexion con = new control_conexion();  // Se crea un objeto 'con' de la clase 'control_conexion' para gestionar la conexión a la base de datos.

    public Editorial (){  // Constructor de la clase 'Editorial'.
        this.con = new control_conexion();  // Se inicializa la conexión a la base de datos.
    }

    /* Añade un nuevo registro */
    public void Nuevaeditorial(String editorial){  // Método que recibe un parámetro 'editorial' para agregar una nueva editorial.
        try {  // Inicia un bloque try-catch para manejar excepciones SQL.
            con.conectar();  // Se establece la conexión con la base de datos.
            // Se prepara la sentencia SQL para insertar un nuevo registro en la tabla 'editoriales'.
            PreparedStatement pstm = con.estado().prepareStatement("insert into " + 
                    "editoriales(editorial) " +  // Se especifica la tabla 'editoriales' y la columna 'editorial'.
                    " values(?)");  // Se coloca un signo de interrogación para el valor a insertar.
            pstm.setString(1, editorial);  // Se asigna el valor de la variable 'editorial' al primer parámetro de la consulta.
            pstm.execute();  // Se ejecuta la consulta SQL.
            pstm.close();  // Se cierra el 'PreparedStatement' para liberar recursos.
        } catch(SQLException e){  // Captura cualquier excepción SQL.
            System.out.println(e);  // Imprime el error de la excepción.
            con.cerrar();  // Cierra la conexión con la base de datos en caso de error.
        }
    }

    /* Obtenemos todos los datos de la tabla */
    public Object [][] getDatos(){  // Método que obtiene todos los datos de la tabla 'editoriales' y los devuelve en una matriz de objetos.
        int x = 0;  // Variable para almacenar la cantidad de registros.
        // Obtenemos la cantidad de registros existentes en la tabla.
        try{   
            con.conectar();  // Se establece la conexión con la base de datos.
            // Se prepara la sentencia SQL para contar la cantidad de registros en la tabla 'editoriales'.
            PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM editoriales ");
            ResultSet res = pstm.executeQuery();  // Ejecuta la consulta y guarda el resultado en 'res'.
            res.next();  // Avanza al primer registro del resultado.
            x = res.getInt("total");  // Asigna el valor de la cantidad total de registros a 'x'.
            res.close();  // Cierra el 'ResultSet' para liberar recursos.
        } catch(SQLException e){  // Captura cualquier excepción SQL.
            System.out.println(e);  // Imprime el error de la excepción.
            con.cerrar();  // Cierra la conexión con la base de datos en caso de error.
        }

        Object[][] s = new String[x][2];  // Se crea una matriz 's' con el tamaño adecuado para almacenar los registros obtenidos.
        // Realizamos la consulta SQL y llenamos los datos en la matriz 's'.
        try{    
            con.conectar();  // Establece la conexión con la base de datos nuevamente.
            // Se prepara la consulta SQL para obtener los registros de la tabla 'editoriales'.
            PreparedStatement pstm = con.estado().prepareStatement("SELECT " +
                " cod_edit, editorial " +  // Se seleccionan las columnas 'cod_edit' y 'editorial'.
                " FROM editoriales" +  // De la tabla 'editoriales'.
                " ORDER BY cod_edit ");  // Los resultados se ordenan por 'cod_edit'.
            ResultSet res = pstm.executeQuery();  // Ejecuta la consulta y guarda el resultado en 'res'.
            int i = 0;  // Se inicializa un índice para recorrer la matriz.
            while(res.next()){  // Mientras haya más registros en el 'ResultSet'.
                String estCodigo = res.getString("cod_edit");  // Obtiene el valor de la columna 'cod_edit'.
                String estEditorial = res.getString("editorial");  // Obtiene el valor de la columna 'editorial'.
                s[i][0] = estCodigo;  // Asigna el valor del código de la editorial a la matriz.
                s[i][1] = estEditorial;  // Asigna el nombre de la editorial a la matriz.
                i++;  // Incrementa el índice para la siguiente fila de la matriz.
            }
            res.close();  // Cierra el 'ResultSet' para liberar recursos.
        } catch(SQLException e){  // Captura cualquier excepción SQL.
            System.out.println(e);  // Imprime el error de la excepción.
        }
        con.cerrar();  // Cierra la conexión con la base de datos al finalizar.
        return s;  // Devuelve la matriz con los datos de la tabla.
    }

    public void Actualizareditorial(String codigo, String editorial){  // Método que actualiza el valor de una editorial.
        try {    
            con.conectar();  // Establece la conexión con la base de datos.
            // Se prepara la consulta SQL para actualizar el registro de la tabla 'editoriales' según el código de la editorial.
            PreparedStatement pstm = con.estado().prepareStatement("update editoriales " +
                "set editorial = ? " +  // Se indica que se actualizará la columna 'editorial'.
                "where cod_edit = ? ");  // Se filtra por el código de la editorial.
            pstm.setString(1, editorial);  // Asigna el nuevo valor para la columna 'editorial'.
            pstm.setString(2, codigo);  // Asigna el código de la editorial a actualizar.
            pstm.execute();  // Ejecuta la consulta SQL.
            pstm.close();  // Cierra el 'PreparedStatement'.
        } catch(SQLException e){  // Captura cualquier excepción SQL.
            System.out.println(e);  // Imprime el error de la excepción.
            con.cerrar();  // Cierra la conexión con la base de datos en caso de error.
        }
    }

    // Eliminar Editorial
    public void eliminareditorial(String cod){  // Método para eliminar un registro de la tabla 'editoriales' basado en el código proporcionado.
        try { 
            con.conectar();  // Establece la conexión con la base de datos.
            // Se prepara la consulta SQL para eliminar un registro de la tabla 'autores' (aquí hay un error, debería ser 'editoriales').
            PreparedStatement aaa = con.estado().prepareStatement("delete from autores where cod_edit = ?");  // La consulta SQL está incorrecta.
            aaa.setString(1, cod);  // Asigna el código de la editorial a eliminar.
            aaa.execute();  // Ejecuta la consulta SQL.
            aaa.close();  // Cierra el 'PreparedStatement'.
        } catch(SQLException e){  // Captura cualquier excepción SQL.
            System.out.println(e);  // Imprime el error de la excepción.
        }  
        con.cerrar();  // Cierra la conexión con la base de datos al finalizar.
    }
}
