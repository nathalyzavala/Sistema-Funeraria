/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;


public class DetalleVenta {
    private int id_detalleventa;
    private int id_encabezadoventa;
    private int id_serviciod;
    private int cantidadcuota;
    private boolean estado;

    public DetalleVenta(int id_detalleventa, int id_encabezadoventa, int id_serviciod, int cantidadcuota, boolean estado) {
        this.id_detalleventa = id_detalleventa;
        this.id_encabezadoventa = id_encabezadoventa;
        this.id_serviciod = id_serviciod;
        this.cantidadcuota = cantidadcuota;
        this.estado = estado;
    }

    public int getId_detalleventa() {
        return id_detalleventa;
    }

    public void setId_detalleventa(int id_detalleventa) {
        this.id_detalleventa = id_detalleventa;
    }

    public int getId_encabezadoventa() {
        return id_encabezadoventa;
    }

    public void setId_encabezadoventa(int id_encabezadoventa) {
        this.id_encabezadoventa = id_encabezadoventa;
    }

    public int getId_serviciod() {
        return id_serviciod;
    }

    public void setId_serviciod(int id_serviciod) {
        this.id_serviciod = id_serviciod;
    }

    public int getCantidadcuota() {
        return cantidadcuota;
    }

    public void setCantidadcuota(int cantidadcuota) {
        this.cantidadcuota = cantidadcuota;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
