/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloentidad;

public class DetalleServ {
    private int id_detalleservicio;
    private int id_servicio;
    private int id_producto;
    private int cantidad;
    private producto produ;

    public DetalleServ(int id_detalleservicio, int id_servicio, int id_producto, int cantidad, producto produ) {
        this.id_detalleservicio = id_detalleservicio;
        this.id_servicio = id_servicio;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.produ = produ;
    }

    
    public DetalleServ(int id_producto, int cantidad, producto p) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.produ = p;
    }
    public DetalleServ() {
    }

    public DetalleServ(int id_servicio, int id_producto, int cantidad) {
        this.id_servicio = id_servicio;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }
    
    public DetalleServ(int id_detalleservicio, int id_servicio, int id_producto, int cantidad) {
        this.id_detalleservicio = id_detalleservicio;
        this.id_servicio = id_servicio;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public producto getProdu() {
        return produ;
    }

    public void setProdu(producto produ) {
        this.produ = produ;
    }

    public int getId_detalleservicio() {
        return id_detalleservicio;
    }

    public void setId_detalleservicio(int id_detalleservicio) {
        this.id_detalleservicio = id_detalleservicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
