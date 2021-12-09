package entidades;

public class Cliente {
    private int id;
    private String dui;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;

    public Cliente(String dui, String nombre, String apellidos, String telefono, String direccion) {
        this.dui = dui;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    
    
    public Cliente(int id, String dui, String nombre, String apellidos, String telefono, String direccion) {
        this.id = id;
        this.dui = dui;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente(String dui, String nombre, String apellidos) {
        this.dui = dui;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Cliente(int id) {
        this.id = id;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
