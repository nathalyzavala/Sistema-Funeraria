package dao;

import conexion.Conexion;
import entidades.DetalleServicio;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_Servicios {

    public static int validarServicio(String nombre) {
        int salida = -1;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select nombre_servicio, id_servicio from servicio";
            PreparedStatement ps = conDB.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(nombre)) {
                    salida = rs.getInt(2);
                }
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los productos" + e.getMessage());
            Conexion.cerrarConexiones();

        }
        return salida;
    }

    public static ArrayList<Servicio> getServicios() {
        ArrayList<Servicio> servicios = new ArrayList();
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select * from servicio";
            PreparedStatement ps = conDB.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                servicios.add(new Servicio(rs.getInt(1), rs.getDouble(2), rs.getString(3)));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los servicios" + e.getMessage());
            Conexion.cerrarConexiones();

        }

        return servicios;
    }

    public static ArrayList<DetalleVenta> getServiciosAgregados(int id) {
        ArrayList<DetalleVenta> servicios = new ArrayList();
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select detalle_venta.id_detalleventa, servicio.id_servicio,servicio.nombre_servicio, servicio.costo from servicio inner join detalle_venta on servicio.id_servicio = detalle_venta.id_serviciod inner join encabezado_venta_servicio on encabezado_venta_servicio.id_ventaservicio = detalle_venta.id_encabezadoventa inner join cliente on encabezado_venta_servicio.id_clientev = cliente.id_cliente where detalle_venta.estado is true and cliente.id_cliente = " + id;
            PreparedStatement ps = conDB.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                servicios.add(new DetalleVenta(rs.getInt(1), new Servicio(rs.getInt(2), rs.getDouble(4), rs.getString(3))));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los servicios" + e.getMessage());
            Conexion.cerrarConexiones();

        }

        return servicios;
    }

    public static ArrayList<Producto> getExistencias(int id) {
        ArrayList<Producto> productos = new ArrayList();
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select producto.id_producto, producto.existencia from producto inner join detale_servicio  on detale_servicio.id_productod = producto.id_producto inner join servicio on servicio.id_servicio = detale_servicio.id_serviciod where servicio.id_servicio =  " + id;
            PreparedStatement ps = conDB.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                productos.add(new Producto(rs.getInt(1), rs.getInt(2)));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los servicios" + e.getMessage());
            Conexion.cerrarConexiones();
            productos = null;
        }

        return productos;
    }

    public static Servicio getServicio(String id) {
        Servicio servicios = null;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select * from servicio where id_servicio = " + id;
            PreparedStatement ps = conDB.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                servicios = new Servicio(rs.getInt(1), rs.getDouble(2), rs.getString(3));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los servicios" + e.getMessage());
            Conexion.cerrarConexiones();
        }

        return servicios;
    }

    public static boolean registrarServicio(String nombre) {
        boolean salida = false;

        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            PreparedStatement ps = conDB.prepareStatement("insert into servicio(nombre_servicio) values ('" + nombre + "')");
            ps.executeUpdate();
            salida = true;
            Conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pueden ingresar el servicio" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return salida;
    }

    public static ArrayList<DetalleServicio> getDetalles(int id) {
        ArrayList<DetalleServicio> detalles = new ArrayList();

        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select producto.id_producto, producto.nombrep, producto.preciop, producto.existencia, detale_servicio.cantidad from servicio inner join detale_servicio on detale_servicio.id_serviciod = servicio.id_servicio inner join producto on detale_servicio.id_productod = producto.id_producto where servicio.id_servicio = '" + id + "'";
            PreparedStatement ps = conDB.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                detalles.add(new DetalleServicio(new Producto(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)), rs.getInt(5)));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los productos" + e.getMessage());
            detalles = null;
            Conexion.cerrarConexiones();
        }

        return detalles;
    }

    public static ArrayList<DetalleServicio> getVenta(int id) {
        ArrayList<DetalleServicio> detalles = new ArrayList();

        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select p.nombrep, d.cantidad from producto as p inner join detale_servicio as d on d.id_productod = p.id_producto inner join servicio as s on s.id_servicio = d.id_serviciod inner join detalle_venta as dv on dv.id_serviciod = s.id_servicio where dv.id_detalleventa = " + id;
            PreparedStatement ps = conDB.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                detalles.add(new DetalleServicio(new Producto(rs.getString(1)), rs.getInt(2)));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los productos" + e.getMessage());
            Conexion.cerrarConexiones();
        }

        return detalles;

    }
    
    
    public static boolean devolucion(ArrayList<DetalleServicio> venta, int detalle){
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            PreparedStatement ps;
            
            
            for (DetalleServicio servicio : venta) {
                if(!servicio.getProducto().getNombre().toLowerCase().contains("caja funebre")){
                    String sql = "update producto set existencia = "+ (servicio.getProducto().getExistencia()+servicio.getCantidad()) +" where id_producto = "+(servicio.getProducto().getId())+"" ;
                    ps = conDB.prepareStatement(sql);
                    ps.executeUpdate();
                    System.out.println("detalle" + servicio.getId());
                    System.out.println("" + detalle);
                    sql = "update detalle_venta set devolucion = 't' where id_detalleventa = " + detalle;
                    ps = conDB.prepareStatement(sql);
                    ps.executeUpdate();
                    
                }
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error al devolver: " + e.getMessage());
            Conexion.cerrarConexiones();
            return false;
        }
    }
    
}

