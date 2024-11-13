package Modelo; // Define el paquete al que pertenece esta clase, llamado 'Modelo'.

public class autores { // Define una clase pública llamada 'autores'.
    // Variables privadas para almacenar la información del autor.
    private String codigo_autor; // Código único que identifica al autor.
    private String nombre_autor; // Nombre del autor.
    private String apellidomaterno_autor; // Apellido materno del autor.
    private String apellidoPaterno_autor; // Apellido paterno del autor.
    private String pais_autor; // País de origen del autor.

    // Constructor vacío que no hace nada específico al inicializar un objeto de esta clase.
    public autores() {
    }

    // Método para obtener el código del autor.
    public String getCodigo_autor() {
        return codigo_autor;
    }

    // Método para establecer el código del autor.
    public void setCodigo_autor(String codigo_autor) {
        this.codigo_autor = codigo_autor;
    }

    // Método para obtener el nombre del autor.
    public String getNombre_autor() {
        return nombre_autor;
    }

    // Método para establecer el nombre del autor.
    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    // Método para obtener el apellido materno del autor.
    public String getApellidomaterno_autor() {
        return apellidomaterno_autor;
    }

    // Método para establecer el apellido materno del autor.
    public void setApellidomaterno_autor(String apellidomaterno_autor) {
        this.apellidomaterno_autor = apellidomaterno_autor;
    }

    // Método para obtener el apellido paterno del autor.
    public String getApellidoPaterno_autor() {
        return apellidoPaterno_autor;
    }

    // Método para establecer el apellido paterno del autor.
    public void setApellidoPaterno_autor(String apellidoPaterno_autor) {
        this.apellidoPaterno_autor = apellidoPaterno_autor;
    }

    // Método para obtener el país del autor.
    public String getPais_autor() {
        return pais_autor;
    }

    // Método para establecer el país del autor.
    public void setPais_autor(String pais_autor) {
        this.pais_autor = pais_autor;
    }
}

/*
Atributos: Los atributos codigo_autor, nombre_autor, apellidomaterno_autor, 
apellidoPaterno_autor y pais_autor son privados para proteger los datos 
y asegurar que solo puedan ser accedidos y modificados a través de los métodos públicos (encapsulamiento).

Constructores: El constructor vacío permite crear objetos de la clase autores sin necesidad de pasar valores
iniciales, lo cual es útil para ciertos casos en los que se desea establecer 
los atributos después de crear el objeto.

Métodos getters y setters: Los métodos get devuelven el valor de un atributo, 
y los métodos set permiten asignar o cambiar el valor de un atributo específico. 
Esto proporciona un control adecuado sobre cómo se accede y modifica la información.

Relaciones: Esta clase podría usarse en sistemas de gestión de información, 
como una base de datos de autores en una biblioteca o un sistema de publicación, 
donde cada autor debe ser identificado de manera única y su información debe ser manejada de forma estructurada.
*/
