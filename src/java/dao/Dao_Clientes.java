package dao;

import conexion.Conexion;
import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Dao_Clientes {
    
    public static boolean setRegistrar(Cliente cliente) throws SQLException {
        try {
            Conexion conexion = new Conexion();
            Statement st = conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO cliente(duic, nombrec, apellidoc, telefono, direccionc)VALUES('" + cliente.getDui()+ "','" + cliente.getNombre()+ "','" + cliente.getApellidos() + "','" + cliente.getTelefono() + "','" + cliente.getDireccion() + "')");
            conexion.cerrarConexiones();
            return true;
        } catch (Exception e) {
            System.out.println("No se puede registrar el cliente" + e.getMessage());
            Conexion.cerrarConexiones();
            return false;
        }
    }

    public static ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> cliente = new ArrayList();
         try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select * from cliente";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                cliente.add(new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los empleados" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return cliente;
    }
    
    public static Cliente getCliente(String id){
        Cliente cliente = null;
         try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select * from cliente where id_cliente = " + id;
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                cliente = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener el empleado" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return cliente;
    }
    
    public static boolean clienteCompraRealizada(String id){
        boolean existe = false;
         try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select EXISTS (select encabezado_venta_servicio.id_clientev from encabezado_venta_servicio where encabezado_venta_servicio.id_clientev = "+ id+" )";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                existe = rs.getBoolean(1);
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener el empleado" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return existe;
    }
    
}
