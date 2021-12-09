package entidades;

public class Usuario {
    private int id;
    private String usuario;
    private String contra;
    private Empleado empleado;

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(int id, String usuario, String contra) {
        this.id = id;
        this.usuario = usuario;
        this.contra = contra;
    }

    
    
    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContra() {
        return contra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    
    
    
}
