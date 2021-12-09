package entidades;

public class Servicio {
    private int id;
    private double costo;
    private String nombre;

    public Servicio(int id, double costo, String nombre) {
        this.id = id;
        this.costo = costo;
        this.nombre = nombre;
    }

    public Servicio(double costo, int id) {
        this.costo = costo;
        this.id = id;
    }

    public Servicio(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
