package entidades;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int existencia;

    public Producto(int id, String nombre, double precio, int existencia) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
    }

    public Producto(int id, int existencia) {
        this.id = id;
        this.existencia = existencia;
    }

    
    
    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    
    
}
