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
import modeloentidad.servicio;


public class DaoServicio {
    private  Conexion conexion;
    private servicio ser;

    public DaoServicio() {
        this.conexion = new Conexion();
    }
    public void setModificar(servicio p) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE servicio SET nombre_servicio='"+p.getNombreServicio()+"' WHERE id_servicio='"+p.getId_servicio()+"';");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void setModificarPrecio(float pre ,int serv) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE servicio SET costo='"+pre+"' WHERE id_servicio='"+serv+"';");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
    public boolean setRegistrar(servicio p) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            if(!validarServicio(p.getNombreServicio())){
                st.executeUpdate("INSERT INTO servicio(costo, nombre_servicio) VALUES ('"+p.getCosto()+"', '"+p.getNombreServicio()+"');"); 
                conexion.cerrarConexiones();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
             return false;         
        }
        return false;
    }
   
    public ArrayList<servicio> getServicio(){
        ArrayList<servicio> p= new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT  * FROM servicio";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                servicio em = new servicio();
                em.setId_servicio(rs.getInt("id_servicio"));
                em.setCosto(rs.getFloat("costo"));
                em.setNombreServicio(rs.getString("nombre_servicio"));
                p.add(em);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            
        }
        return p;

    }    

    public boolean eliminar(servicio p)throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM servicio WHERE id_servicio='"+p.getId_servicio()+"';");
            conexion.cerrarConexiones();
            return true;
        } catch (SQLException e) {
           return false;
        }
    }
    public servicio getServicios(String p)throws SQLException {
       servicio em = new servicio();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_servicio, costo, nombre_servicio FROM servicio where id_servicio="+p+";");
            while (rs.next()) {
               
                em.setId_servicio(rs.getInt("id_servicio"));
                em.setCosto(rs.getFloat("costo"));
                em.setNombreServicio(rs.getString("nombre_servicio"));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("categoria");
            JOptionPane.showMessageDialog(null, "ERROR eliminar" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return em;
    }
    public static boolean validarServicio(String nombre){
        
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select nombre_servicio, id_servicio from servicio";
            PreparedStatement ps = conDB.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while (rs.next()) {                
                if(rs.getString(1).equals(nombre)){
                    return  true;
                }
            }
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los productos" + e.getMessage());
            
        }
        return false;
    }
}
