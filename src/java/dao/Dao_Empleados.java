package dao;

import conexion.Conexion;
import entidades.Cargo;
import entidades.Empleado;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_Empleados {

    public static boolean registrarEmpleado(Empleado empleado) throws SQLException {
        try {
            Conexion conexion = new Conexion();
            Statement st = conexion.getConexion().createStatement();
            st.executeUpdate("INSERT INTO empleado(nombree, apellidoe, direccion, cargo, dui, telefono, \"fechaContrato\", \"fechaNacimiento\",correo) VALUES('" + empleado.getNombre() + "','" + empleado.getApellidos() + "','" + empleado.getDirecion() + "','" + empleado.getCargo().getId() + "','" + empleado.getDui() + "','" + empleado.getTelefono() + "','" + empleado.getFechaContrato() + "','" + empleado.getFechaNacimiento() + "','" + empleado.getCorreo() + "')");
            conexion.cerrarConexiones();
            return true;
        } catch (Exception e) {
            System.out.println("No se puede registrar el empleado" + e.getMessage());
            Conexion.cerrarConexiones();
            return false;
        }
    }

    public static ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList();
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select * from empleado";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                empleados.add(new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Cargo(Dao_Cargos.getCargo(Integer.parseInt(rs.getString(5)))), rs.getString(10), rs.getString(8), rs.getString(9),rs.getString(6),rs.getString(7)));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener los empleados" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return empleados;
    }

    public static Empleado getEmpleado(String id) {
        Empleado empleado = null;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select * from empleado where id_empleado = " + id;
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado = (new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Cargo(Dao_Cargos.getCargo(Integer.parseInt(rs.getString(5)))), rs.getString(10), rs.getString(8), rs.getString(9),rs.getString(6),rs.getString(7)));
                System.out.println("dao dfecha " + rs.getString(9));
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener el empleado" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        return empleado;
    }
    
    
    public static boolean validarDui(String dui) {
        boolean existe = false;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select EXISTS (select * from empleado where empleado.dui = '" + dui + "')";
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
    

    public static String getLogin(String correo) {
        String usuario = "";
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            ResultSet rs = null;
            String sql = "select usuario.\"idUsuario\" from usuario inner join empleado on empleado.id_empleado = usuario.empleado where empleado.correo = '" + correo + "'";
            PreparedStatement ps = conDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = (rs.getInt(1)) + "";
            }
            Conexion.cerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pueden obtener el empleado" + e.getMessage());
            Conexion.cerrarConexiones();
        }
        System.out.println("usuario dao: " + usuario);
        return usuario;
    }

    public static void modificarEmpleado(Empleado empleado) {
        try {
            Conexion conexion = new Conexion();
            Statement st = conexion.getConexion().createStatement();
            st.executeUpdate("UPDATE empleado SET nombree='"+empleado.getNombre()+"', apellidoe='"+empleado.getApellidos()+"', direccion='"+empleado.getDirecion()+"', cargo='"+empleado.getCargo().getId()+"', dui='"+empleado.getDui()+"', telefono='"+empleado.getTelefono()+"', \"fechaNacimiento\"='"+empleado.getFechaNacimiento()+"', correo='"+empleado.getCorreo()+"' WHERE id_empleado = '"+empleado.getId()+"';");
            conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se puede registrar el empleado" + e.getMessage());
            Conexion.cerrarConexiones();

        }
    }
    
    public static void Eliminar(int idempleado) throws SQLException {

        try {
            Conexion conexion = new Conexion();
            Statement st = conexion.getConexion().createStatement();
            st.executeUpdate("DELETE FROM empleado WHERE id_empleado =" + idempleado + "");
            Conexion.cerrarConexiones();
        } catch (Exception e) {
            System.out.println("Error:" + e);
            Conexion.cerrarConexiones();
        }
    }

}
