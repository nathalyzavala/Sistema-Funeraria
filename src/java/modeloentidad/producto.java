/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloentidad;

import java.util.Properties;

public class producto {

    private int idproducto;
    private String nombrproducto;
    private float precioproducto;
    private int cantidadproducto;
    public producto() {
    }

    public producto(String nombrproducto) {
        this.nombrproducto = nombrproducto;
    }

    public producto(String nombrproducto, float precioproducto, int cantidadproducto) {
        this.nombrproducto = nombrproducto;
        this.precioproducto = precioproducto;
        this.cantidadproducto = cantidadproducto;
    }

    public producto(int idproducto, String nombrproducto, float precioproducto, int cantidadproducto) {
        this.idproducto = idproducto;
        this.nombrproducto = nombrproducto;
        this.precioproducto = precioproducto;
        this.cantidadproducto = cantidadproducto;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombrproducto() {
        return nombrproducto;
    }

    public void setNombrproducto(String nombrproducto) {
        this.nombrproducto = nombrproducto;
    }

    public float getPrecioproducto() {
        return precioproducto;
    }

    public void setPrecioproducto(float precioproducto) {
        this.precioproducto = precioproducto;
    }

    public int getCantidadproducto() {
        return cantidadproducto;
    }

    public void setCantidadproducto(int cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

}
