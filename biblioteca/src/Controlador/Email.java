package Controlador;  // Se define el paquete de la clase 'Email', que es parte del controlador.

import Vista.FrmUsuario;  // Se importa la clase 'FrmUsuario' desde el paquete Vista, aunque no se está utilizando explícitamente en este código.
import java.util.Properties;  // Se importa la clase Properties, usada para configurar las propiedades del servidor SMTP.
import javax.activation.DataHandler;  // Se importa la clase DataHandler para manejar los archivos adjuntos.
import javax.activation.FileDataSource;  // Se importa FileDataSource para leer el archivo adjunto desde una ruta especificada.
import javax.mail.BodyPart;  // Se importa BodyPart, que es un componente para construir el cuerpo del correo.
import javax.mail.Message;  // Se importa Message, que representa el mensaje de correo electrónico.
import javax.mail.Session;  // Se importa Session, que es la sesión de correo electrónico configurada con las propiedades SMTP.
import javax.mail.Transport;  // Se importa Transport, que es responsable de enviar el mensaje.
import javax.mail.internet.InternetAddress;  // Se importa InternetAddress para manejar direcciones de correo electrónico.
import javax.mail.internet.MimeBodyPart;  // Se importa MimeBodyPart, que representa una parte del mensaje con contenido MIME.
import javax.mail.internet.MimeMessage;  // Se importa MimeMessage, que es el mensaje de correo en formato MIME.
import javax.mail.internet.MimeMultipart;  // Se importa MimeMultipart, que permite combinar múltiples partes en un correo electrónico (texto y archivos adjuntos).
import javax.swing.JOptionPane;  // Se importa JOptionPane para mostrar cuadros de diálogo de información o error.

public class Email extends FrmUsuario {  // La clase 'Email' extiende de 'FrmUsuario', lo que indica que puede usar componentes de la clase FrmUsuario.

    // Declaración de variables de instancia de la clase 'Email'.
    String usuarioCorreo;
    String password;
    String rutaArchivo;
    String nombreArchivo;
    String destinatario;
    String asunto;
    String mensaje;

    // Constructor con todos los parámetros necesarios para enviar un correo con un archivo adjunto.
    public Email(String usuarioCorreo, String password, String rutaArchivo, String nombreArchivo, String destinatario, String asunto, String mensaje) {
        this.usuarioCorreo = usuarioCorreo;  // Asigna el correo del usuario.
        this.password = password;  // Asigna la contraseña del correo del usuario.
        this.rutaArchivo = rutaArchivo;  // Asigna la ruta del archivo adjunto.
        this.nombreArchivo = nombreArchivo;  // Asigna el nombre del archivo adjunto.
        this.destinatario = destinatario;  // Asigna el correo del destinatario.
        this.asunto = asunto;  // Asigna el asunto del correo.
        this.mensaje = mensaje;  // Asigna el cuerpo del mensaje.
    }
    
    // Constructor alternativo para enviar correo sin archivo adjunto.
    public Email(String usuarioCorre, String password, String destinatario, String mensaje) {
        this(usuarioCorre, password, "", "", destinatario, "", mensaje);  // Llama al constructor principal con valores por defecto para los archivos.
    }

    // Constructor alternativo para enviar correo con asunto pero sin archivo adjunto.
    public Email(String usuarioCorre, String password, String destinatario, String asunto, String mensaje) {
        this(usuarioCorre, password, "", "", destinatario, asunto, mensaje);  // Llama al constructor principal con valores por defecto para los archivos.
    }

    // Método que envía el correo electrónico.
    public boolean sendMail() {
        try {
            Properties props = new Properties();  // Se crean las propiedades para configurar el servidor SMTP.
            props.put("mail.smtp.host", "smtp.gmail.com");  // Configura el servidor SMTP (en este caso, Gmail).
            props.setProperty("mail.smtp.starttls.enable", "true");  // Habilita el cifrado TLS.
            props.setProperty("mail.smtp.port", "587");  // Configura el puerto SMTP para Gmail.
            props.setProperty("mail.smtp.user", usuarioCorreo);  // Configura el correo del usuario para la autenticación.
            props.setProperty("mail.smtp.auth", "true");  // Habilita la autenticación SMTP.

            Session session = Session.getDefaultInstance(props, null);  // Crea una sesión de correo con las propiedades configuradas.
            BodyPart texto = new MimeBodyPart();  // Crea la primera parte del mensaje (cuerpo de texto).
            texto.setText(mensaje);  // Establece el cuerpo del mensaje.

            BodyPart adjunto = new MimeBodyPart();  // Crea una segunda parte del mensaje para el archivo adjunto.
            if (!rutaArchivo.equals("")) {  // Verifica si se especificó una ruta de archivo adjunto.
                adjunto.setDataHandler(new DataHandler(new FileDataSource(rutaArchivo)));  // Establece el archivo adjunto.
                adjunto.setFileName(nombreArchivo);  // Establece el nombre del archivo adjunto.
            }

            MimeMultipart multiParte = new MimeMultipart();  // Crea una estructura multipart para combinar texto y archivo adjunto.
            multiParte.addBodyPart(texto);  // Agrega la parte de texto al mensaje.
            if (!rutaArchivo.equals("")) {  // Si hay un archivo adjunto, se agrega al mensaje.
                multiParte.addBodyPart(adjunto);  // Agrega la parte del archivo adjunto.
            }

            MimeMessage message = new MimeMessage(session);  // Crea un mensaje de correo.
            message.setFrom(new InternetAddress(usuarioCorreo));  // Establece el remitente del mensaje.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));  // Establece el destinatario del mensaje.
            message.setSubject(asunto);  // Establece el asunto del mensaje.
            message.setContent(multiParte);  // Establece el contenido del mensaje (texto y archivo adjunto).

            Transport t = session.getTransport("smtp");  // Obtiene el transporte SMTP para enviar el correo.
            t.connect(usuarioCorreo, password);  // Se conecta al servidor SMTP utilizando las credenciales del usuario.
            t.sendMessage(message, message.getAllRecipients());  // Envía el mensaje a todos los destinatarios.
            t.close();  // Cierra la conexión SMTP.
            return true;  // Indica que el correo se envió con éxito.
        } catch (Exception e) {  // Si ocurre algún error, se captura y maneja.
            e.printStackTrace();  // Imprime el error en la consola.
            return false;  // Retorna false si hubo un error al enviar el correo.
        }
    }

    // El método main está comentado, pero se utilizaría para probar el envío de un correo.
    // public static void main(String[] args) {
    //     String clave = "bootlvxxfxkxwejs";  // La clave de la cuenta de correo.
    //     Email e = new Email("jotavaldivia18@gmail.com", clave, "", "Adjunto", "Prueba del tutorial para mandar un email");
    //     if (e.sendMail()) {
    //         JOptionPane.showMessageDialog(null, "El email se ha enviado correctamente");
    //     } else {
    //         JOptionPane.showMessageDialog(null, "Error mensaje no enviado");
    //     }
    // }
}
