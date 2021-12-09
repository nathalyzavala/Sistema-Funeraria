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
import modelo.entidades.Cargo;


public class Dao_cargo {

    private Conexion conexion;
    private Cargo cli;

    public Dao_cargo() {
        this.conexion = new Conexion();
    }

    public void setRegistrar(Cargo cargo) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            if (!buscarServicio(cargo.getNombre())) {
            st.executeUpdate("INSERT INTO cargo(nombre, salario) VALUES('" + cargo.getNombre() + "', '" + cargo.getSalario() + "')");
            }
            conexion.cerrarConexiones();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Cargo getCargoCC(String id) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cargo WHERE \"idCargo\"='" + id + "'");
            cli = new Cargo();

            while (rs.next()) {
                cli.setId_cargo(rs.getString("idCargo"));
                cli.setNombre(rs.getString("nombre"));
                cli.setSalario(rs.getDouble("salario"));
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return cli;
    }

    public ArrayList<Cargo> getCargo() throws SQLException {
        ArrayList<Cargo> cargo = new ArrayList();
        ResultSet rs = null;

        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT * FROM cargo";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli = new Cargo();
                cli.setId_cargo(rs.getString("idCargo"));
                cli.setNombre(rs.getString("nombre"));
                cli.setSalario(rs.getDouble("salario"));

                cargo.add(cli);
            }
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cargo;

    }

    public void Eimininar(String cli) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();

            st.executeUpdate("DELETE FROM cargo WHERE \"idCargo\"='" + cli + "'");
            conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("error al eliminar: " + e.getMessage());
        }
    }

    public void SetModificarC(Cargo cargo) throws SQLException {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
         
            st.executeUpdate("UPDATE cargo SET nombre='" + cargo.getNombre() + "', "
                    + "salario='" + cargo.getSalario() + "' "
                    + "WHERE \"idCargo\"='" + cargo.getId_cargo() + "';");
            conexion.cerrarConexiones();
        } catch (Exception e) {

        }
    }

    public ArrayList<Cargo> Dui() {
        ArrayList<Cargo> cargo = new ArrayList();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre FROM cargo");
            cli = new Cargo();

            while (rs.next()) {
                cli.setNombre(rs.getString("nombre"));
                cargo.add(cli);
            }
            conexion.cerrarConexiones();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cargo;
    }

    public boolean buscarServicio(String nombre) {
        for (Cargo s : Dui()) {
            if (nombre.equalsIgnoreCase(s.getNombre())) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean validarNombre(String nombre) {
        boolean existe = false;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select EXISTS (select cargo.nombre from cargo where cargo.nombre = '" + nombre + "')";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                existe = rs.getBoolean(1);
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener el cargo" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return existe;
    }

}
