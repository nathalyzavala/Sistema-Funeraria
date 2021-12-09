/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;


public class Cargo {
    private String id_cargo;
    private String nombre; 
    private double salario;

    public Cargo(String id_cargo, String nombre, double salario) {
        this.id_cargo = id_cargo;
        this.nombre = nombre;
        this.salario = salario;
    }

    public Cargo(String id_cargo, String nombre) {
        this.id_cargo = id_cargo;
        this.nombre = nombre;
    }
    

    public Cargo(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public Cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }

    
    public Cargo() {
    }

    public String getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
