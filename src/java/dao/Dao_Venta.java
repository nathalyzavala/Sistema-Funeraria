package dao;

import conexion.Conexion;
import entidades.Cliente;
import entidades.DetalleServicio;
import entidades.DetalleVenta;
import entidades.EncabezadoVenta;
import entidades.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_Venta {

    public static boolean registrarVenta(DetalleVenta venta) {
        boolean salida = false;

        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            PreparedStatement ps = conDB.prepareStatement("INSERT INTO encabezado_venta_servicio(id_empleadoe, fecha_venta, id_clientev) VALUES ('" + venta.getEncabezado().getEmpleado().getId() + "', '" + venta.getEncabezado().getFecha() + "', '" + venta.getEncabezado().getCliente().getId() + "')");
            ps.executeUpdate();

            
            int id = ultimoId();
            System.out.println("ultimo: "  + id);
            if(id==-1){
                id =0;
            }
            
            boolean devolucion = false;
            
            ArrayList<DetalleServicio> detalleVenta = Dao_Servicios.getDetalles(venta.getServicio().getId());
            System.out.println("" + detalleVenta.toString() + " tamaño: " + detalleVenta.size());
            if(detalleVenta.size()==1 && ((DetalleServicio)detalleVenta.get(0)).getProducto().getNombre().toLowerCase().contains("caja funebre")){
                devolucion = true;
            }
            System.out.println("devolucion" + devolucion);
            System.out.println("" + ultimoId());
      
            ps = conDB.prepareStatement("INSERT INTO detalle_venta(id_encabezadoventa, id_serviciod, cantidad_cuotas, estado, devolucion) VALUES ('" + id + "', '" + venta.getServicio().getId() + "', '" + venta.getCantidadCuotas() + "','t','"+ ((devolucion) ? "t": "f") +"')");
            ps.executeUpdate();
                        
            
            for (DetalleServicio detalle : Dao_Servicios.getDetalles(venta.getServicio().getId())) {
                ps = conDB.prepareStatement("select producto.id_producto, producto.existencia from producto inner join detale_servicio on producto.id_producto = detale_servicio.id_productod where detale_servicio.id_serviciod = " + venta.getServicio().getId());
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    if(rs.getInt(1)==detalle.getProducto().getId()){
                        System.out.println("modificado " + rs.getInt(2)+ " "  + " " + detalle.getCantidad() + " " + detalle.getProducto().getNombre());
                        ps = conDB.prepareStatement("UPDATE producto SET existencia=" + (rs.getInt(2) - detalle.getCantidad()) + " WHERE producto.id_producto = " + rs.getInt(1));
                        ps.executeUpdate();
                        
                    }
                }
            }
            
            salida = true;
            Conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pueden ingresar el servicio:  " + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return salida;
    }

    public static double costo(int id){
        double costo = -1;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select costo from servicio where servicio.id_servicio =  " + id;
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                costo = rs.getInt(1);
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se puede obtener el costo" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return costo;
    }
    
    
    public static boolean actualizarVenta(String id){
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            
            String sql = "update detalle_venta set estado = 'f' where id_detalleventa = " + id;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            Conexion.cerrarConexiones();
            return true;
        } catch (Exception e) {
            System.out.println("No se pueden actualizar las ventas: " + e.getMessage());
            Conexion.cerrarConexiones();
            return false;
        }
    }
    
    public static boolean eliminarVenta(int id){
        boolean salida = false;

        try {
            System.out.println("id a eliminar: " + id);
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            PreparedStatement ps = conDB.prepareStatement("delete from pago_cuotas where pago_cuotas.id_detalleventaservocio = " + id);
            ps.executeUpdate();

            ps = conDB.prepareStatement("select detalle_venta.id_encabezadoventa from detalle_venta where detalle_venta.id_detalleventa = " + id);
            ResultSet rs = ps.executeQuery();
            
            int eliminar = -1;
            if(rs.next()){
                eliminar = rs.getInt(1);
            }
            ps = conDB.prepareStatement("delete from detalle_venta where detalle_venta.id_detalleventa = " + id);
            ps.executeUpdate();
            
            ps = conDB.prepareStatement("delete from encabezado_venta_servicio where encabezado_venta_servicio.id_ventaservicio = " + eliminar);
            ps.executeUpdate();
            
            salida = true;
            Conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pueden ingresar el servicio:  " + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return salida;
    }
    
    public static int ultimoId() {

        int id = -1;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "SELECT MAX(encabezado_venta_servicio.id_ventaservicio) AS id FROM encabezado_venta_servicio";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los productos" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return id;
    }
    
    public static int ultimoIdVenta() {

        int id = -1;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "SELECT MAX(detalle_venta.id_detalleventa) AS id FROM detalle_venta";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los productos" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return id;
    }
    

    public static ArrayList<DetalleVenta> getVentas() {
        ArrayList<DetalleVenta> ventas = new ArrayList();
         try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select dv.id_detalleventa, c.duic, c.nombrec, c.apellidoc,ev.fecha_venta, dv.cantidad_cuotas, s.nombre_servicio, s.costo, s.id_servicio, dv.devolucion from cliente as c inner join encabezado_venta_servicio as ev on c.id_cliente = ev.id_clientev  inner join detalle_venta as dv on dv.id_encabezadoventa = ev.id_ventaservicio inner join servicio as s on dv.id_serviciod = s.id_servicio";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                ventas.add(new DetalleVenta(rs.getInt(1),new EncabezadoVenta(rs.getString(5), new Cliente(rs.getString(2),rs.getString(3),rs.getString(4))),new Servicio(rs.getInt(9),rs.getDouble(8),rs.getString(7)),rs.getInt(6),rs.getBoolean(10)));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los empleados" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return ventas;
    }
    

}
