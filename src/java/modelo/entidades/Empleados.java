package modelo.entidades;

import java.sql.Date;

public class Empleados {

    private String id_empleado;
    private String nombree;
    private String apellidoe;
    private String direccion;
    private String dui;
    private String telefono;
    private String fechaContrato;
    private String fechaNacimiento;
    private String cargo;
    private String correo;
    

    public Empleados() {
    }

    public Empleados(String id_empleado, String nombree, String apellidoe, String direccion, String dui, String telefono, String fechaContrato, String fechaNacimiento, String cargo, String correo) {
        this.id_empleado = id_empleado;
        this.nombree = nombree;
        this.apellidoe = apellidoe;
        this.direccion = direccion;
        this.dui = dui;
        this.telefono = telefono;
        this.fechaContrato = fechaContrato;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
        this.correo = correo;
    }

    public Empleados(String nombree, String apellidoe, String direccion, String dui, String telefono, String fechaContrato, String fechaNacimiento, String cargo, String correo) {
        this.nombree = nombree;
        this.apellidoe = apellidoe;
        this.direccion = direccion;
        this.dui = dui;
        this.telefono = telefono;
        this.fechaContrato = fechaContrato;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
        this.correo = correo;
    }

    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombree() {
        return nombree;
    }

    public void setNombree(String nombree) {
        this.nombree = nombree;
    }

    public String getApellidoe() {
        return apellidoe;
    }

    public void setApellidoe(String apellidoe) {
        this.apellidoe = apellidoe;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    
    

}