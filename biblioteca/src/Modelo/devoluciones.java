package Modelo; // Define el paquete llamado 'Modelo' al que pertenece esta clase.

public class devoluciones { // Define una clase pública llamada 'devoluciones'.
    
    // Variables privadas que almacenan información relacionada con la devolución de un préstamo.
    private String fechaprestamo; // Fecha en la que se hizo el préstamo.
    private String fechadevolucion; // Fecha en la que se espera o se realiza la devolución.
    private String Codigo; // Código que identifica un préstamo o una devolución específica.

    // Constructor vacío que no inicializa ninguna de las variables de la clase.
    public devoluciones() {
    }

    // Método para obtener la fecha del préstamo.
    public String getFechaprestamo() {
        return fechaprestamo;
    }

    // Método para obtener el código del préstamo o devolución.
    public String getCodigo() {
        return Codigo;
    }

    // Método para establecer el código del préstamo o devolución.
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    // Método para establecer la fecha del préstamo.
    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    // Método para obtener la fecha de devolución.
    public String getFechadevolucion() {
        return fechadevolucion;
    }

    // Método para establecer la fecha de devolución.
    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }
}

/*
La clase devoluciones representa la información relacionada con un préstamo 
y su devolución, como las fechas correspondientes y un código único que lo identifica.

Los atributos fechaprestamo 
y fechadevolucion se relacionan directamente con el control de tiempos en la gestión de préstamos, 
mientras que Codigo identifica de manera única cada préstamo o devolución.

Los métodos get y set permiten acceder y modificar estos datos, 
asegurando el principio de encapsulamiento, 
lo que significa que los datos están protegidos 
y solo pueden ser manipulados de manera controlada a través de estos métodos públicos.
*/