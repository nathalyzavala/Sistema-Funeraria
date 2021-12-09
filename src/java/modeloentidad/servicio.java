/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloentidad;

public class servicio {
    private int id_servicio;
    private String nombreServicio;
    private Float costo;

    public servicio() {
    }

    public servicio(int id_servicio, String nombreServicio, float costo) {
        this.id_servicio = id_servicio;
        this.nombreServicio = nombreServicio;
        this.costo = costo;
    }

    public servicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    
}
