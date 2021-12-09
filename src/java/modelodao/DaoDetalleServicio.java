/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import conexion.Conexion;
import modeloentidad.DetalleServ;
import modeloentidad.producto;
import modeloentidad.servicio;


public class DaoDetalleServicio {

    private Conexion conexion;
    private DetalleServ detalleServiocio;
    public DaoDetalleServicio() {
        this.conexion = new Conexion();
    }
    public void setModificar(DetalleServ detalle) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE detale_servicio SET id_productod='"+detalle.getId_producto()+"',cantidad='"+detalle.getCantidad()+"' WHERE id_detalleservicio='"+detalle.getId_detalleservicio()+"';");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void setRegistrar(DetalleServ detalle) throws SQLException {
        try {
             this.conexion.getConexion();
             Statement st = this.conexion.getConexion().createStatement();
            DetalleServ de=validarServicio(Integer.parseInt(""+detalle.getId_producto()+""),Integer.parseInt(""+detalle.getId_servicio()+""));
            if(de==null){
               st.executeUpdate("INSERT INTO detale_servicio(id_serviciod, id_productod, cantidad) VALUES ('"+detalle.getId_servicio()+"','"+detalle.getId_producto()+"','"+detalle.getCantidad()+"');");
        //new modelodao.DaoServicio().setModificarPrecio(PrecioServicios(Integer.parseInt(""+detalle.getId_servicio()+"")),detalle.getId_servicio());
            }else{
               st.executeUpdate("UPDATE detale_servicio SET cantidad='"+(de.getCantidad()+detalle.getCantidad())+"' WHERE id_detalleservicio='"+de.getId_detalleservicio()+"';");
         // new modelodao.DaoServicio().setModificarPrecio(PrecioServicios(Integer.parseInt(""+detalle.getId_servicio()+"")),detalle.getId_servicio());
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("MSDFDSF>"+e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ArrayList<DetalleServ> getDetallesServicios() throws SQLException {
        ArrayList<DetalleServ> detalleS = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT  * FROM detale_servicio;";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleServ em = new DetalleServ();
                em.setId_detalleservicio(rs.getInt("id_detalleservicio"));
                em.setId_servicio(rs.getInt("id_serviciod"));
                em.setId_producto(rs.getInt("id_productod"));
                em.setCantidad(rs.getInt("cantidad"));
                detalleS.add(em);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return detalleS;

    }
     public ArrayList<DetalleServ> getDetallesServiciosProductos(int ide) throws SQLException {
        ArrayList<DetalleServ> detalleS = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT pro.nombrep,detalle.id_detalleservicio,detalle.id_serviciod,detalle.id_productod,detalle.cantidad  FROM detale_servicio AS detalle INNER JOIN producto AS pro ON detalle.id_productod = pro.id_producto where id_serviciod='"+ide+"'" ;
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleServ em = new DetalleServ();
                em.setId_detalleservicio(rs.getInt("id_detalleservicio"));
                em.setId_producto(rs.getInt("id_productod"));
                em.setProdu(new producto(rs.getString("nombrep")));
                em.setCantidad(rs.getInt("cantidad"));
                detalleS.add(em);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return detalleS;

    }
    
    public  ArrayList<servicio> getServicios()throws SQLException{
        ArrayList<servicio> detalleS = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * from servicio";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                servicio em = new servicio();
                em.setId_servicio(rs.getInt("id_servicio"));
                em.setCosto(rs.getFloat("costo"));
                em.setNombreServicio(rs.getString("nombre_servicio"));
                detalleS.add(em);
                System.out.println("lista llena dde servicio");
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR eliminar" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println("error mostrAR LISTa");
        }
        return detalleS;

    }
    

    public boolean eliminar(DetalleServ deta)throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM detale_servicio WHERE id_detalleservicio='"+deta.getId_detalleservicio()+"';");
            conexion.cerrarConexiones();
            return true;
        } catch (SQLException e) {
          return false;
        }
    }
    public DetalleServ getDetalle(String ide)throws SQLException {
         DetalleServ em = new DetalleServ();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_detalleservicio, id_serviciod, id_productod, cantidad FROM detale_servicio where id_detalleservicio='"+ide+"';");
            DetalleServ m= new DetalleServ();
            while (rs.next()) {
               
                em.setId_detalleservicio(rs.getInt("id_detalleservicio"));
                em.setId_servicio(rs.getInt("id_serviciod"));
                em.setId_producto(rs.getInt("id_productod"));
                em.setCantidad(rs.getInt("cantidad"));
            }
            System.out.println("entro get");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("categoria");
            JOptionPane.showMessageDialog(null, "ERROR eliminar" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return em;
    }
    public float PrecioServicios(int serv){
      DetalleServ em = new DetalleServ();
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "SELECT\n" +
"Sum(pro.preciop*de.cantidad),\n" +
"ser.nombre_servicio\n" +
"FROM\n" +
"detale_servicio AS de\n" +
"INNER JOIN producto AS pro ON de.id_productod = pro.id_producto\n" +
"INNER JOIN servicio AS ser ON de.id_serviciod = ser.id_servicio\n" +
"WHERE ser.id_servicio='"+serv+"'\n" +
"GROUP BY ser.nombre_servicio";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                return rs.getFloat(1);
            }
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los productos" + e.getMessage());
            
        }
        return 0;
    }
    
    public DetalleServ validarServicio(int pro,int ser){
      DetalleServ em = new DetalleServ();
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "SELECT id_detalleservicio, id_serviciod, id_productod, cantidad FROM detale_servicio";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                if(rs.getInt(3)==pro && rs.getInt(2)==ser){
                    em.setId_detalleservicio(rs.getInt("id_detalleservicio"));
                    em.setId_servicio(rs.getInt("id_serviciod"));
                    em.setId_producto(rs.getInt("id_productod"));
                    em.setCantidad(rs.getInt("cantidad"));
                    return em;
                }
            }
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los productos" + e.getMessage());
            
        }
        return null;
    }
    
    
}
