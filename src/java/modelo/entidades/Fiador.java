/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;


public class Fiador {
    private int idfiador;
    private String nombre;
    private String direccion;
    private String telefono;
    private int idcliente;
    private String nombrecliente;
    private String dui;

    public Fiador() {
    }

    public Fiador(int idfiador, String nombre, String direccion, String telefono, int idcliente, String dui) {
        this.idfiador = idfiador;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idcliente = idcliente;
        this.dui = dui;
    }

    public Fiador(int idfiador, String nombre, String direccion, String telefono, int idcliente, String nombrecliente, String dui) {
        this.idfiador = idfiador;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idcliente = idcliente;
        this.nombrecliente = nombrecliente;
        this.dui = dui;
    }
    

    public Fiador(String nombre, String direccion, String telefono, int idcliente, String dui) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idcliente = idcliente;
        this.dui=dui;
    }


    

    public int getIdfiador() {
        return idfiador;
    }

    public void setIdfiador(int idfiador) {
        this.idfiador = idfiador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
      
}
