package dao;

import conexion.Conexion;
import entidades.Cargo;
import java.sql.*;
import java.util.ArrayList;

public class Dao_Cargos {
    public static ArrayList<Cargo> getCargos(){
        ArrayList<Cargo> cargos = new ArrayList();
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            String sql = "select * from cargo";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                cargos.add(new Cargo(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
            }
            
        } catch (Exception e) {
            System.out.println("Error al obtener los cargos: " + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return cargos;
    }
    
    public static String getCargo(int id){
        
        
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            String sql = "select nombre from cargo where \"idCargo\" = " + id;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                return rs.getString(1);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener los cargos: " + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return "";
    }
}
