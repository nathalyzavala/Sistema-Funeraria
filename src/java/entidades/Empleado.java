package entidades;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Empleado {

    private int id;
    private String nombre;
    private String apellidos;
    private String direcion;
    private Cargo cargo;
    private String dui;
    private String telefono;
    private String fechaContrato;
    private String fechaNacimiento;
    private String correo;

    public Empleado(int id, String nombre, String apellidos, String direcion, Cargo cargo, String correo, String fechaContrato, String fechaNacimiento, String dui, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direcion = direcion;
        this.cargo = cargo;
        this.correo = correo;
        this.fechaContrato = fechaContrato;
        this.fechaNacimiento = fechaNacimiento;
        this.dui = dui;
        this.telefono = telefono;
    }

    public Empleado(int id, String nombre, String apellidos, String direcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direcion = direcion;
    }

    public Empleado(String nombre, String apellidos, String direcion, Cargo cargo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direcion = direcion;
        this.cargo = cargo;
    }

    public Empleado(String nombre, String apellidos, String direcion, Cargo cargo, String dui, String telefono, String fechaContrato, String fechaNacimiento, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direcion = direcion;
        this.cargo = cargo;
        this.dui = dui;
        this.telefono = telefono;
        this.fechaContrato = fechaContrato;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }

    public Empleado() {
        cargo = new Cargo();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Empleado(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public static String codigoRecuperacion() {
        int num1 = 97;
        int num2 = 122;
        String codigo = "";

        for (int i = 1; i <= 5; i++) {
            int numAleatorio = (int) Math.floor(Math.random() * (num2 - num1) + num1);
            codigo += (char) numAleatorio + "";
        }

        return codigo.toUpperCase();
    }

    public static boolean enviarCorreo(String codigo, String correo) {
        try {
            String host = "smtp.gmail.com";
            String user = "pruebasingprogra3@gmail.com";
            String pass = "pruebas123";
            String to = correo;
            String from = "pruebasingprogra3@gmail.com";
            String subject = "Recuperar Contraseña";
            String messageText = "El codigo de recuperacion de su cuenta es: " + codigo;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException ex) {
            System.out.println(ex);
            return false;
        }
    }

}
