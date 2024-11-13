package Modelo; // Define el paquete llamado 'Modelo' al que pertenece esta clase.

public class preguntas { // Define una clase pública llamada 'preguntas'.
    
    // Atributos privados que representan las propiedades de una pregunta.
    private String pre_codigo; // Código único que identifica la pregunta.
    private String pre_pregunta; // Texto o contenido de la pregunta.

    // Constructor vacío que no inicializa los atributos al crear un objeto de esta clase.
    public preguntas() {
    }

    // Constructor con parámetros que permite inicializar 'pre_codigo' y 'pre_pregunta' al crear un objeto.
    public preguntas(String pre_codigo, String pre_pregunta) {
        this.pre_codigo = pre_codigo; // Asigna el valor del parámetro 'pre_codigo' al atributo 'pre_codigo'.
        this.pre_pregunta = pre_pregunta; // Asigna el valor del parámetro 'pre_pregunta' al atributo 'pre_pregunta'.
    }

    // Métodos de acceso (mutadores) para los atributos.
    
    // Método para obtener el valor del atributo 'pre_codigo'.
    public String getPre_codigo() {
        return pre_codigo;
    }

    // Método para establecer el valor del atributo 'pre_codigo'.
    public void setPre_codigo(String pre_codigo) {
        this.pre_codigo = pre_codigo;
    }

    // Método para obtener el valor del atributo 'pre_pregunta'.
    public String getPre_pregunta() {
        return pre_pregunta;
    }

    // Método para establecer el valor del atributo 'pre_pregunta'.
    public void setPre_pregunta(String pre_pregunta) {
        this.pre_pregunta = pre_pregunta;
    }
    
    // Método que sobrescribe el método 'toString' de la clase 'Object'.
    @Override
    public String toString() {
        return pre_pregunta; // Devuelve el texto de la pregunta cuando se imprime el objeto.
    }
}

/*
La clase preguntas está diseñada para representar una pregunta con un código único 
y el contenido de la pregunta.

Los atributos pre_codigo y pre_pregunta son privados, 
lo que significa que solo se pueden acceder o modificar a través de los métodos públicos get y set.

Hay dos constructores: uno vacío, que no asigna valores a los atributos, y otro con parámetros, 
que permite inicializar los atributos cuando se crea un objeto.

El método toString sobrescribe el método predeterminado de la clase Object 
y devuelve el contenido de la pregunta. 
Esto es útil cuando se quiere imprimir o representar el objeto como una cadena, 
mostrando el contenido de pre_pregunta.

Los métodos get y set proporcionan un control seguro y estructurado para acceder 
y modificar los atributos de la clase, siguiendo el principio de encapsulamiento.
*/
