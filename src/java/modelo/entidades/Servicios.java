/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

public class Servicios {
    private int idservicios;
    private String nombre;
    private double costo;

    public Servicios(int idservicios, String nombre, double costo) {
        this.idservicios = idservicios;
        this.nombre = nombre;
        this.costo = costo;
    }

    

    public int getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(int idservicios) {
        this.idservicios = idservicios;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
