/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import entidades.PagoCuotas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class dao_cuotas {
    private static Conexion conexion;

    public dao_cuotas() {
        this.conexion = new Conexion();
    }
    public boolean setRegistrar(String sql){
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate(sql);
            conexion.cerrarConexiones();
            return true;
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            conexion.cerrarConexiones();
            return false;
        }
    }
    
        public ArrayList<PagoCuotas> MostrarCuotas(int detalleventa) throws SQLException{
        ArrayList<PagoCuotas> listacuota = new ArrayList<>();
        ResultSet rs = null;
        
        try{
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM pago_cuotas WHERE pago_cuotas.id_detalleventaservocio = "+detalleventa+" ORDER BY pago_cuotas.numero_cuotas";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
              listacuota.add(new PagoCuotas(rs.getInt(1),rs.getDate(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5)));
            }
            Conexion.cerrarConexiones();
        }catch(Exception e){
            System.out.println("Error al mostrar los datos"+e);
            conexion.cerrarConexiones();
    }
        return listacuota;
    }
        
    public int cantidadcuota(int detalleventa){
        int cantidad=0;
        ResultSet rs = null;
        try{
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT detalle_venta.cantidad_cuotas FROM detalle_venta WHERE detalle_venta.id_detalleventa = "+detalleventa+"";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
              cantidad=rs.getInt(1);
            }
            Conexion.cerrarConexiones();
        }catch(Exception e){
            System.out.println("Error al mostrar los datos"+e);
            conexion.cerrarConexiones();
    }
        return cantidad;
    }
    
    public int idservicio(int detalleventa){
        int idservicio=0;
        ResultSet rs = null;
        try{
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT detalle_venta.id_serviciod FROM detalle_venta WHERE detalle_venta.id_detalleventa = "+detalleventa+"";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
              idservicio=rs.getInt(1);
            }
            Conexion.cerrarConexiones();
        }catch(Exception e){
            System.out.println("Error al mostrar los datos"+e);
            conexion.cerrarConexiones();
    }
        return idservicio;
    }
    
   
       
}
