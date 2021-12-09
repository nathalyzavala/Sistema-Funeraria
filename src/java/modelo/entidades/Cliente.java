/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;


public class Cliente {
    // hice esta clase para que furule pero si desean pueden solo copiar el 2do constructor
    private int idcliente;
    private String dui;
    private String nombre;
    private String direccion;
    private String telefono;

    public Cliente(int idcliente, String dui, String nombre, String direccion, String telefono) {
        this.idcliente = idcliente;
        this.dui = dui;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Cliente(int idcliente, String nombre) {
        this.idcliente = idcliente;
        this.nombre = nombre;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
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
    
    
}
