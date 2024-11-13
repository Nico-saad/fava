package Modelo; // Define el paquete llamado 'Modelo' al que pertenece esta clase.

public class personas { // Define una clase pública llamada 'personas'.

    // Atributos privados que representan las propiedades de una persona.
    private String per_usuraio; // Nombre de usuario de la persona.
    private String per_password; // Contraseña de la persona.
    private String per_nombres; // Nombres de la persona.
    private String per_apellidos; // Apellidos de la persona.

    // Constructor vacío que no hace nada específico al crear un objeto de esta clase.
    public personas() {
    }

    // Métodos de acceso (mutadores y acccesadores) para los atributos.
    
    // Método para obtener el nombre de usuario.
    public String getPer_usuraio() {
        return per_usuraio;
    }

    // Método para establecer el nombre de usuario.
    public void setPer_usuraio(String per_usuraio) {
        this.per_usuraio = per_usuraio;
    }

    // Método para obtener la contraseña.
    public String getPer_password() {
        return per_password;
    }

    // Método para establecer la contraseña.
    public void setPer_password(String per_password) {
        this.per_password = per_password;
    }

    // Método para obtener los nombres de la persona.
    public String getPer_nombres() {
        return per_nombres;
    }

    // Método para establecer los nombres de la persona.
    public void setPer_nombres(String per_nombres) {
        this.per_nombres = per_nombres;
    }

    // Método para obtener los apellidos de la persona.
    public String getPer_apellidos() {
        return per_apellidos;
    }

    // Método para establecer los apellidos de la persona.
    public void setPer_apellidos(String per_apellidos) {
        this.per_apellidos = per_apellidos;
    }
}

/*
La clase personas define una estructura básica para representar la información de una persona, 
como su nombre de usuario, contraseña, nombres y apellidos.

Los atributos per_usuraio, per_password, per_nombres y per_apellidos son privados, 
lo que significa que solo se pueden acceder o modificar a través de los métodos públicos de la clase.

Los métodos get permiten obtener los valores de los atributos, 
mientras que los métodos set permiten establecer o cambiar los valores de esos atributos.

Este diseño sigue el principio de encapsulamiento, asegurando que los datos estén protegidos 
y que solo se puedan manipular a través de métodos específicos para mayor control y seguridad.
*/