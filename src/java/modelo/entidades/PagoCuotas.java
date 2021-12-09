/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.sql.Date;


public class PagoCuotas {
    private int idcuota;
    private Date fechacuota;
    private double monto;
    private int idDetalleServicio;
    private String nombrecliente;

    public PagoCuotas(int idcuota, Date fechacuota, double monto, int idDetalleServicio) {
        this.idcuota = idcuota;
        this.fechacuota = fechacuota;
        this.monto = monto;
        this.idDetalleServicio = idDetalleServicio;
    }

    public PagoCuotas(int idcuota, Date fechacuota, double monto, int idDetalleServicio, String nombrecliente) {
        this.idcuota = idcuota;
        this.fechacuota = fechacuota;
        this.monto = monto;
        this.idDetalleServicio = idDetalleServicio;
        this.nombrecliente = nombrecliente;
    }
    

    public int getIdcuota() {
        return idcuota;
    }

    public void setIdcuota(int idcuota) {
        this.idcuota = idcuota;
    }

    public Date getFechacuota() {
        return fechacuota;
    }

    public void setFechacuota(Date fechacuota) {
        this.fechacuota = fechacuota;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdDetalleServicio() {
        return idDetalleServicio;
    }

    public void setIdDetalleServicio(int idDetalleServicio) {
        this.idDetalleServicio = idDetalleServicio;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }
    
    
    
}
