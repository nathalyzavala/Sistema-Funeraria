/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.entidades.Cliente;
import modelo.entidades.Fiador;


public class dao_fiador {

    private static Conexion conexion;

    public dao_fiador() {
        this.conexion = new Conexion();
    }

    public void setRegistrar(Fiador fiador) {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO fiador(nombref, direccionf, telefonof, id_cliente, dui) VALUES ('" + fiador.getNombre() + "', '" + fiador.getDireccion() + "', '" + fiador.getTelefono() + "', '" + fiador.getIdcliente() + "', '" + fiador.getDui() + "')");
            conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            Conexion.cerrarConexiones();
        }
    }

    public void setModificar(Fiador fiador) {
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE fiador set nombref='" + fiador.getNombre() + "', direccionf='" + fiador.getDireccion() + "', telefonof='" + fiador.getTelefono() + "', id_cliente=" + fiador.getIdcliente() +", dui='" + fiador.getDui() + "' WHERE id_fiador=" + fiador.getIdfiador());
            conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            Conexion.cerrarConexiones();
        }
    }

    public void Eliminar(int idfiador) throws SQLException {

        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM fiador WHERE id_fiador ='" + idfiador + "'");
            Conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("Error:" + e);
            Conexion.cerrarConexiones();
        }
    }
    
    public static boolean validarDui(String dui) {
        boolean existe = false;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select EXISTS (select * from fiador where fiador.dui = '" + dui + "')";
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

    public ArrayList<Fiador> MostrarFiador() throws SQLException {
        ArrayList<Fiador> listafiador = new ArrayList<>();
        ResultSet rs = null;

        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT fiador.id_fiador, fiador.nombref, fiador.direccionf, fiador.telefonof, fiador.id_cliente, cliente.nombrec, fiador.dui FROM fiador INNER JOIN cliente ON fiador.id_cliente = cliente.id_cliente";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listafiador.add(new Fiador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
            Conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("Error al mostrar los datos" + e);
            Conexion.cerrarConexiones();
        }
        return listafiador;
    }

    public Fiador MostrarUnFiador(int id) {
        Fiador f = new Fiador();
        try {
            this.conexion.getConexion();
            Statement st = this.conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT fiador.id_fiador, fiador.nombref, fiador.direccionf, fiador.telefonof, fiador.id_cliente, fiador.dui FROM fiador WHERE fiador.id_fiador = '" + id + "'");
            
            while (rs.next()) {
                
                f.setIdfiador(rs.getInt("id_fiador"));
                f.setNombre(rs.getString("nombref"));
                f.setDireccion(rs.getString("direccionf"));
                f.setTelefono(rs.getString("telefonof"));
                f.setIdcliente(rs.getInt("id_cliente"));
                f.setDui(rs.getString("dui"));
                
            }
            conexion.cerrarConexiones();
            
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        
        return f;
    }

    public ArrayList<Cliente> MostrarCliente() throws SQLException {
        ArrayList<Cliente> listacliente = new ArrayList<>();
        ResultSet rs = null;

        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "SELECT cliente.id_cliente, cliente.nombrec FROM cliente";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listacliente.add(new Cliente(rs.getInt(1), rs.getString(2)));
            }
            Conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("Error al mostrar los datos" + e);
            Conexion.cerrarConexiones();
        }
        return listacliente;
    }
}
