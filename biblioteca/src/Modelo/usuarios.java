
package Modelo; // Define el paquete 'Modelo' al que pertenece esta clase, organizando la clase en la estructura del proyecto.

public class usuarios { // Define una clase pública llamada 'usuarios', que puede ser usada en otras partes del programa.
    
    // Atributos privados que almacenan la información de un usuario.
    private String usu_rut; // RUT (Rol Único Tributario) del usuario, que podría ser un identificador único.
    private String usu_nombre; // Nombre del usuario.
    private String usu_apellido; // Apellido del usuario.
    private String usu_direccion; // Dirección del usuario.
    private String usu_telefono; // Número de teléfono del usuario.

    // Constructor vacío que no asigna valores a los atributos al crear un objeto.
    public usuarios() {
    }

    // Constructor con parámetros que permite inicializar los atributos al crear un objeto.
    public usuarios(String usu_rut, String usu_nombre, String usu_apellido, String usu_direccion, String usu_telefono) {
        // Inicializa los atributos con los valores proporcionados por los parámetros.
        this.usu_rut = usu_rut; // Asigna el valor del parámetro 'usu_rut' al atributo 'usu_rut'.
        this.usu_nombre = usu_nombre; // Asigna el valor del parámetro 'usu_nombre' al atributo 'usu_nombre'.
        this.usu_apellido = usu_apellido; // Asigna el valor del parámetro 'usu_apellido' al atributo 'usu_apellido'.
        this.usu_direccion = usu_direccion; // Asigna el valor del parámetro 'usu_direccion' al atributo 'usu_direccion'.
        this.usu_telefono = usu_telefono; // Asigna el valor del parámetro 'usu_telefono' al atributo 'usu_telefono'.
    }

    // Métodos de acceso (getters) y modificación (setters) para cada atributo.
    
    // Método para obtener el valor del atributo 'usu_rut'.
    public String getUsu_rut() {
        return usu_rut; // Devuelve el RUT del usuario.
    }

    // Método para establecer el valor del atributo 'usu_rut'.
    public void setUsu_rut(String usu_rut) {
        this.usu_rut = usu_rut; // Asigna un nuevo valor al RUT del usuario.
    }

    // Método para obtener el valor del atributo 'usu_nombre'.
    public String getUsu_nombre() {
        return usu_nombre; // Devuelve el nombre del usuario.
    }

    // Método para establecer el valor del atributo 'usu_nombre'.
    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre; // Asigna un nuevo valor al nombre del usuario.
    }

    // Método para obtener el valor del atributo 'usu_apellido'.
    public String getUsu_apellido() {
        return usu_apellido; // Devuelve el apellido del usuario.
    }

    // Método para establecer el valor del atributo 'usu_apellido'.
    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido = usu_apellido; // Asigna un nuevo valor al apellido del usuario.
    }

    // Método para obtener el valor del atributo 'usu_direccion'.
    public String getUsu_direccion() {
        return usu_direccion; // Devuelve la dirección del usuario.
    }

    // Método para establecer el valor del atributo 'usu_direccion'.
    public void setUsu_direccion(String usu_direccion) {
        this.usu_direccion = usu_direccion; // Asigna un nuevo valor a la dirección del usuario.
    }

    // Método para obtener el valor del atributo 'usu_telefono'.
    public String getUsu_telefono() {
        return usu_telefono; // Devuelve el número de teléfono del usuario.
    }

    // Método para establecer el valor del atributo 'usu_telefono'.
    public void setUsu_telefono(String usu_telefono) {
        this.usu_telefono = usu_telefono; // Asigna un nuevo valor al número de teléfono del usuario.
    }
}
/*
Atributos: usu_rut, usu_nombre, usu_apellido, usu_direccion, y usu_telefono son atributos privados 
que contienen información específica del usuario. 
Están encapsulados para proteger la integridad de los datos, de manera que solo puedan ser accedidos 
o modificados a través de los métodos públicos.

Constructores: Se define un constructor vacío que permite crear un objeto usuarios sin inicializar 
los atributos y un constructor con parámetros que permite establecer todos los atributos al crear el objeto.

Métodos getters y setters: Estos métodos se utilizan para obtener y modificar los valores de los atributos. 
Siguen el principio de encapsulamiento, asegurando que se pueda controlar el acceso 
y la modificación de los datos de manera segura.

Relaciones: Esta clase se puede usar en sistemas donde se necesite gestionar información de usuarios, 
como sistemas de registro o aplicaciones de gestión de datos personales. Los atributos 
y métodos proporcionan una manera estructurada de trabajar con la información de los usuarios.
*/