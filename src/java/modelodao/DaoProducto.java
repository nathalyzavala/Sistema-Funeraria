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
import modeloentidad.producto;
import modeloentidad.servicio;


public class DaoProducto {
    
    private final Conexion conexion;
    private producto producto;

    public DaoProducto() {
        this.conexion = new Conexion();
    }
    public void setModificar(producto p) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE producto SET nombrep = '"+p.getNombrproducto()+"', preciop = "+p.getPrecioproducto()+" , existencia = "+p.getCantidadproducto()+" WHERE id_producto='"+p.getIdproducto()+"';");
            
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("error al insetar producto: " + e.getMessage());
        }

    }
    
   
    public void setRegistrarP(producto p) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO producto(nombrep, preciop, existencia) VALUES ('"+p.getNombrproducto()+"', '"+p.getPrecioproducto()+"', '"+p.getCantidadproducto()+"');");
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
     public ArrayList<producto> getProductoP(){
        ArrayList<producto> p= new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT id_producto, nombrep, preciop, existencia FROM producto;";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto em = new producto();
                em.setIdproducto(rs.getInt("id_producto"));
                em.setNombrproducto(rs.getString("nombrep"));
                em.setPrecioproducto(rs.getFloat("preciop"));
                em.setCantidadproducto(rs.getInt("existencia"));
                p.add(em);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e){
            System.out.println("Error:"+e.getMessage());
             JOptionPane.showMessageDialog(null, "ERROR:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return p;

    }
   

    public boolean eliminar(producto p)throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM producto where id_producto='"+p.getIdproducto()+"';");
            conexion.cerrarConexiones();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
  
    public producto getProducto(String p)throws SQLException {
         producto em = new producto();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_producto, nombrep, preciop, existencia FROM producto where id_producto='"+p+"';");
            while (rs.next()) {
               em.setIdproducto(rs.getInt("id_producto"));
                em.setNombrproducto(rs.getString("nombrep"));
                em.setPrecioproducto(rs.getFloat("preciop"));
                em.setCantidadproducto(rs.getInt(" existencia"));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("Error:"+e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR eliminar" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return em;
    }
    public producto getProdu(String p)throws SQLException {
       producto em = new producto();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_producto, nombrep, preciop, existencia FROM producto where id_producto='"+p+"';");
            while (rs.next()) {
                em.setIdproducto(rs.getInt("id_producto"));
                em.setNombrproducto(rs.getString("nombrep"));
                em.setPrecioproducto(rs.getFloat("preciop"));
                em.setCantidadproducto(rs.getInt("existencia"));
            }
            System.out.println("entro get");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("categoria");
            JOptionPane.showMessageDialog(null, "ERROR eliminar" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return em;
    }
}

