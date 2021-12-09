package dao;

import entidades.Producto;
import java.sql.*;
import java.util.ArrayList;
import conexion.Conexion;

public class Dao_Productos {
    
    public static ArrayList<Producto> getProductos(){
        ArrayList<Producto> productos = new ArrayList();
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select * from producto";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                productos.add(new Producto(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los productos" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return productos;
    }
    
}
