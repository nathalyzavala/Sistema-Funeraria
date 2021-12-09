/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.entidades.Cliente;
import modelo.entidades.Fiador;
import modelo.entidades.PagoCuotas;
import modelo.entidades.Servicios;
import modelo.entidades.DetalleVenta;


public class dao_cuotas {
    private static Conexion conexion;

    public dao_cuotas() {
        this.conexion = new Conexion();
    }
    public void setRegistrar(PagoCuotas pagos){
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO pago_cuotas(fecha_pago, cuota, id_detalleventaservocio) VALUES ('"+pagos.getFechacuota()+"', '"+pagos.getMonto()+"', '"+pagos.getIdDetalleServicio()+"')");
            conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }
    
        public ArrayList<PagoCuotas> MostrarCuotas() throws SQLException{
        ArrayList<PagoCuotas> listacuota = new ArrayList<>();
        ResultSet rs = null;
        
        try{
            Connection accesoDB = conexion.getConexion();
            String sql = "";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
//                listacuota.add(new PagoCuotas());
            }
            Conexion.cerrarConexiones();
        }catch(Exception e){
            System.out.println("Error al mostrar los datos"+e);
    }
        return listacuota;
    }
    
    public ArrayList<DetalleVenta> Mostrardetalleventa() throws SQLException{
        ArrayList<DetalleVenta> listadetalleventa = new ArrayList<>();
        ResultSet rs = null;
        
        try{
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM detalle_venta";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                listadetalleventa.add(new DetalleVenta(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getBoolean(5)));
            }
            Conexion.cerrarConexiones();
        }catch(Exception e){
            System.out.println("Error al mostrar los datos"+e);
    }
        return listadetalleventa;
    }
        
    public boolean ifCuotas(int cantidadcuotas){
            if(cantidadcuotas>1){
                return true;
            }else{
                return false;
            }
    }
       
}
