/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import conexion.Conexion;
import modelo.entidades.Clientes;

public class Dao_clientes {

    private Conexion conexion;
    private Clientes cli;

    public Dao_clientes() {
        this.conexion = new Conexion();
    }

    public void setRegistrarl(Clientes cliente) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            if (!buscarServicio(cliente.getDuic())) {
                st.executeUpdate("INSERT INTO cliente(duic, nombrec, apellidoc, telefono, direccionc) VALUES('" + cliente.getDuic() + "', '" + cliente.getNombrec() + "', '" + cliente.getApellidoc() + "', '" + cliente.getTelefono() + "', '" + cliente.getDireccionc() + "')");
            }
            conexion.cerrarConexiones();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Clientes getValidar(String dui) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente WHERE duic='" + dui + "'");
            cli = new Clientes();

            while (rs.next()) {
                cli.setId_cliente(rs.getString("id_cliente"));
                cli.setDuic(rs.getString("duic"));
                cli.setNombrec(rs.getString("nombrec"));
                cli.setApellidoc(rs.getString("apellidoc"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setDireccionc(rs.getString("direccionc"));
            }
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cli;
    }

    public Clientes getClientes(String id) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cliente WHERE id_cliente='" + id + "'");
            cli = new Clientes();

            while (rs.next()) {
                cli.setId_cliente(rs.getString("id_cliente"));
                cli.setDuic(rs.getString("duic"));
                cli.setNombrec(rs.getString("nombrec"));
                cli.setApellidoc(rs.getString("apellidoc"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setDireccionc(rs.getString("direccionc"));
            }
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cli;
    }

    public ArrayList<Clientes> getClintes() throws SQLException {
        ArrayList<Clientes> clientes = new ArrayList();
        ResultSet rs = null;

        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM cliente";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli = new Clientes();
                cli.setId_cliente(rs.getString("id_cliente"));
                cli.setDuic(rs.getString("duic"));
                cli.setNombrec(rs.getString("nombrec"));
                cli.setApellidoc(rs.getString("apellidoc"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setDireccionc(rs.getString("direccionc"));

                clientes.add(cli);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;

    }

    public void Eimininar(String cli) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("delete from fiador where id_cliente = " + cli);
            
            st.executeUpdate("DELETE FROM cliente WHERE id_cliente='" + cli + "'");
            conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public void SetModificar(Clientes cliente) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            String sql = "UPDATE cliente SET duic='" + cliente.getDuic() + "', "
                    + "nombrec='" + cliente.getNombrec() + "', "
                    + "apellidoc='" + cliente.getApellidoc() + "', "
                    + "telefono='" + cliente.getTelefono() + "', "
                    + "direccionc='" + cliente.getDireccionc() + "' "
                    + "WHERE id_cliente='" + cliente.getId_cliente() + "';";
            st.executeUpdate(sql);
            conexion.cerrarConexiones();
        } catch (Exception e) {

        }
    }

    public ArrayList<Clientes> Dui() {
        ArrayList<Clientes> clientes = new ArrayList();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT duic FROM cliente");
            cli = new Clientes();

            while (rs.next()) {
                cli.setDuic(rs.getString("duic"));
                clientes.add(cli);
            }
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }

    public boolean buscarServicio(String dui) {
        for (Clientes s : Dui()) {
            if (dui.equalsIgnoreCase(s.getDuic())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean validarDui(String dui) {
        boolean existe = false;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select EXISTS (select * from cliente where cliente.duic = '" + dui + "')";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                existe = rs.getBoolean(1);
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener el cliente" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return existe;
    }
}
