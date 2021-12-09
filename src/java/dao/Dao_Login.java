
package dao;

import conexion.Conexion;
import entidades.Encriptacion;
import entidades.Usuario;
import java.sql.*;

public class Dao_Login {
    public static boolean iniciarSesion(String usuario, String contrasena){
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            String sql = "select contrasena from usuario inner join empleado on empleado.id_empleado = usuario.empleado where usuario.usuario = '" + usuario + "'";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                if(contrasena.equals(rs.getString(1))){
                    return true;
                }
            }
            
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesion");
            Conexion.cerrarConexiones();
        }
        return false;
    }
    
    public static boolean cambiarCredenciales(Usuario usuario){
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            String sql;
            if(usuario.getUsuario().isEmpty()){
                sql = "update usuario set contrasena = '"+Encriptacion.sha1(usuario.getContra())+"' where \"idUsuario\" = " + usuario.getId();
            }else{
                sql = "update usuario set usuario = '"+Encriptacion.sha1(usuario.getUsuario())+"', contrasena = '"+Encriptacion.sha1(usuario.getContra())+"' where \"idUsuario\" = " + usuario.getId();
            }
            
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.executeUpdate();
            
            Conexion.cerrarConexiones();
            return true;
            
        } catch (SQLException e) {
            System.out.println("NO se puede cambiar las credenciales");
            Conexion.cerrarConexiones();
            return false;
        }
        
    }
    
    public static boolean existeCorreo(String email){
        boolean existe = false;
        try {
            Conexion con = new Conexion();
            Connection conDB = con.getConexion();
            String sql = "SELECT EXISTS(SELECT empleado.correo FROM empleado inner join usuario on usuario.empleado = empleado.id_empleado WHERE empleado.correo='"+email+"')";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getBoolean(1));
                if(rs.getBoolean(1)){
                    existe = rs.getBoolean(1);
                }
            }
            
        } catch (SQLException e) {
            System.out.println("No existe el correo");
            Conexion.cerrarConexiones();
        }
        return existe;
    }
    
    
}
